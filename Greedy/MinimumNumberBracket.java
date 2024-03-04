package Greedy;

import java.util.Scanner;

/**
 * 백준 1541
 * 그리디
 *
 * - 조건을 잘찾아라
 * - 이 문제의 경우, 크게 뺄수록 더 작은 수가 나온다는 조건
 */
public class MinimumNumberBracket {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine();

    String[] spInput = input.split("-");
    int result = 0;

    result += sum(spInput[0]);

    for (int i = 1; i < spInput.length; i++) {
      result -= sum(spInput[i]);
    }

    System.out.println(result);
  }

  private static int sum(String str) {
    String[] spStr = str.split("\\+");
    int result = 0;

    for (String valueStr : spStr) {
      result += Integer.parseInt(valueStr);
    }

    return result;
  }
}
