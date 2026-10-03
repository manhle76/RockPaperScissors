import java.util.Random;

public class RandomChooser implements Chooser {
    private Random rd;

    public RandomChooser() {
        this.rd = new Random();
    }

    @Override
    public int makeChoice() {

        // Generate a random number from 1 to 3.
        int choice = rd.nextInt(3) + 1;
        // Convert the number into a Move.
        return choice;
    }
}
