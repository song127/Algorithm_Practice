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

public class BipartiteGraph {
  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

    int caseNumber = Integer.parseInt(bReader.readLine());

    for (int i = 0; i < caseNumber; i++) {
      StringTokenizer dataStr = new StringTokenizer(bReader.readLine());

      int v = Integer.parseInt(dataStr.nextToken());
      int e = Integer.parseInt(dataStr.nextToken());
      ArrayList<Integer>[] list = new ArrayList[v + 1];
      for (int j = 1; j <= v; j++) {
        list[j] = new ArrayList<>();
      }

      for (int j = 0; j < e; j++) {
        dataStr = new StringTokenizer(bReader.readLine());
        int node1 = Integer.parseInt(dataStr.nextToken());
        int node2 = Integer.parseInt(dataStr.nextToken());
        list[node1].add(node2);
        list[node2].add(node1);
      }

      System.out.println(isBipTreeDFS(v, list));
    }
  }

  private static String isBipTreeDFS(int vNum, ArrayList<Integer>[] list) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[vNum + 1];
    boolean[] check = new boolean[vNum + 1];

    for (int i = 1; i <= vNum; i++) {
      stack.clear();
      for(int j = 1; j < vNum + 1; j++) {
        visited[j] = false;
        check[j] = false;
      }

      visited[i] = true;
      stack.add(i);

      while (!stack.isEmpty()) {
        int now = stack.pop();

        for (int neighbor : list[now]) {
          if (!visited[neighbor]) {
            check[neighbor] = !check[now];
            visited[neighbor] = true;
            stack.add(neighbor);
          } else {
            if(check[now] == check[neighbor]) {
              return "NO";
            }
          }
        }
      }
    }

    return "YES";
  }

  // private static String isBinaryTreeBFS(int vNum, ArrayList<Integer>[] list) {
  // Queue<Integer> queue = new LinkedList<>();
  // boolean[] visited = new boolean[vNum + 1];

  // visited[1] = true;
  // queue.add(1);

  // while(!queue.isEmpty()) {
  // int now = queue.poll();

  // if(list[now].size() % 2 != 0) return "NO";
  // for (int neighbor : list[now]) {
  // if(!visited[neighbor]) {
  // visited[neighbor] = true;
  // queue.add(neighbor);
  // }
  // }
  // }

  // return "YES";
  // }
}
