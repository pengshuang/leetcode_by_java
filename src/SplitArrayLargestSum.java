/**
 * Created by pengshuang on 17/2/23.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binary(nums, m, sum, max);
    }

    private long binary(int[] nums, int m, long high, long low){
        long mid;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (valid(nums, m, mid))
                high = mid;
            else
                low = mid;
        }
        return high;
    }

    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for(int num: nums){
            cur += num;
            if (cur > max){
                cur = num;
                count++;
                if (count > m)
                    return false;
            }
        }
        return true;
    }
}
