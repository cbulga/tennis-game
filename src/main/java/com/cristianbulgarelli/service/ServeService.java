package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;

/**
 * @deprecated
 */
@Deprecated
public interface ServeService {

    /**
     * Returns the {@link Player} who wins.
     *
     * @param player1
     * @param player2
     * @return the {@link Player} who wins.
     */
    Player serve(Player player1, Player player2);
}
