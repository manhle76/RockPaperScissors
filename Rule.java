public class Rule {
    // Determines the result of a round.
    // 1 = first player wins, 2 = second player wins, 3 = tie.
    public int result(Move firstPlayer, Move secondPlayer) {

        // If both players choose the same move, the round is a tie.
        if (firstPlayer == secondPlayer) {
            return 3;

            // Check the combinations where the first player wins.
        } else if ((firstPlayer == Move.ROCK && secondPlayer == Move.SCISSORS)
                || (firstPlayer == Move.PAPER && secondPlayer == Move.ROCK)
                || (firstPlayer == Move.SCISSORS && secondPlayer == Move.PAPER)) {
            return 1;
        }

        // If it is not a tie or a first-player win, the second player wins.
        return 2;
    }
}
