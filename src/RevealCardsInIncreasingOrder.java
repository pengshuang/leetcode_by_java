import java.util.*;

/*
We simulate the reversed process.
Initial an empty list or deque or queue,
each time rotate the last element to the first,
and append a the next biggest number to the left.

Time complexity:
O(NlogN) to sort,
O(N) to construct using deque or queue.
*/

public class RevealCardsInIncreasingOrder {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            if (q.size() > 0)
                q.add(q.poll());
            q.add(deck[i]);
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] deck = new int[]{17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
