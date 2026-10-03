import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

public class MachineLearningChooser implements Chooser {
    private StringBuilder sequence;
    private Map<String, Integer> frequency;
    private Random rd;
    private int N;

    public MachineLearningChooser() {
        this.sequence = new StringBuilder();
        this.frequency = new HashMap<>();
        this.rd = new Random();
        this.N = 5;
    }

    @Override
    public int makeChoice() {
        readMoves();
        storeSequences();
        char[] RPS = new char[] { 'R', 'P', 'C' };
        int sequenceLen = sequence.length();
        if (sequenceLen < N) {
            return rd.nextInt(3) + 1;
        }
        char[] lastFourChoices = new char[N];
        for (int i = 0; i < N - 1; i++) {
            lastFourChoices[i] = sequence.charAt(sequence.length() - (N - 1) + i);
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < RPS.length; i++) {
            lastFourChoices[N - 1] = RPS[i];
            String g = new String(lastFourChoices);
            if (frequency.containsKey(g)) {
                if (frequency.get(g) > max) {
                    index = i;
                    max = frequency.get(g);
                }
            }
        }
        if (index == 1) {
            return 2;
        } else if (index == 2) {
            return 3;
        } else if (index == 3) {
            return 1;
        }
        return rd.nextInt(3) + 1;
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

    public void storeSequences() {
        if (sequence.length() < N) {
            return;
        }

        for (int i = 0; i <= sequence.length() - N; i++) {
            String str = sequence.substring(i, i + N).toString();

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
