import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProfanityFiler {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String tweet = input.nextLine();

    String[] splitTweet = tweet.split(" ");

    String[] characterString = { "*", "&", "#", "$", "%" };

    ArrayList<String> tweetList = new ArrayList<String>();

    tweetList.add(input.nextLine());
    // Iterator<String> input = tweetList.iterator();
    while (input.hasNextLine()) { // Working :) , scanner input is having loads of strings but not replacing all characters like .,!? or FRIKinG or Fruit? and COUNT
      // String item = input.nextLine();

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
      // Double forloop and now it replaces your word with the new version.

      // It doesn't work on fudgesicles. because it has a (.) "point" after it so you need to remove it first.

      // I think I need to write another forloop for replacing the characteres that are at the end of the word fudgesicles like (.,!?)

      for (String tweet1 : tweetList) {
        String[] tweet1AsArray = tweet1.split(" ");
        String newSting = "";
        // String charac = ".,!?"; Tried to add it to this for loop in order to replace words with those characters at the end and it doesn't work
        for (String string : tweet1AsArray) {
          if (swearWords.containsKey(string)) { // || swearWords.containsKey(charac)
            string = swearWords.get(string);
          }
          newSting += string + " ";
        }
        System.out.println(newSting);
      }

      input.close();
    }
  }
}
// hate fudgesicles
// I bleeping hate those fudgesicles.
// I cannot eat another FRICKing meatball
// I wonder how much fruit? is actually a fruitcake? fruit?
// the COUNT
