import java.util.Arrays;

/**
 * Created by pengshuang on 17/5/16.
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
