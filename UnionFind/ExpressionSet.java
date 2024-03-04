package UnionFind;

import java.util.Scanner;

/**
 * 백준 1717
 * 유니온 파인드, 분리 집합
 * - 무조건 경로 압축 필요
 */
public class ExpressionSet {
  static int[] repreArr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    repreArr = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      repreArr[i] = i;
    }

    for (int i = 0; i < m; i++) {
      int q = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      if (q == 0) {
        union(a, b);
      } else {
        if (isSameParent(a, b)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a < b) {
      repreArr[b] = a;
    } else {
      repreArr[a] = b;
    }
  }

  private static int find(int target) {
    if (target == repreArr[target]) {
      return target;
    } else {
      return repreArr[target] = find(repreArr[target]);
    }
  }

  private static boolean isSameParent(int a, int b) {
    if (find(a) == find(b)) {
      return true;
    } else {
      return false;
    }
  }
}
