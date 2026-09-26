
public interface Player {
    public Move move();

    default Move convert(int choice) {
        switch (choice) {
            case 1:
                return Move.ROCK;
            case 2:
                return Move.PAPER;
            case 3:
                return Move.SCISSORS;
        }
        return null;
    }
}
