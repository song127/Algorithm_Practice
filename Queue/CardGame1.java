package Queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGame1 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Queue<Integer> cardDeck = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      cardDeck.add(i);
    }

    while(cardDeck.size() > 1) {
      cardDeck.poll();
      cardDeck.add(cardDeck.poll());
    }

    System.out.println(cardDeck.poll());
  }
}
