import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pengshuang on 16/12/30.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
