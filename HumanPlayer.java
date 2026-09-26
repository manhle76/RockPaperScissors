import java.util.Scanner;

public class HumanPlayer implements Player {
    // Stores the player's name.
    private String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    // Returns the player's name.
    public String getName() {
        return this.name;
    }

    // Gets the player's choice and converts it into a Move.
    public Move move() {
        System.out.println("Enter your choice: ");

        // Create a Scanner to read the player's input.
        Scanner sc = new Scanner(System.in);
        int choiceInInteger = sc.nextInt();

        // Keep asking until the player enters a number from 1 to 3.
        while (choiceInInteger < 1 || choiceInInteger > 3) {
            System.out.println("Please reenter your choice: ");
            choiceInInteger = sc.nextInt();
        }

        // Convert the integer choice into a Move.
        Move choice = convert(choiceInInteger);

        // Display the player's choice.
        display(choice);

        // Return the player's chosen move.
        return choice;
    }
}
