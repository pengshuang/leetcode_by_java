import java.util.Deque;
import java.util.LinkedList;

public class TestDeque {
    public static void main(String []args) {
        Deque<Integer> deque = new LinkedList();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);

        System.out.println(deque.peekFirst());
    }
}
