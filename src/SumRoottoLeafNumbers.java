/**
 * Created by pengshuang on 17/1/16.
 * 深度遍历树
 */
public class SumRoottoLeafNumbers {
    private int sum;
    public int sumNumbers(TreeNode root) {
        recursivePath(root, 0);
        return sum;
    }
    private void recursivePath(TreeNode root, int num) {
        if (root == null)
            return;
        num = num * 10 + root.val;
        if (root.left != null) {
            recursivePath(root.left, num);
        }
        if (root.right != null) {
            recursivePath(root.right, num);
        }
        if (root.left == null && root.right == null) {
            sum += num;
        }
    }
}
