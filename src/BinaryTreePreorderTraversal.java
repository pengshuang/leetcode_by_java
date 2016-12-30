import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pengshuang on 16/12/30.
 * 使用栈来模拟递归的过程
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return result;
        }
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();
            result.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return result;
    }
}
