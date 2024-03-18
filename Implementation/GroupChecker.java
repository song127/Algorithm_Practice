package Implementation;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 백준 1316 / 실버5
 * - 구현, 문자열
 */
public class GroupChecker {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    int count = 0;

    for (int i = 0; i < n; i++) {
      String input = sc.nextLine();

      if(checker(input)) {
        count++;
      }
    }

    System.out.println(count);
  }

  private static boolean checker(String value) {
    char[] charArr = value.toCharArray();
    HashMap<Character, Boolean> checkMap = new HashMap<>();
    char oldChar = charArr[0];

    for (char c : charArr) {
      boolean state = checkMap.getOrDefault(c, false);
      if(state) {
        return false;
      }
      if(oldChar != c) {
        checkMap.put(oldChar, true);
      }
      oldChar = c;
    }

    return true;
  }
}
