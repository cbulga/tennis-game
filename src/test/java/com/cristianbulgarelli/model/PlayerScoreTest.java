package com.cristianbulgarelli.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerScoreTest {

    @Test
    void toString_Ok() {
        // setup
        PlayerScore playerScore = PlayerScore.builder()
                .player(Player.builder().name("Federer").build())
                .score(Score.FIFTEEN)
                .build();
        // test & assertions
        assertThat(playerScore.toString()).isNotNull().isEqualTo("Federer: 15");
    }
}