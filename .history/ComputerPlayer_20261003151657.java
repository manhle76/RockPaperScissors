import java.util.Scanner;

public class ComputerPlayer implements Player {
    // Stores the computer player's name.
    private String namePlayer;
    private ChooserFactory chooserFactory;
    private Chooser chooser;

    public ComputerPlayer(String namePlayer) {
        this.namePlayer = namePlayer;
        System.out.println("Which mode do you want to play?('-r' for random; '-m' for machine learning) ");
        String nameMode = new Scanner(System.in).nextLine();
        this.chooserFactory = new ChooserFactory();
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
