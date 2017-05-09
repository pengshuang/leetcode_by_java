import java.util.HashMap;

/**
 * Created by pengshuang on 17/5/9.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])){
                return new int[]{hashmap.get(target - nums[i]), i};
            }
            hashmap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
