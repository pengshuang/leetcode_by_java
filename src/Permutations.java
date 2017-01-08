import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/1/8.
 * answer: 固定前一个，递归交换后面的元素
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null) {
            return rst;
        }
        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }
        List<Integer> list = new ArrayList<Integer>();
        subsetshelper(rst, list, nums);
        return rst;
    }

    private void subsetshelper(List<List<Integer>> rst, List<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            subsetshelper(rst, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
