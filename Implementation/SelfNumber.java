package Implementation;

/**
 * 백준 4673번 / 실버5
 * - 구현, 수학, 완전 탐색
 */
public class SelfNumber {
  final static int N = 10000;
  static int[] d;
  public static void main(String[] args) {
    d = new int[N];

    for (int i = 1; i < N; i++) {
      self(i);
    }

    for (int i = 1; i < N; i++) {
      if(d[i] == 0) {
        System.out.println(i);
      }
    }

    return;
  }

  private static void self(int n) {
    int sumResult = n + eachSum(n);

    if(sumResult >= N) {
      return;
    } else {
      d[sumResult] += 1;
      self(sumResult);
    }
  }

  private static int eachSum(int n) {
    int result = 0;
    for (int i = 1; i <= N; i *= 10) {
      int mod = n / i;
      int calc = mod % 10;
      result += calc;
    }

    return result;
  }
}
