package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SetScoresEvaluatorImplTest {

    private static final Player PLAYER_1 = new Player("Federer");
    private static final Player PLAYER_2 = new Player("Nadal");
    private SetScoresEvaluator sut;

    @BeforeEach
    public void beforeEach() {
        sut = new SetScoresEvaluatorImpl();
    }

    @Test
    void evaluateWinner_player1Wins_Ok() {
        // setup
        int i = 1;
        SetScore setScore1 = new SetScore(new Set("1"), PLAYER_1, PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        // test & assertions
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
    }

    @Test
    void evaluateWinner_player2Wins_Ok() {
        // setup
        int i = 1;
        SetScore setScore1 = new SetScore(new Set("1"), PLAYER_1, PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_2);
        // test & assertions
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_2);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_2);
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNull();
        addGameScore(setScore1, "" + i++, PLAYER_1);
        assertThat(sut.evaluateWinner(setScore1)).isNotNull().isEqualTo(PLAYER_1);
    }

    private void addGameScore(SetScore setScore1, String gameName, Player winner) {
        PlayerScore playerScore1 = PlayerScore.builder().player(PLAYER_1).score(Score.ZERO).build();
        PlayerScore playerScore2 = PlayerScore.builder().player(PLAYER_2).score(Score.ZERO).build();
        GameScore game = GameScore.builder().game(Game.builder().name(gameName).status(Status.FINISHED).build())
                .playerScore1(playerScore1)
                .playerScore2(playerScore2)
                .servingPlayer(PLAYER_1)
                .winner(winner)
                .finished(winner != null)
                .build();
        setScore1.getGameScores().add(game);
    }
}