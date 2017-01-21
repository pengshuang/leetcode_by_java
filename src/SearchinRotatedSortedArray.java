/**
 * Created by pengshuang on 17/1/21.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left + 1 < right){
            mid = left + ((right-left)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[left]){//[left,mid] 为递增区间
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }else {
                    left = mid;
                }
            }
            else{//[mid,right] 为递增区间
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target)
            return left;
        if (nums[right] == target)
            return right;
        return -1;
    }
}
