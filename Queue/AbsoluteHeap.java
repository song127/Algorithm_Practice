package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 11286
 * 절댓값 힙, 자료구조, 우선 순위 큐
 * - 출제자의 로직을 이해하라
 * - 컴퓨터같이 로직을 이해하라
 */
public class AbsoluteHeap {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    /**
     * 우선 순위 큐
     * - 같은 우선 순위 시 분리 기준 정할 수 있음
     * - "+"일 경우 == 스왑
     * = "-"일 경우 == 논스왑
     */
    PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
      int abs1 = Math.abs(o1);
      int abs2 = Math.abs(o2);
      if (abs1 == abs2)
        // o1 > o2 / 작은 순대로 정렬 시
        // ==> 1 > -1 == 1 / o1 이 후순위, o2 가 선순위 / + 스왑
        // ==> -1 > 1 == -1 / o1 이 선순위, o2 가 후순위 / - 논스왑
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
