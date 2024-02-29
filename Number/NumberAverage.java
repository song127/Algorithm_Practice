package Number;

import java.util.Scanner;

public class NumberAverage {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long sum = 0;
    long max = 0;

    for (int i = 0; i < n; i++) {
      long input = sc.nextInt();
      if (input > max) max = input;
      sum += input;
    }

    double average = sum * 100.0 / max / n;

    System.out.println(average);
  }
}
