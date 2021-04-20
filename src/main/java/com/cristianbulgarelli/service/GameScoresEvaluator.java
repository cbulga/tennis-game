package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.PlayerScore;

public interface GameScoresEvaluator {

    Player evaluateWinner(PlayerScore playerScore1, PlayerScore playerScore2);
}
