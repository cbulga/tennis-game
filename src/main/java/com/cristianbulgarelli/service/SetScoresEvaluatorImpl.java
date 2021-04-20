package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.SetScore;

import java.util.Arrays;

public class SetScoresEvaluatorImpl implements SetScoresEvaluator {

    @Override
    public Player evaluateWinner(SetScore setScore) {
        System.out.println("--------------------");
        final Integer[] i = {0};
        long player1WinCount = setScore.getGameScores().stream()
                .filter(gs -> gs.isFinished() && gs.getPlayerScore1().getPlayer().equals(gs.getWinner()))
//                .peek(gs -> System.out.println("" + (i[0]++) + gs))
                .count();
        System.out.println(setScore.getPlayer1() + " win count: " + player1WinCount);
        i[0] = 0;
        long player2WinCount = setScore.getGameScores().stream()
                .filter(gs -> gs.isFinished() && gs.getPlayerScore2().getPlayer().equals(gs.getWinner()))
//                .peek(gs -> System.out.println("" + (i[0]++) + gs))
                .count();
        System.out.println(setScore.getPlayer2() + " win count: " + player2WinCount);
        if (player1WinCount >= 6 && player2WinCount <= player1WinCount - 2) {
            System.out.println("Winner: " + setScore.getPlayer1());
            return setScore.getPlayer1();
        } else if (player2WinCount >= 6 && player1WinCount <= player2WinCount - 2) {
            System.out.println("Winner: " + setScore.getPlayer2());
            return setScore.getPlayer2();
        } else {
            System.out.println("No winner");
            return null;
        }
    }
}
