package DP;

import java.util.Scanner;

/**
 * 백준 11726
 * DP
 * - 점화식 세우기 중요
 * - D[n] 직전의 D[n-1], D[n-2] 등은 모두 이미 구해져있다고 생각
 * - D[n] 을 도출하기 위한 D[n-i] 들의 합을 구하는 점화식 세우기
 * - D[n] 이 될 때의 경우의 수들만 구하기
 * - D[n-1] => 세우는 경우의 수만 존재
 * - D[n-2] => 세우는 경우, 눕히는 경우 2가지 존재
 * - => 여기서 함정 존재
 * - - 세우는 경우의 수는 n-1일 때와 같음
 * - 즉, 2*D[n-2] => D[n] => D[n-2] + D[n-1]
 *
 * - 최소의 수부터 나열해보는 연습 필요
 * - 최소의 수는 직접 계산해서 넣는게 안전
 */
public class TwiceTileDP {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] tiles = new int[n + 1];
    tiles[0] = 1;
    tiles[1] = 1;

    for (int i = 3; i <= n; i++) {
      tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
    }

    System.out.println(tiles[n]);
  }
}
