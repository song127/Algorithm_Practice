package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContinuousNumberSum {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine());

    int count = 1;
    int startIndex = 1;
    int endIndex = 1;
    int sum = 1;

    while(endIndex != n) {
      if(sum == n) {
        count++;
        endIndex++;
        sum += endIndex;
      } else if(sum < n) {
        endIndex++;
        sum += endIndex;
      } else if(sum > n) {
        sum -= startIndex;
        startIndex++;
      }
    }

    System.out.println(count);
  }
}
