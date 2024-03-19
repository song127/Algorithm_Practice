package Graph;

import java.util.*;

/**
 * 백준 1260번 / 실버2
 * - DFS, BFS
 * DFS 왠지 모르겠는데 제대로 작동 안함
 * 재귀 함수 아니면 순서가 이상해짐
 */
public class DFSnBFS {
  static ArrayList<Integer>[] nodes;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n, m, v;
    n = sc.nextInt();
    m = sc.nextInt();
    v = sc.nextInt();

    nodes = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();

      nodes[s].add(e);
      nodes[e].add(s);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(nodes[i]);
    }

    dfs(v);
    System.out.println();
    bfs(v);
  }

  private static void dfs(int v) {
    visited[v] = true;
    System.out.print(v + " ");

    for (int next : nodes[v]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  private static void bfs(int v) {
    Queue<Integer> q = new LinkedList<>();

    q.offer(v);
    visited[v] = false;
    System.out.print(v + " ");

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int next : nodes[now]) {
        if (visited[next]) {
          q.offer(next);
          visited[next] = false;
          System.out.print(next + " ");
        }
      }
    }

    System.out.println();
  }
}
