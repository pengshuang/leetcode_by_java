import java.util.Arrays;

/**
 * Created by pengshuang on 17/12/24.
 */
public class DominantIndex {
    public static int dominantIndex(int[] nums) {
        int max = getMax(nums)[1];
        int maxindex = getMax(nums)[0];
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i == maxindex || max >= 2 * nums[i]){
                continue;
            }
            break;
        }
        if (i == nums.length) {
            return maxindex;
        }
        return -1;
    }

    public static int[] getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new int[]{index, max};
    }

    public static void main(String[] args) {
        int[] n = new int[]{1, 2, 3, 4};
        System.out.println(dominantIndex(n));
    }
}
