package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch {
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { -1, 0, 1, 0 };
  static boolean[][] visited;
  static int[][] maze;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer sTokenizer = new StringTokenizer(bReader.readLine());

    n = Integer.parseInt(sTokenizer.nextToken());
    m = Integer.parseInt(sTokenizer.nextToken());

    maze = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      sTokenizer = new StringTokenizer(bReader.readLine());
      String lineStrs = sTokenizer.nextToken();

      for (int j = 0; j < m; j++) {
        maze[i][j] = Integer.parseInt(lineStrs.substring(j, j + 1));
      }
    }

    bfs(0, 0);

    System.out.println(maze[n - 1][m - 1]);
  }

  private static void bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { i, j });
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0];
      int y = now[1];

      visited[x][y] = true;
      for (int k = 0; k < 4; k++) {
        int newX = x + dx[k];
        int newY = y + dy[k];

        boolean isValid = newX >= 0 && newY >= 0 && newX < n && newY < m;
        if (isValid) {
          boolean isAble = maze[newX][newY] != 0 && !visited[newX][newY];
          if (isAble) {
            visited[newX][newY] = true;
            maze[newX][newY] = maze[x][y] + 1;
            queue.add(new int[] { newX, newY });
          }
        }
      }
    }
  }
}
