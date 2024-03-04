package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11659
 * 구간 합
 */
public class NumberGapSum {
  public static void main(String[] args) throws IOException {
    // 입력 값이 클 때
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    // 입력 값이 길 때
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int dataNo = Integer.parseInt(stringTokenizer.nextToken());
    int sumNo = Integer.parseInt(stringTokenizer.nextToken());

    long[] sumArr = new long[dataNo + 1];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 1; i <= dataNo; i++) {
      int nextNumber = Integer.parseInt(stringTokenizer.nextToken());
      sumArr[i] = nextNumber + sumArr[i - 1];
    }

    for (int i = 0; i < sumNo; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      int startIndex = Integer.parseInt(stringTokenizer.nextToken());
      int endIndex = Integer.parseInt(stringTokenizer.nextToken());

      System.out.println(sumArr[endIndex] - sumArr[startIndex - 1]);
    }
  }
}
