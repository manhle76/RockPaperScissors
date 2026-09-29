public class Main {
    public static void main(String[] args) {
        // Create the two players: a human player and a computer player.
        Player player1 = new HumanPlayer("Human");
        Player player2 = new ComputerPlayer("Computer");

        // Create a game using the two players.
        Game game = new Game(player1, player2);

        // Set the total number of rounds to play.
        int numberOfRound = 20;
        int start = 1;

        // Continue playing until all rounds are completed.
        while (start <= numberOfRound) {
            // Display the current round number.
            System.out.printf("Round %d - Choose (1=rock, 2=paper, 3=scissors) \n", start);
            // Play one round.
            game.play();
            // Display the current score.
            game.displayScore();
            // Move to the next round.
            start++;
            // Print a separator between rounds.
            System.out.println("----------------------------------------------------");
        }
    }
}
