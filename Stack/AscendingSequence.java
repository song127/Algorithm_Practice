package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AscendingSequence {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sBuffer = new StringBuffer();

    int n = Integer.parseInt(reader.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(reader.readLine());
    }

    Stack<Integer> stack = new Stack<>();
    int num = 1;

    for (int i = 0; i < n; i++) {
      int value = arr[i];

      if (value >= num) {
        while (value >= num) {
          stack.push(num++);
          sBuffer.append("+\n");
        }

        stack.pop();
        sBuffer.append("-\n");
      } else {
        if (stack.pop() > value) {
          System.out.println("NO");
          return;
        }
        sBuffer.append("-\n");
      }
    }

    System.out.print(sBuffer.toString());
  }
}
