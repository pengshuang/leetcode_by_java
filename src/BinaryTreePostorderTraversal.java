import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pengshuang on 16/12/30.
 */

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        stack.push(root);
        TreeNode pre = null;
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node = stack.peek();
            if ((node.left == null && node.right == null) //如果是叶子节点
                    //或者之前遍历过的节点是当前节点的孩子节点
                    || (pre != null && (pre == node.left || pre == node.right))) {
                pre = stack.pop();
                result.add(pre.val);
            }
            else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return result;
    }
}
