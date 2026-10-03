import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    // public void createFrequencyFile(int n) {
    // Map<String, Integer> frequency = new HashMap<>();

    // try {
    // Scanner scanner = new Scanner(file);

    // String sequence = "";

    // while (scanner.hasNextLine()) {
    // sequence += scanner.nextLine();
    // }

    // scanner.close();

    // // Create every N-move sequence
    // for (int i = 0; i <= sequence.length() - n; i += 2) {
    // String part = sequence.substring(i, i + n);

    // frequency.put(
    // part,
    // frequency.getOrDefault(part, 0) + 1);
    // }

    // // Write frequency.txt
    // FileWriter writer = new FileWriter("frequency.txt");

    // for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
    // writer.write(entry.getKey() + "=" + entry.getValue());
    // writer.write(System.lineSeparator());
    // }

    // writer.close();

    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    public void saveFrequency(Map<String, Integer> frequency) {
        try {
            FileWriter writer = new FileWriter("frequency.txt");

            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.write(System.lineSeparator());
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> loadFrequency() {
        Map<String, Integer> frequency = new HashMap<>();

        try {
            File file = new File("frequency.txt");

            if (!file.exists()) {
                return frequency;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split("=");

                String sequence = parts[0];
                int count = Integer.parseInt(parts[1]);

                frequency.put(sequence, count);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return frequency;
    }
}