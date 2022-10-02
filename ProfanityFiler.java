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
    tweetList.add(input.nextLine());

    // Iterator<String> input = tweetList.iterator();

    while (input.hasNextLine()) { // Working ;) , scanner input is having loads of strings but not replacing all swearwords and printing an extra line.
      String item = input.nextLine();
      if (item.equals("hate")) {/* still trying to solve it */
        input.remove();
      } else System.out.println(item);
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
// I cannot ear another FRICKing  meatball
// I wonder how much fruit?  is actually a fruitcake?  fruit?
// the COUNT
