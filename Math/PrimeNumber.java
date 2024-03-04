package Math;
import java.util.Scanner;

/*
 * 백준 1929
 * 에라토스테네스의 체
 *
 * - 제곱근까지만 실행해보는 이유 다시 참고
 *  - 한편, 에라토스테네스의 체를 이용해 1~n까지의 소수를 알고 싶다면, n까지 모든 수의 배수를 다 나눠 볼 필요는 없다.
 * 만약 n보다 작은 어떤 수 m이 m=ab라면 a와 b 중 적어도 하나는 n^1/2 이하이다.
 * 즉, n보다 작은 합성수 m은 n^1/2보다 작은 수의 배수만 체크해도 전부 지워진다는 의미이므로, n^1/2 이하의 수의 배수만 지우면 된다.
 * 단적으로 1~100인 위의 경우,
 * 사실은 7의 배수 중 남아있는 49(7*7), 77(7*11), 91(7*13)만 더 지우면 끝난다.
 * 만일 표에 112(121)보다 큰 수가 있다면 11을 제외한 11의 배수를 지워야 하는데,
 * 이 과정에서 최초로 지워지는 수는 121(112)이다.
 * 그런데 이는 주어진 범위를 초과하는 수다. (중요)
 * =>
 *    a*b 의 경우 루트n * 루트n 일 때, a가 루트 n보다 크면 b는 루트n 보다 작아질 수밖에 없음
 *    즉, 둘 중 하나는 루트 n 보다 작음.
 *    이때, a가 더 커서 의문이 든다면, b가 더 작은 수일 때의 b는 언젠가 a를 곱해서 이미 연산을 했을 것임.
 *    그렇기 때문에 의문의 수 k = a*b 일 때 k 는 이미 나온 수임.
 *    그래서 루트 n 보다 작은 수들만 점검하면 b가 나올 것이기때문에 a는 자연스럽게 나옴.
 *
 * - O(n * loglogn)
 */
public class PrimeNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();

    int[] result = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      result[i] = i;
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (result[i] == 0)
        continue;

      for (int j = 2 * i; j <= n; j += i) {
        result[j] = 0;
      }
    }

    for (int i = m; i <= n; i++) {
      if (result[i] != 0)
        System.out.println(result[i]);
    }
  }
}
