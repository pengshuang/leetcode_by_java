/**
 * Created by pengshuang on 17/1/23.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign;
        if ((dividend < 0) ^ (divisor < 0))
            sign = -1;
        else
            sign = 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (divisor == 0){
            return Integer.MAX_VALUE;
        }
        int result = 0;
        while (dividend >= divisor){
            int i = 1;
            int tmp = divisor;
            while (dividend >= tmp){
                tmp = tmp << 1;
                i += 1;
            }
            result += (1 << (i-2));
            dividend -= (divisor << (i-2));
        }
        result *= sign;
        if (result > Integer.MAX_VALUE - 1){
            result = Integer.MAX_VALUE;
        }
        return result;
    }
}
