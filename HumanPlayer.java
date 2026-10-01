import java.util.Scanner;

public class HumanPlayer implements Player {
    // Stores the player's name.
    private String name;
    private Scanner sc;

    public HumanPlayer(String name) {
        this.name = name;
        this.sc = new Scanner(System.in);
    }

    // Returns the player's name.
    public String getName() {
        return this.name;
    }

    // Gets the player's choice and converts it into a Move.
    public Move move() {
        System.out.println("Enter your choice: ");

        // Create a Scanner to read the player's input.

        String choiceString = sc.nextLine().trim();

        // Keep asking until the player enters a number from 1 to 3.
        while (!choiceString.equalsIgnoreCase("1") && !choiceString.equalsIgnoreCase("2")
                && !choiceString.equalsIgnoreCase("3")) {
            System.out.println("Please reenter your choice: ");
            choiceString = sc.nextLine().trim();
        }

        // int choiceInInteger = sc.nextInt();

        // // Keep asking until the player enters a number from 1 to 3.
        // while (choiceInInteger < 1 || choiceInInteger > 3) {
        // System.out.println("Please reenter your choice: ");
        // choiceInInteger = sc.nextInt();
        // }

        // Convert the integer choice into a Move.
        Move choice = convert(Integer.parseInt(choiceString));

        // Display the player's choice.
        display(choice);

        // Return the player's chosen move.
        return choice;
    }
}
