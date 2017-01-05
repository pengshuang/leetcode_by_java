import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/1/5.
 * 公式 a^(a>>1)
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        int length = 1 << n;
        List<Integer> result = new ArrayList<>(length);
        for (int i = 0; i< length; i++) {
            int gray = i ^ (i >> 1);
            result.add(gray);
        }
        return result;
    }
}
