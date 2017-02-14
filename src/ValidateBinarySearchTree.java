import java.util.Stack;

/**
 * Created by pengshuang on 17/2/14.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (s.isEmpty()) {
                break;
            }
            cur = s.pop();
            if (pre != null && pre.val >= cur.val) {
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long low, long up) {
        if (root == null) {
            return true;
        }
        if (root.val >= up || root.val <= low) {
            return false;
        }
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, up);
    }
}
