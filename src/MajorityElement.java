import java.util.Arrays;

/**
 * Created by pengshuang on 17/1/28.
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        if(num.length==1){
            return num[0];
        }
        Arrays.sort(num);
        int prev=num[0];
        int count=1;
        for(int i=1; i<num.length; i++){
            if(num[i] == prev){
                count++;
                if(count > num.length/2) return num[i];
            }else{
                count=1;
                prev = num[i];
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
