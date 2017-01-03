/**
 * Created by pengshuang on 17/1/3.
 * 注意最后要判断 b 是否大于等于 0
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int a = m-1;
        int b = n-1;
        while (a >= 0 && b >= 0){
            if(nums1[a] > nums2[b]){
                nums1[index--] = nums1[a--];
            }else {
                nums1[index--] = nums2[b--];
            }
        }
        if(b>=0){
            for(int i=0;i<=b;i++){
                nums1[i] = nums2[i];
            }
        }
    }
}
