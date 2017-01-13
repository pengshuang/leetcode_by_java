/**
 * Created by pengshuang on 17/1/13.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
            cur = cur.next;
        }
        return newHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            ListNode n1 = p.next;
            ListNode n2 = p.next.next;
            p.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            p = n1;
        }
        return dummy.next;
    }
}
