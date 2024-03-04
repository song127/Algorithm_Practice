package DP;

import java.util.Scanner;

/**
 * 백준 14501
 * 완전 탐색, 브루트 포스, DP
 *
 */
public class FireBruteForceSearch {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[n+2];
    int[] time = new int[n+1];
    int[] pay = new int[n+1];
    for (int i = 1; i <= n; i++) {
      time[i] = sc.nextInt();
      pay[i] = sc.nextInt();
    }

    for (int i = n; i >= 1; i--) {
      if(i + time[i] > n + 1) {
        dp[i] = dp[i + 1];
      } else {
        dp[i] = Math.max(dp[i + 1], dp[i + time[i]] + pay[i]);
      }
    }

    System.out.println(dp[1]);
  }
}
