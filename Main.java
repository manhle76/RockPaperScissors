public class Main {
    public static void main(String[] args) {
        Player humman = new HummanPlayer();
        Player computer = new ComputerPlayer();

        Game game = new Game(humman, computer);

        int[] score = game.play();

        System.out.println("firstPlayer: " + score[1]);
        System.out.println("secondPlayer: " + score[2]);
        System.out.println("Ties: " + score[3]);

    }
}
