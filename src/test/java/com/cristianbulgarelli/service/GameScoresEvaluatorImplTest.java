package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.PlayerScore;
import com.cristianbulgarelli.model.Score;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameScoresEvaluatorImplTest {

    private static final Player PLAYER1 = new Player("Federer");
    private static final Player PLAYER2 = new Player("Federer");

    @ParameterizedTest
    @MethodSource("provideEvaluateWinnerArguments")
    void evaluateWinner_1_Ok(PlayerScore playerScore1, PlayerScore playerScore2, Player expectedWinner) {
        // setup
        GameScoresEvaluator sut = new GameScoresEvaluatorImpl();
        // test
        Player actualWinner = sut.evaluateWinner(playerScore1, playerScore2);
        // assertions
        assertThat(actualWinner).isEqualTo(expectedWinner);
    }

    private static Stream<Arguments> provideEvaluateWinnerArguments() {

        return Stream.of(
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.FIFTEEN).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.THIRTY).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.FORTY).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.ADVANTAGE).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.GAME).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FIFTEEN).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FIFTEEN).build(), PlayerScore.builder().player(PLAYER2).score(Score.ADVANTAGE).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FIFTEEN).build(), PlayerScore.builder().player(PLAYER2).score(Score.GAME).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.THIRTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.THIRTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.ADVANTAGE).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.THIRTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.GAME).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FORTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.ADVANTAGE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FORTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.GAME).build(), PLAYER2),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.ADVANTAGE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.GAME).build(), PLAYER2),

                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FIFTEEN).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ZERO).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.THIRTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.FORTY).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ADVANTAGE).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.GAME).build(), PlayerScore.builder().player(PLAYER2).score(Score.ZERO).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.FIFTEEN).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ADVANTAGE).build(), PlayerScore.builder().player(PLAYER2).score(Score.FIFTEEN).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.GAME).build(), PlayerScore.builder().player(PLAYER2).score(Score.FIFTEEN).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.THIRTY).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ADVANTAGE).build(), PlayerScore.builder().player(PLAYER2).score(Score.THIRTY).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.GAME).build(), PlayerScore.builder().player(PLAYER2).score(Score.THIRTY).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.FORTY).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ADVANTAGE).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.GAME).build(), PlayerScore.builder().player(PLAYER2).score(Score.FORTY).build(), PLAYER1),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.DEUCE).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.ADVANTAGE).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), null),
                Arguments.of(PlayerScore.builder().player(PLAYER1).score(Score.GAME).build(), PlayerScore.builder().player(PLAYER2).score(Score.DEUCE).build(), PLAYER1)
        );
    }
}