package com.cristianbulgarelli.service;

import com.cristianbulgarelli.model.Player;
import com.cristianbulgarelli.model.Set;
import com.cristianbulgarelli.model.SetScore;

public interface SetService {

    SetScore play(Set set, Player player1, Player player2);
}
