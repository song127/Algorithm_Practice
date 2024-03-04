package StudyArchive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 1707
 * 이분 그래프, 탐색
 *
 * - 1차안
 * - bfs나 dfs로 탐색하면서 돌아다니는데, 자식 노드 갯수 k가 1<k<3인 경우만 오케이
 * - 1차안 실패 -> 이분 그래프랑 이진 그래프 여부랑 다름
 * - 이분 그래프는 두 집합으로 그래프를 나눴을 때, 인접한 노드들끼리 같은 집합이 아니어야 함.
 *
 * - 2차안
 * - 강의보고 따라함
 * - 뭔가 많이 달라짐
 */

public class BipartiteGraphNo3 {
  static ArrayList<Integer>[] list;
  static int[] check;
  static boolean[] visited;
  static boolean isEven;

  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

    int caseNumber = Integer.parseInt(bReader.readLine());

    for (int i = 0; i < caseNumber; i++) {
      StringTokenizer dataStr = new StringTokenizer(bReader.readLine());

      int v = Integer.parseInt(dataStr.nextToken());
      int e = Integer.parseInt(dataStr.nextToken());

      list = new ArrayList[v + 1];
      visited = new boolean[v + 1];
      check = new int[v + 1];
      isEven = true;

      for (int j = 1; j <= v; j++) {
        list[j] = new ArrayList<Integer>();
      }

      for (int j = 0; j < e; j++) {
        dataStr = new StringTokenizer(bReader.readLine());
        int node1 = Integer.parseInt(dataStr.nextToken());
        int node2 = Integer.parseInt(dataStr.nextToken());
        list[node1].add(node2);
        list[node2].add(node1);
      }

      for (int j = 1; j <= v; j++) {
        if (isEven) {
          dfs(j);
        } else {
          break;
        }
      }

      if (isEven) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static void dfs(int start) {
    visited[start] = true;
    for (int i : list[start]) {
      if (!visited[i]) {
        check[i] = (check[start] + 1) % 2;
        dfs(i);
      } else {
        if (check[start] == check[i]) {
          isEven = false;
        }
      }
    }
  }
}
