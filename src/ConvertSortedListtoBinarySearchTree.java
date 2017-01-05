/**
 * Created by pengshuang on 17/1/5.
 * answer: 自底向上构建的方法，时间O(N) 空间O(1)
 * 其实这个链表就是一个二叉树的先序遍历结果。
 * 在递归中传的都是同一个链表，只是这个链表的节点不停往前走；而真正决定性变化的是区间；
 * 可以看到，每次递归调用开始时，节点指针都指向区间第一个，结束时节点的指针指向区间末尾的后一个。
 * 每次递归调用时，分成左右两部分，左边构造完时，正好指针指向mid，创建一下root，继续构造右部分子树。
 */

public class ConvertSortedListtoBinarySearchTree {
    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null){
            length++;
            node = node.next;
        }
        cur = head;
        return buildTree(length);
    }

    private TreeNode buildTree(int length){
        if (length <= 0) return null;
        TreeNode left = buildTree(length / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = buildTree(length - 1 - length/2);
        root.left = left;
        root.right = right;
        return root;
    }
}
