package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import org.apache.commons.lang3.RandomUtils;

/**
 * @deprecated
 */
@Deprecated
public class ServeServiceImpl implements ServeService {

    @Override
    public Player serve(Player player1, Player player2) {
        return RandomUtils.nextBoolean() ? player1 : player2;
    }
}
