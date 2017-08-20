import java.util.Date;
import java.util.Arrays;

import com.treehouse.Treet;
import com.treehouse.Treets;

public class Example {
    public static void main(String[] args) {
        // Create new tweets
        Treet treet = new Treet(
            "williamhgough",
            "Hello world, this is my #treet. Done as part of the @treehouse course!",
            new Date(1421849732000L)
        );
        Treet treetTwo = new Treet(
            "williamhgough",
            "The second tweet of mine for the treehouse course about learning Java.",
            new Date(1421849735000L)
        );
        // Create array of Treets & save them
        Treet[] treets = {treet, treetTwo};
        Treets.save(treets);
        
        // Load in Treets from file and print each one.
        Treet[] loaded = Treets.load();
        for (Treet load : loaded) {
            System.out.println(load);
        }
    }
}