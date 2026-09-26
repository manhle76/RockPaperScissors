import java.util.Scanner;

public class HummanPlayer implements Player {
    public Move move() {
        System.out.println("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Please reenter your choice: ");
            choice = sc.nextInt();
        }
        System.out.println("humman choice: " + choice);
        return convert(choice);
    }
}
