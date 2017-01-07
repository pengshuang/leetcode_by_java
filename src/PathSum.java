/**
 * Created by pengshuang on 17/1/7.
 * answer: 当有一条匹配了就直接返回，可以剪枝
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
