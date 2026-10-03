import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {

    // The file where we store the game moves.
    private File file;

    // Create a Storage object for a specific file.
    public Storage(String fileName) {
        file = new File(fileName);
    }

    // Clear the file and start with an empty file.
    public void startNewGame() {
        try {
            FileWriter writer = new FileWriter(file);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Save one move to the end of the file.
    public void storeMove(Move move) {
        try {
            // 'true' means append to the existing file.
            FileWriter writer = new FileWriter(file, true);

            // Convert the Move into one character.
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

    // Save the frequency table to frequency.txt.
    public void saveFrequency(Map<String, Integer> frequency) {
        try {
            FileWriter writer = new FileWriter("frequency.txt");

            // Write each sequence and its count.
            // Example: RSRPR=2
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {

                String sequence = entry.getKey();
                int count = entry.getValue();

                writer.write(sequence + "=" + count);
                writer.write(System.lineSeparator());
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read the frequency table from frequency.txt.
    public Map<String, Integer> loadFrequency() {

        // Create an empty map.
        Map<String, Integer> frequency = new HashMap<>();

        try {
            File frequencyFile = new File("frequency.txt");

            // If the file does not exist,
            // return the empty map.
            if (!frequencyFile.exists()) {
                return frequency;
            }

            Scanner scanner = new Scanner(frequencyFile);

            // Read the file one line at a time.
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                // Example:
                // "RSRPR=2"
                //
                // split("=") gives:
                // parts[0] = "RSRPR"
                // parts[1] = "2"
                String[] parts = line.split("=");

                String sequence = parts[0];
                int count = Integer.parseInt(parts[1]);

                // Put the sequence and count into the map.
                frequency.put(sequence, count);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return frequency;
    }
}