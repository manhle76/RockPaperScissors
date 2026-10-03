public class ChooserFactory {

    public Chooser makeChooser(String which) {
        if (which.equals("-r")) {
            return new RandomChooser();
        } else if (which.equals("-m")) {
            return new MachineLearningChooser(5);
        } else {
            return new RandomChooser();
        }
    }

}
