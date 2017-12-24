import java.util.Arrays;

/**
 * Created by pengshuang on 17/12/3.
 */
public class DailyTemperatures {
    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = solve(temperatures, i);
        }
        return res;
    }

    static int solve(int[] nums, int start) {
        int index = nums[start];
        int count = 0;
        int i;
        for (i = start+1; i < nums.length; i++) {
            count++;
            if (nums[i] > index) {
                break;
            }
        }
        if (i == nums.length)
            return 0;
        return count;
    }

    public static void main(String[] args) {
        int[] n = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(n)));
    }
}
