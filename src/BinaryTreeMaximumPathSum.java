/**
 * Created by pengshuang on 17/1/4.
 * answer: dfs 来进行遍历。先算出左右子树的结果L 和R，如果L 大于0，
 * 那么对后续结果是有利的，我们加上L，如果R 大于0，对后续结果也是有利的，继续加上R。
 */
public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;
        if(left > 0) sum += left;
        if(right > 0) sum += right;
        max = Math.max(max, sum);
        return Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;
    }


    private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null){
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int singlePath =
                Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,
                                Math.max(left.singlePath, 0) +
                                Math.max(right.singlePath, 0) + root.val);
        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum2(TreeNode root){
        ResultType result = helper(root);
        return result.maxPath;
    }
}
