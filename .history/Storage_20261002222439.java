import java.io.File;
import java.io.FileWriter;

public class Storage {
    private String fileName;
    private File file;

    public Storage(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    public void storeMove(Move move) {
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file, true);
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
