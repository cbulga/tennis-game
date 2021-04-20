package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.*;
import com.cristianbulgarelli.util.Utils;

public class GameServiceImpl implements GameService {

    private GameScoresEvaluator gameScoresEvaluator;

    public GameServiceImpl() {
        // FIXME: dependency injection
        this.gameScoresEvaluator = new GameScoresEvaluatorImpl();
    }

    @Override
    public GameScore play(Game game, Player player1, Player player2, Player servingPlayer) {
        // FIXME: use factories...
        PlayerScore playerScore1 = PlayerScore.builder()
                .player(player1)
                .score(Score.ZERO)
                .build();
        PlayerScore playerScore2 = PlayerScore.builder()
                .player(player2)
                .score(Score.ZERO)
                .build();
        GameScore gameScore = GameScore.builder()
                .game(game)
                .playerScore1(playerScore1)
                .playerScore2(playerScore2)
                .servingPlayer(servingPlayer)
                .build();

        while (!gameScore.isFinished()) {
            // serve
            Player winner = Utils.randomPlayer(player1, player2);

            // updating scores
            if (winner.equals(player1))
                playerScore1.setScore(playerScore1.getScore().getNext());
            else
                playerScore2.setScore(playerScore2.getScore().getNext());
            if (Score.FORTY == playerScore1.getScore() && Score.FORTY == playerScore2.getScore()
                || Score.ADVANTAGE == playerScore1.getScore() && Score.ADVANTAGE == playerScore2.getScore()) {
                playerScore1.setScore(Score.DEUCE);
                playerScore2.setScore(Score.DEUCE);
            }

            // evaluating scores
            Player gameWinner = gameScoresEvaluator.evaluateWinner(playerScore1, playerScore2);
            if (gameWinner != null) {
                gameScore.getGame().setStatus(Status.FINISHED);
                gameScore.getGame().setWinner(gameWinner);
                gameScore.setFinished(true);
                gameScore.setWinner(gameWinner);
                System.out.println("Game won by " + gameWinner);
            } else
                System.out.println(gameScore);
        }

        return gameScore;
    }
}
