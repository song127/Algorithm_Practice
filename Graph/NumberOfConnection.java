package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

    int treeCount = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        treeCount++;
        dfs(i);
      }
    }

    System.out.println(treeCount);
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
