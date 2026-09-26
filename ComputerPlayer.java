import java.util.Random;

public class ComputerPlayer implements Player {

    public Move move() {
        Random rd = new Random();
        int choice = rd.nextInt(3) + 1;
        System.out.println("computer choice" + choice);
        return convert(choice);
    }
}
