public class Main {
    public static void main(String[] args) {

        // Create the two players: a human player and a computer player.
        Player player1 = new HumanPlayer("Humman");
        Player player2 = new ComputerPlayer("Computer");

        // Create a game using the two players.
        Game game = new Game(player1, player2);

        // Set the total number of rounds to play.
        int numberOfRound = 5;
        int start = 1;

        // Continue playing until all rounds are completed.
        while (start <= numberOfRound) {

            // Display the current round number.
            System.out.println("Round " + start);

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
