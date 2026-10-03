import java.util.Random;

public class ComputerPlayer implements Player {
    // Stores the computer player's name.
    private String namePlayer;
    private String nameMode;
    private ChooserFactory chooserFactory;
    private Chooser chooser;

    public ComputerPlayer(String namePlayer, String nameMode) {
        this.namePlayer = namePlayer;
        this.chooser = this.chooserFactory.makeChooser(nameMode);

    }

    // Returns the computer player's name.
    public String getNamePlayer() {
        return this.namePlayer;
    }

    // Randomly selects and returns a move.
    public Move move() {

        // Convert the number into a Move.
        Move choice = convert(chooser.makeChoice());

        // Display the computer's choice.
        display(choice);

        // Return the computer's chosen move.
        return choice;
    }
}
