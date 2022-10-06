import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProfanityFilter {

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      String tweet = input.nextLine();

      String tweetToLowerCase = tweet.toLowerCase();

      String[] splitTweet = tweetToLowerCase.split(" ");

      String[] characterString = { "*", "&", "#", "$", "%" };

      String sPuntuacion;

      String sResultado = "";

      ArrayList<String> tweetList = new ArrayList<String>();

      while (input.hasNextLine()) {
        String tweetToList = input.nextLine();
        String TweetToListToLowerCase = tweetToList;
        String tweetToListClean = TweetToListToLowerCase;
        tweetList.add(tweetToListClean);/* sentence to arraylist */
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
        String[] arrWordsFromSentence = tweet1.split(" ");

        for (String sword : arrWordsFromSentence) {
          //System.out.println(sword);

          sPuntuacion = "";
          if (sword.contains(".")) {
            //nIndexPoint = sword.index
            sPuntuacion = ".";
            sword = sword.replace(sPuntuacion, "");
          }
          if (sword.contains("?")) {
            sPuntuacion = "?";
            sword = sword.replace(sPuntuacion, "");
          }

          if (sword.contains("!")) {
            sPuntuacion = "!";
            sword = sword.replace(sPuntuacion, "");
          }

          if (sword.contains(",")) {
            sPuntuacion = ",";
            sword = sword.replace(sPuntuacion, "");
          }
          //System.out.println(sword);

          if (swearWords.containsKey(sword.toLowerCase())) {
            sword = swearWords.get(sword.toLowerCase());
          }
          //System.out.println(sword);

          sResultado += sword + sPuntuacion + " ";
        }
      }
      sResultado = sResultado.substring(0, sResultado.length() - 1);
      System.out.println(sResultado);
    }
  }
}
