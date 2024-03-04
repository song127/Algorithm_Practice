package DP;

import java.util.Scanner;

/**
 * 백준 13398
 * DP
 * - ㅈ됐다... ㅈㄴ 어렵다...
 * - DP 문제들은 일단 포기
 * - link[https://www.youtube.com/watch?v=PfqjxuQL1Kw&list=PLFgS-xIWwNVU_qgeg7wz_aMCk22YppiC6&index=25]
 */
public class ContinuousNumberSumDP {
  private static int[] dp;
  private static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    dp = new int[n];
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
  }
}
