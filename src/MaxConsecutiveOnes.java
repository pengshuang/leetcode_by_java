/**
 * Created by pengshuang on 17/1/20.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        if (nums.length <= 0)
            return 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == 1){
                count++;
            }else if (nums[i] == 0){
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}
