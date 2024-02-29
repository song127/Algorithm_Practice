package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bReader.readLine());

    arr = new int[n];

    StringTokenizer sTokenizer = new StringTokenizer(bReader.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(sTokenizer.nextToken());
    }

    Arrays.sort(arr);

    int m = Integer.parseInt(bReader.readLine());

    sTokenizer = new StringTokenizer(bReader.readLine());
    for (int i = 0; i < m; i++) {
      boolean isIn = binSearch(Integer.parseInt(sTokenizer.nextToken()));
      System.out.println(isIn ? 1 : 0);
    }
  }

  private static boolean binSearch(int target) {
    boolean result = false;
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int midIndex = (start + end) / 2;
      int midValue = arr[midIndex];
      if (midValue > target) {
        end = midIndex - 1;
      } else if (midValue < target) {
        start = midIndex + 1;
      } else {
        result = true;
        break;
      }
    }

    return result;
  }
}
