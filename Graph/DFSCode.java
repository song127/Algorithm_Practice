package Graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * DFS 원초 코드
 * - 모든 노드를 방문하고자 할 때
 * - 검색 속도 느림
 *
 * - 인접 리스트로 표현된 그래프 : O(N+E)
 * - 인접 행렬로 표현된 그래프 : O(N^2)
 *
 * #유형
 * - 모든 노드 방문
 * - 경로 찾기
 * - 사이클 존재 여부 확인
 */
public class DFSCode {
  static ArrayList<Integer>[] adjList;
  static boolean[] visited;

  public static void main(String[] args) {
    // adjList V 만큼 초기화
    // visited V 만큼 초기화
    // dfs(startV)호출
  }

  private static void dfsGeneral(int statrtV) {
    Stack<Integer> stack = new Stack<>();

    visited[statrtV] = true;
    stack.push(statrtV);

    while (!stack.isEmpty()) {
      int vertex = stack.pop();

      for (int neighbor : adjList[vertex]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          stack.push(neighbor);
          break;
        }
      }
    }
  }

  private static void dfsRecursion(int startV) {
    visited[startV] = true;

    for (int newVertex : adjList[startV]) {
      if(!visited[newVertex]) {
        dfsRecursion(newVertex);
      }
    }
  }
}
