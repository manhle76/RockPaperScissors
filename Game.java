public class Game {
    // Stores the rules used to determine the result of each round.
    private Rule rule;

    // Stores the two players in the game.
    private Player firstPlayer;
    private Player secondPlayer;

    // Stores the number of wins for each player and the number of ties.
    // Index 1 = first player, index 2 = second player, index 3 = ties.
    private int[] score;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

        // Create the object that determines the result of each round.
        this.rule = new Rule();

        // Create an array to keep track of the scores.
        this.score = new int[4];
    }

    public void play() {
        // Get the moves from both players.
        Move firstPlayerMove = firstPlayer.move();
        Move secondPlayerMove = secondPlayer.move();

        // Determine the result using the game rules.
        int result = rule.result(firstPlayerMove, secondPlayerMove);

        // Update the score based on the result.
        score[result]++;
    }

    public void displayScore() {
        // Display the current scores.
        System.out.println("------------SCORE------------");
        System.out.println(firstPlayer.getName() + ": " + score[1]);
        System.out.println(secondPlayer.getName() + ": " + score[2]);
        System.out.println("Ties: " + score[3]);
    }
}
