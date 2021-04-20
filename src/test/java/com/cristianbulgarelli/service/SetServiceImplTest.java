package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.Set;
import com.cristianbulgarelli.model.SetScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SetServiceImplTest {

    private static final Player PLAYER_1 = new Player("Federer");
    private static final Player PLAYER_2 = new Player("Nadal");
    private SetService sut;

    @BeforeEach
    public void beforeEach() {
        this.sut = new SetServiceImpl();
    }

    @Test
    void play_Ok() {
        // setup
        Set set = new Set("1");
        // test
        SetScore actual = sut.play(set, PLAYER_1, PLAYER_2);
        // assertions
        assertThat(actual).isNotNull();
        assertThat(actual.getPlayer1()).isNotNull();
        assertThat(actual.getPlayer1()).isEqualTo(PLAYER_1);
        assertThat(actual.getPlayer2()).isNotNull();
        assertThat(actual.getPlayer2()).isEqualTo(PLAYER_2);
        assertThat(actual.getGameScores()).isNotNull();
        assertThat(actual.getGameScores().size()).isGreaterThanOrEqualTo(6);
        assertThat(actual.getWinner()).isNotNull();
    }
}