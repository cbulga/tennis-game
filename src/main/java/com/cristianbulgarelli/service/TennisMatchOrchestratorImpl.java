package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.MatchScore;
import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.SetScore;

public class TennisMatchOrchestratorImpl implements TennisMatchOrchestrator {

    @Override
    public MatchScore playMatch(String matchName, int setCount, Player[] players) {
        // FIXME: factories...
        SetScore[] setScores = new SetScore[setCount];
        MatchScore matchScore = new MatchScore(matchName, setScores);
        return matchScore;
    }
}
