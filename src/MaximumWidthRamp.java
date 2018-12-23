/**
 * Created by pengshuang on 2018/12/23.
 */
public class MaximumWidthRamp {
    public static int maxWidthRamp(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int sub = A[j] - A[i];
                if (sub >= 0 && j - i > res) {
                    res = j - i;
                }
            }
        }
        return res;
    }

    public static int maxWidthRamp2(int[] A) {
        int n = A.length;
        int i, j , max = 0;
        int[] maxR = new int[n], minL = new int[n];
        minL[0] = A[0];
        for (i = 1; i < n; i++){
            minL[i] = Math.min(A[i], minL[i - 1]);
        }
        maxR[n - 1] = A[n - 1];
        for (j = n - 2; j >= 0; j--){
            maxR[j] = Math.max(A[j], maxR[j + 1]);
        }
        i = 0; j = 0;
        while (i < n && j < n){
            if (minL[i] <= maxR[j]){
                max = Math.max(max, j - i);
                j++;
            }else{
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = new int[]{6,0,8,2,1,5};
        System.out.println(maxWidthRamp2(num));

        int[] num2 = new int[]{9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp2(num2));
    }
}
