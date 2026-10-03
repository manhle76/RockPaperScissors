import java.util.Scanner;
import java.io.File;

public class MachineLearningChooser implements Chooser {

    @Override
    public int makeChoice() {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void readMoves() {
        try {
            File file = new File("sequence.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String moves = scanner.nextLine();

                for (int i = 0; i < moves.length(); i++) {
                    char move = moves.charAt(i);
                    System.out.println(move);
                }
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
