package Math;

import java.util.Scanner;

/**
 * 순열
 */
public class NPR {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    // n! / (n - r)!
    System.out.println(factory(n) / factory(n - k));
  }

  private static int factory(int n) {
    if(n <= 1) return 1;
    return n * factory(--n);
  }
}
