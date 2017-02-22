/**
 * Created by pengshuang on 17/2/22.
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums){
        if (nums.length == 0)
            return 0;
        int start = 0;
        int end = nums.length - 1;
        int target = nums[-1];
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] <= target){
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    public int findMin2(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
