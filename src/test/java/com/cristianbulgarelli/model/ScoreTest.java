package com.cristianbulgarelli.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void test() {
        assertThat(Score.ZERO.getNext()).isNotNull().isEqualTo(Score.FIFTEEN);
        assertThat(Score.FIFTEEN.getNext()).isNotNull().isEqualTo(Score.THIRTY);
        assertThat(Score.THIRTY.getNext()).isNotNull().isEqualTo(Score.FORTY);
        assertThat(Score.FORTY.getNext()).isNotNull().isEqualTo(Score.GAME);
    }
}