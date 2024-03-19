package Structure;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 백준 5430번 / 골드5
 * - 구현, 자료구조, 문자열
 * - 입출력 제대로 할 것. return 함부로 쓰지말 것.
 */
public class ACLanguage {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testcase = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < testcase; i++) {
      char[] functions = sc.nextLine().toCharArray();

      int n = sc.nextInt();
      sc.nextLine();

      String arrStr = sc.nextLine();
      String[] splStr;

      if (n > 0) {
        splStr = arrStr.substring(1, arrStr.length() - 1).split(",");
      } else {
        splStr = new String[0];
      }

      Deque<String> dq = new ArrayDeque<>();

      for (String str : splStr) {
        dq.add(str.trim());
      }

      boolean isReverse = false;
      boolean isError = false;
      for (char c : functions) {
        if (c == 'R') {
          isReverse = !isReverse;
        } else {
          if (dq.isEmpty()) {
            isError = true;
            break;
          }

          if (isReverse) {
            dq.pollLast();
          } else {
            dq.poll();
          }
        }
      }

      if (isError) {
        System.out.println("error");
        continue;
      }

      System.out.print("[");
      while (!dq.isEmpty()) {
        String now = "";

        if (isReverse) {
          now = dq.pollLast();
        } else {
          now = dq.poll();
        }

        if (!dq.isEmpty()) {
          System.out.print(now + ",");
        } else {
          System.out.print(now);
        }
      }
      System.out.println("]");
    }

    sc.close();

    return;
  }
}
