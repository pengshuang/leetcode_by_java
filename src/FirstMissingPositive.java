/**
 * Created by pengshuang on 16/12/29.
 *
 * 交换数组元素，使得数组中第i位存放数值(i+1)。时间O(N)，空间O(1)
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i] != i+1){
                if(nums[i]<=0 || nums[i] >= nums.length || nums[nums[i]-1] == nums[i]){
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
        }
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                break;
            }
        }
        return i+1;
    }

    private void swap(int[] A, int x, int y){
        if(A[x] != A[y]){
            A[x] ^= A[y];
            A[y] ^= A[x];
            A[x] ^= A[y];
        }
    }
}
