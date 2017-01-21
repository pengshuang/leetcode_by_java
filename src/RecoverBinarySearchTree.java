import java.util.Stack;

/**
 * Created by pengshuang on 17/1/21.
 * 中序遍历 递归形式
 */
public class RecoverBinarySearchTree {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

    private void traverse(TreeNode root){
        if (root == null){
            return;
        }
        traverse(root.left);
        if (firstElement == null && root.val < lastElement.val){
            firstElement = lastElement;
        }
        if (firstElement != null && root.val < lastElement.val) {
            secondElement = root;
        }
        lastElement = root;
        traverse(root.right);
    }

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    public void recoverTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (s.isEmpty()) {
                break;
            }
            TreeNode node = s.pop();
            if (pre != null) {
                // invalid order
                if (pre.val > node.val) {
                    if (node1 == null) {
                        node1 = pre;
                        node2 = node;
                    } else {
                        node2 = node;
                    }
                }
            }
            pre = node;
            cur = node.right;
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
        return;
    }
}
