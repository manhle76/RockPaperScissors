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
    private Storage storage;

    public MachineLearningChooser() {
        this.sequence = new StringBuilder();
        this.rd = new Random();
        this.N = 5;
        this.storage = new Storage("sequence.txt");
        this.frequency = storage.loadFrequency();
    }

    @Override
    public int makeChoice() {
        readMoves();
        storeSequences();
        char[] RPS = new char[] { 'R', 'P', 'S' };
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
        if (index == 0) {
            return 2;
        } else if (index == 1) {
            return 3;
        } else if (index == 2) {
            return 1;
        }
        return rd.nextInt(3) + 1;
    }

    public void readMoves() {
        try {
            sequence.setLength(0);

            File file = new File("sequence.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                sequence.append(scanner.nextLine());
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
