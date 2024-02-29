package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
      int abs1 = Math.abs(o1);
      int abs2 = Math.abs(o2);
      if (abs1 == abs2)
        return o1 > o2 ? 1 : -1;

      return abs1 > abs2 ? 1 : -1;
    });

    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(br.readLine());

      if (value != 0) {
        myQueue.add(value);
      } else {
        if (myQueue.isEmpty()) {
          System.out.println("0");
        } else {
          System.out.println(myQueue.poll());
        }
      }
    }
  }
}
