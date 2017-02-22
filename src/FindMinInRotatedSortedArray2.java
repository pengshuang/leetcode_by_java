
public class FindMinInRotatedSortedArray2 {
    public int findMin(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == nums[end]) {
                end -=1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        }else {
            return nums[end];
        }
    }


}
