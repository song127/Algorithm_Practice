package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JuMongGapOat {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine());
    int m = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(arr);

    int count = 0;
    int i = 0;
    int j = n - 1;

    while (i < j) {
      int localSum = arr[i] + arr[j];
      if (localSum < m) {
        i++;
      } else if (localSum > m) {
        j--;
      } else {
        count++;
        i++;
        j--;
      }
    }

    System.out.println(count);
  }
}
