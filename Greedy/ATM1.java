package Greedy;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 11399번 / 실버4
 * - 그리디
 */
public class ATM1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] time = new int[n];
    for (int i = 0; i < n; i++) {
      time[i] = sc.nextInt();
    }

    Arrays.sort(time);

    int[] wait = new int[n];
    int sum = time[0];

    for (int i = 1; i < time.length; i++) {
      wait[i] += wait[i - 1] + time[i];
    }

    for (int v : wait) {
      sum += v;
    }

    System.out.println(sum);
  }
}
