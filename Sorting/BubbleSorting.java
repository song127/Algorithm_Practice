package Sorting;

import java.util.Scanner;

/**
 * 백준 2750
 * 버블 정렬
 */
public class BubbleSorting {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if(arr[j] < arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    for (int value : arr) {
      System.out.println(value);
    }
  }
}
