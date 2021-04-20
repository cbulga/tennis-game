package com.cristianbulgarelli.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "name", callSuper = true)
@Getter
public class SetScore extends BaseStatusSupplier {

    @NonNull
    private final Set set;
    private List<GameScore> gameScores;
    private final Player player1;
    private final Player player2;

    public SetScore(@NonNull Set set, Player player1, Player player2) {
        this.set = set;
        this.gameScores = new ArrayList<>();
        this.player1 = player1;
        this.player2 = player2;
    }

    @Deprecated
    public GameScore addGameScore(String gameName) {
        GameScore gameScore = GameScore.builder()
                .game(new Game(gameName))
                .playerScore1(PlayerScore.builder()
                        .player(player1)
                        .build())
                .playerScore2(PlayerScore.builder()
                        .player(player2)
                        .build())
                .build();
        if (gameScores == null)
            gameScores = new ArrayList<>();
        gameScores.add(gameScore);
        return gameScore;
    }

    public void addGameScore(GameScore gameScore) {
        if (gameScores == null)
            gameScores = new ArrayList<>();
        gameScores.add(gameScore);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(set).append(" -- ");
        getGameScores().forEach(sb::append);
        return sb.toString();
    }
}
