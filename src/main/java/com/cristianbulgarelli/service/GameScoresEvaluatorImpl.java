package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.PlayerScore;
import com.cristianbulgarelli.model.Score;

public class GameScoresEvaluatorImpl implements GameScoresEvaluator {

    @Override
    public Player evaluateWinner(PlayerScore playerScore1, PlayerScore playerScore2) {
        if (playerScore1.getScore().getSequence() > Score.FORTY.getSequence()
            && playerScore1.getScore().getSequence() >= playerScore2.getScore().getSequence() + 2)
            return playerScore1.getPlayer();
        else if (playerScore2.getScore().getSequence() > Score.FORTY.getSequence()
                && playerScore2.getScore().getSequence() >= playerScore1.getScore().getSequence() + 2)
            return playerScore2.getPlayer();
        else
            return null;
    }
}
