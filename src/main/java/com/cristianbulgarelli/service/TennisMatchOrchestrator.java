package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.MatchScore;
import com.cristianbulgarelli.model.Player;

public interface TennisMatchOrchestrator {

    MatchScore playMatch(String matchName, int setCount, Player[] players);
}
