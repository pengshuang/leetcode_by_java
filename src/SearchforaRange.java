/**
 * Created by pengshuang on 17/1/8.
 * 二分查找法
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = binarySearchForFirst(nums, target);
        int last = binarySearchForLast(nums, target);
        return new int[]{first, last};
    }

    private int binarySearchForLast(int[] A, int target){
        int left = 0;
        int right = A.length-1;
        int mid;
        while(left < right){
            mid = left + ((right-left+1)>>1);
            if(A[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        if(A[left] == target)
            return left;
        else
            return -1;
    }

    private int binarySearchForFirst(int[] A, int target){
        int left = 0;
        int right = A.length-1;
        int mid;
        while(left < right){
            mid = left + ((right-left+1)>>1);
            if(A[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(A[left] == target)
            return left;
        else
            return -1;
    }
}
