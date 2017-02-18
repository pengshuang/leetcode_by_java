import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/2/18.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        helper(rst, solution, n, k, 1);
        return rst;
    }

    private void helper(
            List<List<Integer>> rst,
            List<Integer> solution,
            int n,
            int k,
            int start
    ){
        if (solution.size() == k){
            rst.add(new ArrayList<>(solution));
        }
        for (int i = start; i <= n; i++) {
            solution.add(i);
            helper(rst, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
