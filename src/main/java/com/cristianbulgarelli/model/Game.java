package com.cristianbulgarelli.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "name")
@Builder
public class Game implements Serializable {

    @NonNull
    private final String name;
    @NonNull
    @Setter
    @Builder.Default
    private Status status = Status.IN_PROGRESS;
    @Setter
    private Player winner;

    public Game(@NonNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
