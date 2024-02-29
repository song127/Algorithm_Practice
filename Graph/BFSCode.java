package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
