import java.util.HashMap;
import java.util.Map;

public class Game {
    private Rule rule;
    private Player firstPlayer;
    private Player secondPlayer;
    private int[] score;

    public Game(Player firsPlayer, Player seconPlayer) {
        this.firstPlayer = firsPlayer;
        this.secondPlayer = seconPlayer;
        this.rule = new Rule();
        score = new int[4];
    }

    public int[] play() {
        Move firstPalyerMove = firstPlayer.move();
        Move secondPlayerMove = secondPlayer.move();
        int result = rule.result(firstPalyerMove, secondPlayerMove);
        score[result]++;
        return this.score;
    }

}
