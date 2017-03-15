/**
 * Created by pengshuang on 17/3/15.
 */
public class VerifyPreOrder {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1};
        System.out.println(isPreOrder(nums, 0, nums.length-1));
    }

    public static boolean isPreOrder(int nums[], int start, int end) {
        if (start >= end)
            return true;
        int root = nums[start];
        int spiltPos = start+1;

        for (;spiltPos <= end; spiltPos++) {
            if (nums[spiltPos] > root) break;
        }

        for (int i = spiltPos; i <= end; i++) {
            if (nums[i] < root) return false;
        }

        return isPreOrder(nums, start+1, spiltPos-1) && isPreOrder(nums, spiltPos, end);
    }
}