package com.cristianbulgarelli.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SetScoreTest {

    @Test
    void toString_Ok() {
        // setup
        SetScore setScore = new SetScore(new Set("1"), new Player("player 1"), new Player("player 2"));
        // test & assertions
        assertThat(setScore.toString()).isNotNull().isEqualTo("");
    }
}