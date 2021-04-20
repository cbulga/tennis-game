package com.cristianbulgarelli.util;

import com.cristianbulgarelli.model.Player;
import org.apache.commons.lang3.RandomUtils;

public class Utils {

    public static Player randomPlayer(Player player1, Player player2) {
        return RandomUtils.nextBoolean() ? player1 : player2;
    }
}
