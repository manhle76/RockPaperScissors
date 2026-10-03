import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class Storage {
    private File file;

    public Storage(String fileName) {
        this.file = new File(fileName);
    }

    public void startNewGame() {
        try {
            FileWriter writer = new FileWriter(file);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeMove(Move move) {
        try {
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

    public void saveFrequency(Map<String, Integer> frequency) {
        try {
            FileWriter writer = new FileWriter("frequency.txt");

            for (String sequence : frequency.keySet()) {
                int count = frequency.get(sequence);
                writer.write(sequence + "=" + count + "\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}