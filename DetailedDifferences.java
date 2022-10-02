import java.util.Scanner;

public class DetailedDifferences {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int a = scanner.nextInt();

      for (int j = 1; j <= a; j++) {
        String b = scanner.next();
        String c = scanner.next();
        String[] d = b.split("");
        String[] e = c.split("");
        System.out.println(b);
        System.out.println(c);
        for (int i = 0; i < d.length; i++) {
          if (d[i].equals(e[i])) {
            System.out.print(".");
          } else {
            System.out.print("*");
          }
        }
        System.out.println("");
        System.out.println("");
      }
    }
  }
}
