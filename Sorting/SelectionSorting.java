package Sorting;

import java.io.IOException;
import java.util.Scanner;

/**
 * 백준 1427
 * 선택 정렬
 */
public class SelectionSorting {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();
    int[] arr = new int[str.length()];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(str.substring(i, i + 1));
    }

    for (int i = 0; i < arr.length; i++) {
      int maxIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[maxIndex] < arr[j])
          maxIndex = j;
      }
      if (arr[i] < arr[maxIndex]) {
        int temp = arr[i];
        arr[i] = arr[maxIndex];
        arr[maxIndex] = temp;
      }
    }

    for (int value : arr) {
      System.out.print(value);
    }
  }
}
