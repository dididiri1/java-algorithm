import java.util.Collections;
import java.util.PriorityQueue;

public class Main2 {

    public static void main(String[] args) {

        //PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 낮은순
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 높은순

        pQ.add(1);
        pQ.offer(2);
        pQ.offer(3);

        System.out.println(pQ.poll());

    }
}
