package com.cristianbulgarelli.model;

import lombok.*;

import java.io.Serializable;
import java.util.function.Supplier;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
public class PlayerScore implements Serializable {

    @NonNull
    private final Player player;
    @NonNull
    @Builder.Default
    private Score score = Score.ZERO;

    @Override
    public String toString() {
        return player + ": " + score;
    }
}
