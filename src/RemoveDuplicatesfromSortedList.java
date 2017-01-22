/**
 * Created by pengshuang on 17/1/22.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head;
        while (node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }
}
