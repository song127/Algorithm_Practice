package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 원초 코드
 * - 특정 노드 간의 거리
 * - 최단 거리를 구할 때 쓰임
 * - 두 노드의 경로를 찾고싶은 경우 쓰임
 * - 검색 속도 빠름
 *
 * - 인접 리스트로 표현된 그래프 : O(N+E)
 * - 인접 행렬로 표현된 그래프 : O(N^2)
 *
 * #유형
 * - 최단거리 찾기
 */
public class BFSCode {
  static ArrayList<Integer>[] adjList;
  static boolean[] visited;
  public static void main(String[] args) {

  }

  public static void bfs(int startV) {
    Queue<Integer> queue = new LinkedList<>();
    visited[startV] = true;
    queue.add(startV);

    while(!queue.isEmpty()) {
      int vertex = queue.poll();

      for (int neighbor : adjList[vertex]) {
        if(!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
      }
    }
  }
}
