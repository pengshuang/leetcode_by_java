/**
 * Created by pengshuang on 17/1/1.
 * 和小于零则取当前值为最大值，不小于零则相加
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum += nums[i];
            }
            else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
