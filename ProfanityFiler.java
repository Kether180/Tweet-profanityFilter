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
    // String [] badWords =

    ArrayList<String> tweetList = new ArrayList<String>(); // arrayList to storage the tweet's inputs
    tweetList.add(input.nextLine());

    // Iterator<String> input = tweetList.iterator();

    /* 
    while (input.hasNextLine()) { // Working ;) , scanner input is having loads of strings but not replacing all swearwords and printing an extra line.
      String item = input.nextLine();
      // String itemoutput =input.nextLine();

      if (item.equals("hate")) {/* still trying to solve it 
        System.out.println("*&#$%");
      } else {
        System.out.println(item);
      }
      if (item.equals("fudgesicles")) {/* still trying to solve it 
        System.out.println("*&#$%*&#$%*");
      }
      if (item.equals("FRICK")) {/* still trying to solve it 
        System.out.println("*&#$%");
      }
      if (item.equals("fruit?")) {/* still trying to solve it *
        System.out.println("*&#$%");
      }
      
      */
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
      // i made i double forloop and now it replaces your word with the new version. 
      //it does work on fudgesicles. because it has a . after it so you need to remove it first. 
      //but this should get you going 
      for (String tweet1 : tweetList) {
        String[] tweet1AsArray = tweet1.split(" ");
        String newSting = "";
        for (String string : tweet1AsArray) {
            if(swearWords.containsKey(string)){
                string = swearWords.get(string);
            }
            newSting += string + " ";
        }
        System.out.println(newSting);
      }
      
/* 
      System.out.print(
        swearWords.get("hate".toLowerCase()) +
        " " +
        swearWords.get("fudgeSicles".toLowerCase())
      );
      */
      input.close();
    }
  }

// hate fudgesicles
// I bleeping hate those fudgesicles.
// I cannot eat another FRICKing  meatball
// I wonder how much fruit?  is actually a fruitcake?  fruit?
// the COUNT
