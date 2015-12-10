package Logic;

/**
 * Created by Peter Villumsen on 19/11/15.
 * Main class used to start the program. The program starts by running the run() method in the LogicController class.
 */
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {

        Logic.LogicController lc = new Logic.LogicController();

        lc.run();
    }
}
