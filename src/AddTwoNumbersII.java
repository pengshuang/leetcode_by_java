/**
 * Created by pengshuang on 16/12/27.

 1. 统计两链表长度s1, s2；最终结果链表长度s = max(s1, s2) （若有进位，则为s+1）

 2. 将两链表对齐并逐节点求和，记头节点为h（头节点为dummy node，最高位从h.next开始）

 3. 初始令指针p指向头节点h，执行循环：

 令指针q = p.next，重复向其下一节点移动，直到q为空或者q.val ≠ 9

 如果q.val ＞ 9，说明p与q之间的所有节点需要进位，令p向q移动同时修改p.val

 否则，令p = q

 */
public class AddTwoNumbersII {
    public int getSize(ListNode h){
        int count = 0;
        while(h != null){
            count += 1;
            h = h.next;
        }
        return count;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int s1 = getSize(l1);
            int s2 = getSize(l2);
            int s = Math.max(s1, s2);
            ListNode p = new ListNode(0);
            ListNode h = p;
            while(s > 0){
                p.next = new ListNode(0);
                p = p.next;
                if(s <= s1){
                    p.val += l1.val;
                    l1 = l1.next;
                }
                if(s <= s2){
                    p.val += l2.val;
                    l2 = l2.next;
                }
                s -= 1;
            }
            p = h;
            while(p != null){
                ListNode q = p.next;
                while(q != null && q.val == 9){
                    q = q.next;
                }
                if(q != null && q.val > 9){
                    while (p != q){
                        p.val += 1;
                        p = p.next;
                        p.val -= 10;
                    }
                }
                else {
                    p = q;
                }
            }
            if(h.val > 0){
                return h;
            }else
                return h.next;
    }

}
