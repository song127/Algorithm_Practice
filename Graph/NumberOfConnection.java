package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 11724
 * DFS, BFS
 * - 연결요소의 갯수 == 연결된 그래프의 갯수
 */
public class NumberOfConnection {
  static boolean[] visited;
  static ArrayList<Integer>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bReader.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];
    list = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bReader.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      list[start].add(end);
      list[end].add(start);
    }

    int graphCount = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        graphCount++;
        dfs(i);
      }
    }

    System.out.println(graphCount);
  }

  private static void dfs(int nodeIndex) {
    if (visited[nodeIndex]) {
      return;
    }

    visited[nodeIndex] = true;

    for (int chlidIndex : list[nodeIndex]) {
      if (!visited[chlidIndex]) {
        dfs(chlidIndex);
      }
    }
  }
}
