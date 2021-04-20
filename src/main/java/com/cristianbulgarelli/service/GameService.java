package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Game;
import com.cristianbulgarelli.model.GameScore;
import com.cristianbulgarelli.model.Player;

public interface GameService {

    GameScore play(Game game, Player player1, Player player2, Player servingPlayer);
}
