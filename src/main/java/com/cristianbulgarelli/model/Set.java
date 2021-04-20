package com.cristianbulgarelli.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(of = "name")
public class Set implements Serializable {

    @NonNull
    private final String name;
    @NonNull
    @Setter
    private Status status = Status.IN_PROGRESS;
    @Setter
    private Player winner;
    private List<GameScore> gameScores;

    public void addGameScore(@NonNull GameScore gameScore) {
        if (gameScores == null)
            gameScores = new ArrayList<>();
        gameScores.add(gameScore);
    }

    @Override
    public String toString() {
        return "Set " + this.getName();
    }
}
