package Math;

import java.util.Scanner;

/**
 * 순열
 * - DP 로 구현 가능
 */
public class NCR {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    int[][] d = new int[n + 1][n + 1];

    // 무조건 1이 되는 경우의 수들 초기화
    for (int i = 1; i <= n; i++) {
      d[i][i] = 1;
      d[i][0] = 1;
      d[i][1] = i;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= i; j++) {
        d[i][j] = d[i - 1][j] + d[i - 1][j - 1];
      }
    }

    System.out.println(d[n][k]);

    // n! / (n - r)! * r!
    // System.out.println(factory(n) / factory(n - k) / factory(k));
  }

  // private static int factory(int n) {
  //   if(n <= 1) return 1;
  //   return n * factory(--n);
  // }
}
