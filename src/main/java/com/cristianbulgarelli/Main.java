package com.cristianbulgarelli;

import com.cristianbulgarelli.model.Player;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Tennis Game!");
        System.out.println("-----------------------");

        if (args == null || args.length != 2) {
            System.out.println("It is required to provide two arguments: <player 1> and <player 2>");
            System.out.println("Example: java -jar target/tennis-game-1.0-SNAPSHOT.jar Federer Nadal");
            return;
        }

        Player player1 = new Player(args[0]);
        Player player2 = new Player(args[1]);
        System.out.println("Player 1: " + player1);
        System.out.println("Player 1: " + player2);

    }
}
