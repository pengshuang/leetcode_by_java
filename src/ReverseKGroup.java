/**
 * Created by pengshuang on 17/2/4.
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) { // 找到第 k+1 个节点
            cur = cur.next;
            count++;
        }
        if (count == k){ // 如果第 k+1 点被找到了
            cur = reverseKGroup(cur, k); // 把第 k+1 个节点当作头节点, 反转链表
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = cur; // preappending "direct" head to the reversed list
                cur = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next);
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        for(ListNode prev = dmy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
}
