import java.util.Arrays;

/**
 * Created by pengshuang on 2018/12/23.
 */
public class NRepeatedElementinSize2NArray {
    public static int repeatedNTimes(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        int pre = A[0];
        for (int i = 1; i < len; i++) {
            if (A[i] != pre) {
                pre = A[i];
            } else {
                break;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] A = new int[]{9,5,3,3};
        System.out.println(repeatedNTimes(A));
    }
}
