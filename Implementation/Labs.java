package Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 14502번 / 골드 4
 * - 구현
 * - 완전 탐색
 * - bfs, dfs
 */
public class Labs {

  static int[][] labs;
  static ArrayList<int[]> wall = new ArrayList<>();
  static ArrayList<int[]> vir = new ArrayList<>();

  static int col;
  static int row;

  static int maxSafe = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    col = sc.nextInt();
    row = sc.nextInt();

    labs = new int[col][row];
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        labs[i][j] = sc.nextInt();
        if (labs[i][j] == 0)
          wall.add(new int[] { i, j });
        if (labs[i][j] == 2)
          vir.add(new int[] { i, j });
      }
    }

    installWall();

    System.out.println(maxSafe);

    sc.close();
  }

  static private void installWall() {
    int wallSize = wall.size();

    for (int i = 0; i < wallSize - 2; i++) {
      for (int j = i + 1; j < wallSize - 1; j++) {
        for (int k = j + 1; k < wallSize; k++) {
          labs[wall.get(i)[0]][wall.get(i)[1]] = 1;
          labs[wall.get(j)[0]][wall.get(j)[1]] = 1;
          labs[wall.get(k)[0]][wall.get(k)[1]] = 1;

          maxSafe = Math.max(getSafeNumber(), maxSafe);

          labs[wall.get(i)[0]][wall.get(i)[1]] = 0;
          labs[wall.get(j)[0]][wall.get(j)[1]] = 0;
          labs[wall.get(k)[0]][wall.get(k)[1]] = 0;
        }
      }
    }
  }

  static private int getSafeNumber() {
    int[][] tempLabs = new int[labs.length][];
    for (int i = 0; i < tempLabs.length; i++) {
      tempLabs[i] = Arrays.copyOf(labs[i], labs[i].length);
    }

    spreadVir(tempLabs);

    int count = 0;
    for (int i = 0; i < tempLabs.length; i++) {
      for (int j = 0; j < tempLabs[0].length; j++) {
        if (tempLabs[i][j] == 0) {
          count++;
        }
      }
    }

    return count;
  }

  static private void spreadVir(int[][] tempLabs) {
    int[] dx = new int[] { 0, 1, 0, -1 };
    int[] dy = new int[] { -1, 0, 1, 0 };

    Stack<int[]> stack = new Stack<>();

    for (int[] v : vir) {
      stack.push(v);
    }

    while (!stack.isEmpty()) {
      int[] nowInfo = stack.pop();
      int x = nowInfo[1];
      int y = nowInfo[0];

      for (int i = 0; i < 4; i++) {
        int mx = x + dx[i];
        int my = y + dy[i];

        if (mx >= 0 && mx < row && my >= 0 && my < col && tempLabs[my][mx] == 0) {
          tempLabs[my][mx] = 2;
          stack.push(new int[] { my, mx });
        }
      }
    }
  }
}
