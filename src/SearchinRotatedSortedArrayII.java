/**
 * Created by pengshuang on 17/1/21.
 * answer:
 * 上一题中如果A[m]>=A[l], 那么[l,m] 为递增序列的假设就不能成立了，比
 * 如[1,3,1,1,1]。
 * 如果A[m]>=A[l] 不能确定递增，那就把它拆分成两个条件：
 * - 若A[m]>A[l]，则区间[l,m] 一定递增
 * - 若A[m]==A[l] 确定不了，那就l++，往下看一步即可。
 */

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left + 1 < right){
            mid = left + ((right-left)>>1);
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] > nums[left]){//[left,mid] 为递增区间
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else if(nums[mid] < nums[left]){//[mid,right] 为递增区间
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                left++;
            }
        }
        if (nums[left] == target)
            return true;
        if (nums[right] == target)
            return true;
        return false;
    }
}
