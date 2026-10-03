public class ChooserFactory {

    Chooser makeChooser(String which) {
        if (which.equals("-r"))
            return new RandomChooser();
        else if (which.equals("-m"))
            return new MachineLearningChooser();
    }

}
