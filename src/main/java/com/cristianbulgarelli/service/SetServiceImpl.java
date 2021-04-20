package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.*;
import com.cristianbulgarelli.util.Utils;
import org.apache.commons.lang3.RandomUtils;

public class SetServiceImpl implements SetService {

    private GameService gameService;
    private SetScoresEvaluator setScoresEvaluator;

    public SetServiceImpl() {
        // FIXME: dependency injection
        this.gameService = new GameServiceImpl();
        this.setScoresEvaluator = new SetScoresEvaluatorImpl();
    }

    @Override
    public SetScore play(Set set, Player player1, Player player2) {
        SetScore setScore = new SetScore(set, player1, player2);
        Player servingPlayer = Utils.randomPlayer(player1, player2);
        Player setWinner = null;

        int i = 1;
        while (setWinner == null) {
            // playing game
            System.out.println("Game " + i++);
            setScore.addGameScore(gameService.play(new Game("" + i), player1, player2, servingPlayer));

            // updating serving player
            servingPlayer = servingPlayer.equals(player1) ? player2 : player1;

            setWinner = setScoresEvaluator.evaluateWinner(setScore);

            if (setWinner != null) {
                setScore.setFinished(true);
                setScore.setWinner(setWinner);
                System.out.println("Set won by " + setWinner);
            } else
                System.out.println(setScore);
        }

        return setScore;
    }
}
