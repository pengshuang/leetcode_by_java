/**
 * Created by pengshuang on 17/1/11.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(right == null && left == null) return true;
        if(right == null || left == null) return false;
        return (left.val == right.val) &&
                isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }
}
