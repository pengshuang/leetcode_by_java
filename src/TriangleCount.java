import java.util.Arrays;

/**
 * Created by pengshuang on 17/7/11.
 */
public class TriangleCount {
    public int triangleCount(int S[]) {
        int left = 0, right = S.length - 1;
        int ans = 0;
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right){
                if (S[left] + S[right] > S[i]) {
                    ans += (right - left);
                    right -= 1;
                }else {
                    left += 1;
                }

            }
        }
        return ans;
    }
}
