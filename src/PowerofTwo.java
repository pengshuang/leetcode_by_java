/**
 * Created by pengshuang on 17/1/25.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 0)
            return false;
        int preN = n - 1;
        if ((preN & n) != 0)
            return false;
        else
            return true;
    }
}
