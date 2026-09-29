import java.util.Random;

public class ComputerPlayer implements Player {
    // Stores the computer player's name.
    private String name;
    private Random rd;

    public ComputerPlayer(String name) {
        this.name = name;
        this.rd = new Random();
    }

    // Returns the computer player's name.
    public String getName() {
        return this.name;
    }

    // Randomly selects and returns a move.
    public Move move() {
        // Generate a random number from 1 to 3.
        int choiceInInteger = rd.nextInt(3) + 1;

        // Convert the number into a Move.
        Move choice = convert(choiceInInteger);

        // Display the computer's choice.
        display(choice);

        // Return the computer's chosen move.
        return choice;
    }
}
