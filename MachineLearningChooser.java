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

    public MachineLearningChooser(int N) {
        this.sequence = new StringBuilder();
        this.rd = new Random();
        this.N = N;
        this.storage = new Storage("sequence.txt");

    }

    @Override
    public int makeChoice() {
        // Read all previous moves from sequence.txt.
        readMoves();

        // Create the frequency table using the previous moves.
        createFrequency();

        // Display the frequency table for testing.
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Possible moves: Rock, Paper, Scissors.
        char[] possibleMoves = { 'R', 'P', 'S' };

        // We need N - 1 previous moves to predict the next move.
        if (sequence.length() < N - 1) {
            System.out.println("Not enough data. Choosing randomly.");
            return rd.nextInt(3) + 1;
        }

        // Create a sequence of N moves.
        // The first N - 1 positions are previous moves.
        // The last position will be a possible next human move.
        char[] testSequence = new char[N];

        // Get the last N - 1 moves from the history.
        int numberOfPreviousMoves = N - 1;
        int startPosition = sequence.length() - numberOfPreviousMoves;

        for (int i = 0; i < numberOfPreviousMoves; i++) {
            testSequence[i] = sequence.charAt(startPosition + i);
        }

        System.out.println("Previous moves: " + new String(testSequence));

        // Keep track of the most frequent predicted move.
        int highestFrequency = 0;
        int predictedMoveIndex = -1;

        // Try each possible next human move: R, P, and S.
        for (int i = 0; i < possibleMoves.length; i++) {

            // Put the possible human move at the end.
            testSequence[N - 1] = possibleMoves[i];

            String testPattern = new String(testSequence);

            // Check how often this pattern appeared in the past.
            int frequencyCount = frequency.getOrDefault(testPattern, 0);

            // Keep the move with the highest frequency.
            if (frequencyCount > highestFrequency) {
                highestFrequency = frequencyCount;
                predictedMoveIndex = i;
            }
        }

        System.out.println(
                "Predicted move: " + predictedMoveIndex +
                        ", Frequency: " + highestFrequency);

        // Choose the move that beats the predicted human move.
        if (predictedMoveIndex == 0) {
            // Human is predicted to choose Rock → Computer chooses Paper.
            System.out.println("Human predicted: Rock");
            System.out.println("Computer chooses: Paper");
            return 2;

        } else if (predictedMoveIndex == 1) {
            // Human is predicted to choose Paper → Computer chooses Scissors.
            System.out.println("Human predicted: Paper");
            System.out.println("Computer chooses: Scissors");
            return 3;

        } else if (predictedMoveIndex == 2) {
            // Human is predicted to choose Scissors → Computer chooses Rock.
            System.out.println("Human predicted: Scissors");
            System.out.println("Computer chooses: Rock");
            return 1;
        }

        // No matching pattern was found, so choose randomly.
        System.out.println("No pattern found. Choosing randomly.");
        return rd.nextInt(3) + 1;
    }

    private void createFrequency() {
        frequency = new HashMap<>();
        for (int i = 0; i <= sequence.length() - N; i += 2) {
            String part = sequence.substring(i, i + N);

            frequency.put(
                    part,
                    frequency.getOrDefault(part, 0) + 1);
        }

        storage.saveFrequency(frequency);
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
            System.err.println("Wrong at read Moves");

        }
    }

}
