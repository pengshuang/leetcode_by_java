import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pengshuang on 16/12/28.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 2) {
            return 1;
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(Arrays.asList(1,2));
        for(int i=0; i<n-2; i++) {
            res.add(res.get(res.size()-1) + res.get(res.size()-2));
        }
        return res.get(res.size()-1);
    }

    public int climbStairs2(int n) {
        int pre = 0;
        int cur = 1;
        for(int i=1; i<=n;i++){
            int temp = pre+cur;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
