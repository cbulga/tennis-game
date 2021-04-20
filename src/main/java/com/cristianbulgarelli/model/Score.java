package com.cristianbulgarelli.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Score {

    ZERO("0", 1),
    FIFTEEN("15", 2),
    THIRTY("30", 3),
    FORTY("40", 4),
    DEUCE("Deuce", 5),
    ADVANTAGE("Advantage", 6),
    GAME("Game", 7);

    private final String score;
    private final int sequence;

    private static Score getBySequence(int sequence) {
        return Arrays.stream(values())
                .filter(s -> s.getSequence() == sequence)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Unattended sequence value: %s", sequence)));
    }

    public Score getNext() {
        int nextSequence = this.getSequence() % values().length + 1;
        return getBySequence(nextSequence);
    }

    @Override
    public String toString() {
        return this.getScore();
    }
}
