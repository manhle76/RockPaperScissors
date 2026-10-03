import java.io.File;
import java.io.FileWriter;

public class Storage {
    private String fileName;
    private FileWriter writer;

    public Storage(String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void storeMove(Move move) {
        try {

            if (move == Move.ROCK) {
                writer.write("R");
            } else if (move == Move.PAPER) {
                writer.write("P");
            } else if (move == Move.SCISSORS) {
                writer.write("S");
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
