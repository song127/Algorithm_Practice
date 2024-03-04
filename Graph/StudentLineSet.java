package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2252
 * 위상 정렬
 *
 * - 로직 한 번 더 훑어보기
 * - bfs 랑 비슷함
 */
public class StudentLineSet {
  static ArrayList<Integer>[] list;
  static int[] degreeArr;

  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bReader.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    list = new ArrayList[n + 1];
    degreeArr = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bReader.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      list[start].add(end);
      degreeArr[end]++;
    }

    graphSorting();
  }

  private static void graphSorting() {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i < degreeArr.length; i++) {
      if(degreeArr[i] == 0) queue.add(i);
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();

      System.out.println(now + " ");

      for (int next : list[now]) {
        degreeArr[next]--;
        if(degreeArr[next] == 0) {
          queue.add(next);
        }
      }
    }
  }
}
