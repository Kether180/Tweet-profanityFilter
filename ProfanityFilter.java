import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProfanityFilter {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String tweet = input.nextLine();
    String tweetToLowerCase = tweet.toLowerCase();

    String[] splitTweet = tweetToLowerCase.split(" ");

    String[] characterString = { "*", "&", "#", "$", "%" };

    ArrayList<String> tweetList = new ArrayList<String>();

    while (input.hasNextLine()) {
      String tweetToList = input.nextLine();
      String TweetToListToLowerCase = tweetToList.toLowerCase();
      String tweetToListClean = TweetToListToLowerCase.replaceAll(
        "[,.!?]*",
        ""
      );
      tweetList.add(tweetToListClean);
      if (!input.hasNextLine()) {
        break;
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
      String[] tweet1AsArray = tweet1.split(" ");
      String newSting = "";

      // String charac = ".,!?"; Tried to add it to this for loop in order to replace
      // words with those characters at the end and it doesn't work
      for (String string : tweet1AsArray) {
        if (swearWords.containsKey(string)) { // || swearWords.containsKey(charac)
          string = swearWords.get(string);
        }
        newSting += string + " ";
      }
      System.out.println(newSting.replace(".", "$")); // substitute words with .,!? with *&#$ still finding out
    }

    input.close();
  }
}
// hate fudgesicles
// I bleeping hate those fudgesicles.
// I cannot eat another FRICKing meatball
// I wonder how much fruit? is actually a fruitcake? fruit?
// the COUNT
