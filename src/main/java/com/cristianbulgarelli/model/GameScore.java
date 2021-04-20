package com.cristianbulgarelli.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode(of = "game", callSuper = true)
public class GameScore extends BaseStatusSupplier {

    @NonNull
    @Getter
    private final Game game;
    @NonNull
    @Getter
    private final PlayerScore playerScore1;
    @NonNull
    @Getter
    private final PlayerScore playerScore2;
    @NonNull
    @Getter
    private final Player servingPlayer;

    @Override
    public boolean isFinished() {
        return Status.FINISHED == this.game.getStatus();
    }

    @Override
    public String toString() {
        return game + " (serving player: " + servingPlayer + ") --- " + playerScore1 + " - " + playerScore2;
    }
}
