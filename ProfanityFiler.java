import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Iterator;
import java.util.Scanner;

public class ProfanityFiler {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String tweet = input.nextLine();

    String[] splitTweet = tweet.split(" "); // // split the string
    String[] characterString = { "*", "&", "#", "$", "%" }; // storage the characters

    ArrayList<String> tweetList = new ArrayList<String>(); // arrayList to storage the tweet's inputs
    tweetList.add(input.next());

    // Iterator<String> input = tweetList.iterator();

    while (input.hasNextLine()) {
      // String crazytweet = input.next();

      // crazytweet.equalsIgnoreCase("hate"); // trying to compare the hashmap but not working
      ///characterString ??
      String crazytweet = input.nextLine();

      int index = 0;
      for (int i = 0; i < crazytweet.length(); i++) {
        if (index == characterString.length) {
          index = 0;
        }
        crazytweet += characterString[index];
        index++;
      }
      tweetList.add(crazytweet.toLowerCase());

      {
        System.out.println(tweetList.add(crazytweet.toLowerCase()));
      }
    }

    HashMap<String, String> swearWords = new HashMap<String, String>();

    for (String string : splitTweet) {
      String symbolString = "";
      int index = 0;
      for (int i = 0; i < string.length(); i++) {
        if (index == characterString.length) {
          index = 0;
        }
        symbolString += characterString[index];
        index++;
      }

      swearWords.put(string.toLowerCase(), symbolString);
    }

    for (String tweet1 : tweetList) {
      System.out.println(tweet1);
    }

    System.out.print(
      swearWords.get("hate".toLowerCase()) +
      " " +
      swearWords.get("fudgeSicles".toLowerCase())
    );
    input.close();
  }
}
// hate fudgesicles
// I bleeping hate those fudgesicles.
