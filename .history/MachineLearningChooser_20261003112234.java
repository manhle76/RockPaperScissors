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
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        char[] RPS = { 'R', 'P', 'S' };

        // We need N - 1 previous choices to make a prediction
        if (sequence.length() < N) {
            System.out.println("randommm111111111111111");
            return rd.nextInt(3) + 1;
        }

        char[] possibleSequence = new char[N];

        // Get the last N - 1 choices
        for (int i = 0; i < N - 1; i++) {
            possibleSequence[i] = sequence.charAt(sequence.length() - (N - 1) + i);
        }
        System.out.println("PossibleSequence " + new String(possibleSequence));

        int max = 0;
        int index = -1;

        // Try R, P, and S as the human's next choice
        for (int i = 0; i < 3; i++) {

            possibleSequence[N - 1] = RPS[i];

            String possible = new String(possibleSequence);

            if (frequency.containsKey(possible)) {

                if (frequency.get(possible) > max) {
                    max = frequency.get(possible);
                    index = i;
                }
            }
        }
        System.out.println("index = " + index + " max= " + max);

        // Play the move that beats the predicted human move
        if (index == 0) {
            System.out.println("HUMAN  ----->R");
            System.out.println("COMPUTER --->P");
            return 2; // Human predicted R → computer P
        } else if (index == 1) {
            System.out.println("COMPUTER --->S");
            return 3; // Human predicted P → computer S
        } else if (index == 2) {
            System.out.println("COMPUTER --->R");
            return 1; // Human predicted S → computer R
        }

        // No matching sequence → random
        System.out.println("randommm222222222222");
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
            System.out.println("read move ");
            ;
        }
    }

}
