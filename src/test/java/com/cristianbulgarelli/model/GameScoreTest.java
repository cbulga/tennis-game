package com.cristianbulgarelli.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameScoreTest {

    @Test
    void toString_Ok() {
        // setup
        Player servingPlayer = new Player("Nadal");
        GameScore gameScore = GameScore.builder()
                .game(new Game("Game 1"))
                .playerScore1(PlayerScore.builder()
                        .player(new Player("Federer"))
                        .score(Score.FIFTEEN)
                        .build())
                .playerScore2(PlayerScore.builder()
                        .player(servingPlayer)
                        .score(Score.FORTY)
                        .build())
                .servingPlayer(servingPlayer)
                .build();
        // test & assertions
        System.out.println(gameScore.toString());
        assertThat(gameScore.toString()).isNotNull().isEqualTo(gameScore.getGame() + " (serving player: " + servingPlayer + ") --- " + gameScore.getPlayerScore1() + " - " + gameScore.getPlayerScore2());
    }
}