package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 7576번 / 골드5
 * - BFS
 * BFS의 특성을 잘이해하고,
 * x y 가 있는 경우 제대로 동작이 안된다면 처음부터 차근차근 다시 봐라
 */
public class Tomato1 {
  static final int[] dx = { 0, 1, 0, -1 };
  static final int[] dy = { -1, 0, 1, 0 };

  static int m;
  static int n;

  static int[][] tomatos;
  static ArrayList<int[]> ripe;

  static int notRipedCount = 0;
  static int ripedCount = 0;
  static int maxDay = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    m = sc.nextInt();
    n = sc.nextInt();

    tomatos = new int[n][m];
    ripe = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int input = sc.nextInt();

        tomatos[i][j] = input;

        if (input == 0) {
          notRipedCount++;
        } else if (input == 1) {
          ripe.add(new int[] { i, j });
        }
      }
    }

    search();

    if (ripedCount == notRipedCount) {
      if (maxDay == 0) {
        System.out.println(0);
      } else {
        System.out.println(maxDay - 1);
      }
    } else {
      System.out.println(-1);
    }
  }

  private static void search() {
    Queue<ArrayList<int[]>> q = new LinkedList<>();

    q.offer(ripe);

    while (!q.isEmpty()) {
      ArrayList<int[]> nowInfos = q.poll();
      ArrayList<int[]> nextList = new ArrayList<>();

      for (int[] now : nowInfos) {
        int x = now[1];
        int y = now[0];

        for (int i = 0; i < 4; i++) {
          int mx = x + dx[i];
          int my = y + dy[i];

          if (mx >= 0 && mx < m && my >= 0 && my < n && tomatos[my][mx] != -1 && tomatos[my][mx] == 0) {
            tomatos[my][mx] = tomatos[y][x] + 1;
            maxDay = Math.max(maxDay, tomatos[my][mx]);
            ripedCount++;

            nextList.add(new int[] { my, mx });
          }
        }
      }

      if (nextList.size() != 0) {
        q.offer(nextList);
      }
    }
  }
}
