import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class MachineLearningChooser implements Chooser {
    private StringBuilder sequence;
    private Map<String, Integer> frequency;

    public MachineLearningChooser() {
        this.sequence = new StringBuilder();
        this.frequency = new HashMap<>();
    }

    @Override
    public int makeChoice() {

    }

    public void readMoves() {
        try {
            File file = new File("sequence.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String moves = scanner.nextLine();
                sequence.append(moves);
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeSequences(int N) {
        if (sequence.length() < N) {
            return;
        }

        for (int i = 0; i <= sequence.length() - N; i++) {
            String str = sequence.substring(i, i + N);

            if (!frequency.containsKey(str)) {
                frequency.put(str, 1);
            } else {
                int count = frequency.get(str);
                count++;
                frequency.put(str, count);
            }
        }
    }

}
