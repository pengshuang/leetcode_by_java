/**
 * Created by pengshuang on 17/1/8.
 */
public class ReverseInteger {
    public int reverse(int x) {
        long r = 0;
        while(x != 0){
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)r;
    }


    public int reverse2(int n) {
        int reversed_n = 0;

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }
}
