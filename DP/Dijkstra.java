package DP;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 백준 1753
 * 다익스트라
 */
public class Dijkstra {
  static final int INF = Integer.MAX_VALUE;

  static ArrayList<Node>[] list;
  static int[] distance;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int v = sc.nextInt();
    int e = sc.nextInt();
    int startV = sc.nextInt();

    list = new ArrayList[v + 1];
    distance = new int[v + 1];
    visited = new boolean[v + 1];

    for (int i = 1; i <= v; i++) {
      list[i] = new ArrayList<Node>();
      distance[i] = INF;
    }

    for (int i = 0; i < e; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int weight = sc.nextInt();

      list[start].add(new Node(end, weight));
    }

    dijAlgorithm(startV);

    for (int i = 1; i <= v; i++) {
      if (distance[i] != INF) {
        System.out.println(distance[i]);
      } else {
        System.out.println("INF");
      }
    }
  }

  private static void dijAlgorithm(int start) {
    PriorityQueue<Node> queue = new PriorityQueue<>();

    queue.add(new Node(start, 0));
    distance[start] = 0;

    while (!queue.isEmpty()) {
      Node nowInfo = queue.poll();
      int now = nowInfo.end;

      visited[now] = true;

      for (Node neighbor : list[now]) {
        if(!visited[neighbor.end]) {
          if (distance[neighbor.end] > distance[now] + neighbor.weight) {
            distance[neighbor.end] = distance[now] + neighbor.weight;
            queue.add(new Node(neighbor.end, distance[neighbor.end]));
          }
        }
      }
    }
  }
}

class Node implements Comparable<Node> {
  int end, weight;

  public Node(int end, int weight) {
    this.end = end;
    this.weight = weight;
  }

  // 비교 대상이 더 작으면  +
  // 비교 대상이 더 크면    -
  // + 면 대상이 우선 순위 선
  @Override
  public int compareTo(Node o) {
    return weight - o.weight;
  }
}
