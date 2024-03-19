package Structure.Queue;
import java.util.*;

/**
 * 백준 1715번 / 골드4
 * - 그리디, 우선 순위 큐
 * 조건을 잘 읽을 것
 * 조건 적용을 지속적으로 시켜야한다면 그걸 어떻게 적용 시킬지 고민
 * -> 여기서는 정렬이 계속 필요하니 넣을 때부터 정렬되는 우선 순위 큐를 사용함
 */
public class CardSorting1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        long min = 0;

        while (pq.size() > 1) {
            int o1 = pq.poll();
            int o2 = pq.poll();

            int sum = o1 + o2;

            pq.offer(sum);
            min += sum;
        }

        System.out.println(min);

        sc.close();
    }
}
