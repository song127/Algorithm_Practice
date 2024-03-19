package Greedy;

import java.util.Scanner;

/**
 * 백준 2839 번 / 실버 4
 * - DP, 그리디
 */
public class SugarDeliver {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < (n / 5) + 1; i++) {
      int count = i;

      int remain = n - i * 5;
      int mod = remain % 3;

      count += remain / 3;

      if(mod != 0) continue;

      min = Math.min(min, count);
    }

    if (min == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(min);
    }
  }
}
