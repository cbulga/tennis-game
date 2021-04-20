package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Game;
import com.cristianbulgarelli.model.GameScore;
import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    private GameServiceImpl sut;

    @BeforeEach
    public void beforeEach() {
        sut = new GameServiceImpl();
    }

    @Test
    void play_Ok() {
        // setup
        Game game = new Game("1");
        Player player1 = new Player("Federer");
        Player player2 = new Player("Nadal");
        // test
        GameScore actual = sut.play(game, player1, player2, player1);
        // assertions
        assertThat(actual).isNotNull();
        assertThat(actual.getGame()).isNotNull();
        assertThat(actual.getGame().getStatus()).isNotNull();
        assertThat(actual.getGame().getStatus()).isEqualTo(Status.FINISHED);
    }
}