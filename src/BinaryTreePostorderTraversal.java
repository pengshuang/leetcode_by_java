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

    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        TreeNode node = root;
        TreeNode pre;
        do {
            while (node != null){ //左边的节点都进栈
                stack.push(node);
                node = node.left;
            }
            pre = null;
            while (!stack.isEmpty()){
                node = stack.peek();
                //如果右子树访问过了或为空，则访问该节点
                if(node.right == pre){
                    result.add(stack.pop().val);
                    pre = node;
                }else {
                    node = node.right;
                    break; //先处理右子树
                }
            }
        }while (!stack.isEmpty());
        return result;
    }
}
