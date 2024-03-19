package Structure.Queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 뱍쥰 2164
 * - 문제가 말하는 방법의 흐름을 파악해라
 * - 큐를 자세히 이해하라
 */
public class CardGame1 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Queue<Integer> cardDeck = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      cardDeck.add(i);
    }

    // "큰 수"에서 "작은 수"까지의 경우, 작은 수 보다 크면 된다.
    // 작은 수가 포함되는 경우 "=", 작은 수까지만 실행되는 경우 "!="
    while(cardDeck.size() > 1) {
      cardDeck.poll();
      cardDeck.add(cardDeck.poll());
    }

    System.out.println(cardDeck.poll());
  }
}
