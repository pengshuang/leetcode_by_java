/**
 * Created by pengshuang on 17/1/10.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i=0;i<=blue;){
//          如果为红色
            if (nums[i] == 0) {
                swap(nums, i++, red++);
//          如果为蓝色
            } else if (nums[i] == 2) {
                swap(nums, i, blue--);
//          如果为白色
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
