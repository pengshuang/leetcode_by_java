import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/1/9.
 */
public class PathSumII {
    private void findSum(List<List<Integer>> result, List<Integer> solution, TreeNode root, int sum){
        if (root == null) return;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                solution.add(root.val);
                result.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size()-1);
            }
            return;
        }
        solution.add(root.val);
        findSum(result, solution, root.left, sum);
        findSum(result, solution, root.right, sum);
        solution.remove(solution.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        findSum(res, solution, root, sum);
        return res;
    }
}
