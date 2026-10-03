import java.io.FileWriter;
import java.io.IOException;

public class Game {
    // Stores the rules used to determine the result of each round.
    private GameRule rule;
    // Stores the two players in the game.
    private Player firstPlayer;
    private Player secondPlayer;
    // Stores the number of wins for each player and the number of ties.
    // Index 1 = first player, index 2 = second player, index 0 = ties.
    private int[] score;

    public Game(Player firstPlayer, Player secondPlayer, GameRule rule) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        // Create the object that determines the result of each round.
        this.rule = rule;
        // Create an array to keep track of the scores.
        this.score = new int[3];
    }

    public void play() {
        // Get the moves from both players.
        Move firstPlayerMove = firstPlayer.move();
        Move secondPlayerMove = secondPlayer.move();

        // Determine the result using the game rules.
        int result = rule.result(firstPlayerMove, secondPlayerMove);
        // Update the score based on the result.
        score[result]++;

        // Display the winner
        if (result == 1) {
            System.out.println(firstPlayer.getNamePlayer() + " Wins!");
        } else if (result == 2) {
            System.out.println(secondPlayer.getNamePlayer() + " Wins!");
        } else {
            System.out.println("Draw!");
        }
    }

    public void displayScore() {
        // Display the current scores.
        System.out.println("------------SCORE------------");
        System.out.println(firstPlayer.getNamePlayer() + ": " + score[1]);
        System.out.println(secondPlayer.getNamePlayer() + ": " + score[2]);
        System.out.println("Ties: " + score[0]);
    }

    public void store(Move firstMove, Move secondMove) {
        try {
            FileWriter write = new FileWriter("sequency");
            if (move == Move.ROCK) {
                sequences.append("R");
            } else if (move == Move.PAPER) {
                sequences.append("P");
            } else if (move == Move.SCISSORS) {
                sequences.append("S");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
