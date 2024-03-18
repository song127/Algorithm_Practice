import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ACLanguage {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testcase = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < testcase; i++) {
      char[] functions = sc.nextLine().toCharArray();
      int n = sc.nextInt();
      String arrStr = sc.nextLine();
      String[] splStr;
      if(arrStr.length() > 2) {
        splStr = arrStr.substring(1, arrStr.length() - 2).split(",");
      } else {
        splStr = new String[] {""};
      }

      Deque<String> dq = new ArrayDeque<>();

      for (String str : splStr) {
        dq.add(str);
      }

      boolean isReverse = false;
      for (char c : functions) {
        if (c == 'R') {
          isReverse = !isReverse;
        } else if (c == 'D') {
          if(isReverse) {
            dq.pop();
          } else {
            dq.poll();
          }
        } else {
          System.out.println("error");
          break;
        }
      }

      System.out.print("[");
      while (!dq.isEmpty()) {
        String now = "";
        if(isReverse) {
          now = dq.poll();
        } else {
          now = dq.pop();
        }

        if(!dq.isEmpty()) {
          System.out.print(now + ",");
        } else {
          System.out.print(now);
        }
      }
      System.out.println("]");
    }
  }
}
