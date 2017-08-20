import java.util.Date;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

import com.treehouse.Treet;
import com.treehouse.Treets;

public class Example {
    public static void main(String[] args) { 
        // Uncomment the code below to create treets and save to file.
       /*
        Treet firstTreet = new Treet(
            "williamhgough",
            "Hello world, this is my #java #treet. Done as part of the @treehouse course!",
            new Date(1421849732000L)
        );
        Treet secondTreet = new Treet(
            "williamhgough",
            "The second tweet of mine for the #java #data #structures @treehouse course.",
            new Date(1421849735000L)
        );

        // Create array of Treets & save them
        Treet[] treets = {firstTreet, secondTreet};
        Treets.save(treets); 
        */
        
        // Load in Treets from file and print each one.
        Treet[] loaded = Treets.load();
        System.out.printf("There are %d treets.%n", loaded.length);
        Set<String> allHashTags = new TreeSet<String>();
        Set<String> allMentions = new TreeSet<String>();
        
        for (Treet treet : loaded) {
            allHashTags.addAll(treet.getHashTags());
            allMentions.addAll(treet.getMentions());
        }
        
        // all hashtags
        System.out.printf("Hashtags: %s%n", allHashTags);
        // all mentions
        System.out.printf("Mentions: %s%n", allMentions);
        
        // Hashtag counts
        Map<String, Integer> hashTagCounts = new HashMap<String, Integer>();
        for (Treet treet : loaded) {
            for (String hashtag : treet.getHashTags()) {
                Integer count = hashTagCounts.get(hashtag);
                if (count == null) {
                    count = 0;
                }
                count++;
                hashTagCounts.put(hashtag, count);
            }
        }
        System.out.printf("Hash tag counts: %s %n", hashTagCounts);

        // Tweets by authors.
        Map<String, List<Treet>> treetsByAuthor = new HashMap<String, List<Treet>>();
        for (Treet treet : loaded) {
            List<Treet> authoredTreets = treetsByAuthor.get(treet.getAuthor());
            if (authoredTreets == null) {
                authoredTreets = new ArrayList<Treet>();
                treetsByAuthor.put(treet.getAuthor(), authoredTreets);
            }
            authoredTreets.add(treet);
        }
        System.out.printf("Treets by author '%s': %s %n", "williamhgough", treetsByAuthor.get("williamhgough"));
    }
}