
public class Rule {

    public int result(Move firstPlayer, Move secondPlayer) {
        if (firstPlayer == secondPlayer) {
            return 3;
        } else if ((firstPlayer == Move.ROCK && secondPlayer == Move.SCISSORS)
                || (firstPlayer == Move.PAPER && secondPlayer == Move.ROCK)
                || (firstPlayer == Move.SCISSORS && secondPlayer == Move.PAPER)) {
            return 1;
        }
        return 2;
    }

}