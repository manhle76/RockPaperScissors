public interface Player {
    // Defines the method that each player must use to make a move.
    Move move();

    // Returns the player's name.
    String getNamePlayer();

    // Converts a number into the corresponding Move.
    default Move convert(int choice) {
        switch (choice) {
            case 1:
                return Move.ROCK;
            case 2:
                return Move.PAPER;
            case 3:
                return Move.SCISSORS;
        }
        // Return null if the choice is invalid.
        return null;
    }

    // Displays the player's name and chosen move.
    default void display(Move choice) {
        System.out.println(getNamePlayer() + " chooses: " + choice);
    }
}
