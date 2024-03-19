package Graph;

import java.util.*;

public class Virus1 {
  static ArrayList<Integer>[] computers;
  static boolean[] vir;
  static int count = -1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int comNum = sc.nextInt();
    int netNum = sc.nextInt();

    computers = new ArrayList[comNum + 1];
    vir = new boolean[comNum + 1];

    for (int i = 1; i <= comNum; i++) {
      computers[i] = new ArrayList<>();
    }

    for (int i = 0; i < netNum; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();

      computers[s].add(e);
      computers[e].add(s);
    }

    dfs(1);

    System.out.println(count);
  }

  static private void dfs(int v) {
    vir[v] = true;
    count++;

    for (int next : computers[v]) {
      if (!vir[next]) {
        dfs(next);
      }
    }
  }
}
