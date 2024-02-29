package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFSCode {
  static ArrayList<Integer>[] adjList;
  static boolean[] visited;

  public static void main(String[] args) {
    // adjList V 만큼 초기화
    // visited V 만큼 초기화
    // dfs(startV)호출
  }

  private static void dfs(int statrtV) {
    Stack<Integer> stack = new Stack<>();
    stack.push(statrtV);
    visited[statrtV] = true;

    while (!stack.isEmpty()) {
      int vertex = stack.pop();

      for (int neighbor : adjList[vertex]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          stack.push(neighbor);
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
