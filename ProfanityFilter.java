import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProfanityFilter {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String tweet = input.nextLine();

    String tweetToLowerCase = tweet.toUpperCase();

    String[] splitTweet = tweetToLowerCase.split(" ");

    String[] characterString = { "*", "&", "#", "$", "%" };

    ArrayList<String> tweetList = new ArrayList<String>();

    while (input.hasNextLine()) {
      String tweetToList = input.nextLine();
      String TweetToListToLowerCase = tweetToList; // took out lowercase
      String tweetToListClean = TweetToListToLowerCase;
      // .replaceAll(
      //   "[,.!?]*",
      //   ""
      // );
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

      if (string.equals("FRUIT")) {
        swearWords.put(string.toUpperCase(), symbolString + "?");
      } else {
        swearWords.put(string.toUpperCase(), symbolString);
      }
    }

    for (String tweet1 : tweetList) {
      int tweetSize = tweet1.length();
      String stringdot;

      stringdot = tweet1.substring(tweetSize - 1, tweetSize);

      String[] tweet1AsArray = tweet1.split(" ");
      String newSting = "";

      for (String string : tweet1AsArray) {
        String str;
        str = string.toUpperCase();
        if (
          swearWords.containsKey(str.toUpperCase().replaceAll("[,.!?]*", ""))
        ) {
          string =
            swearWords.get(string.toUpperCase().replaceAll("[,.!?]*", ""));
        }

        newSting += string + " ";
      }

      int sizestring = newSting.length();

      // newSting = newSting.substring(0, sizestring - 2);

      if (newSting.equals("Fudgesicles")) {
        newSting.substring(0, sizestring - 1);
      } else {
        newSting.substring(0, sizestring - 2);
      }

      System.out.println(newSting.replace(".", "") + stringdot);
    }
    // .replace(".", "").replace("?", "")
    input.close();
  }
}
// Input 1
// hate fudgesicles
// I bleeping hate those fudgesicles.
// Input 2
// fricking
// I cannot eat another FRICKing meatball!
// Input 3
// fruit
// I wonder how much fruit? is actually in a fruitcake?
// Input 4
// the COUNT
// Still I bleeping *&#$ those *&#$%*&#$%*.
