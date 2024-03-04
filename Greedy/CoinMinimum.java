package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11047
 * 그리디 알고리즘
 *
 * - 잘따져보지않으면 반례 생길 수 있음 / 최선 의 수가 아님
 * - 조건이 아주 중요함
 *
 * 유형
 * - 동전 갯수
 */
public class CoinMinimum {
  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bReader.readLine());

    int coinNum = Integer.parseInt(st.nextToken());
    int targetPay = Integer.parseInt(st.nextToken());
    int[] coinArr = new int[coinNum];
    int coinCount = 0;

    for (int i = 0; i < coinNum; i++) {
      coinArr[i] = Integer.parseInt(bReader.readLine());
    }

    while (targetPay != 0) {
      for (int i = coinNum - 1; i >= 0; i--) {
        if (targetPay >= coinArr[i]) {
          coinCount += targetPay / coinArr[i];
          targetPay = targetPay % coinArr[i];
        }
      }
    }

    System.out.println(coinCount);
  }
}
