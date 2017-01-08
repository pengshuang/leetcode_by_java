/**
 * Created by pengshuang on 17/1/8.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int flag = nums[0];
        for (int i = 1; i<nums.length;i++){
            flag ^= nums[i];
        }
        return flag;
    }
}
