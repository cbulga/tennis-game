package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.GameScore;
import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.SetScore;

public interface SetScoresEvaluator {

    Player evaluateWinner(SetScore setScore);
}
