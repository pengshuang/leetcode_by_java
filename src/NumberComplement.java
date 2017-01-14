/**
 * Created by pengshuang on 17/1/14.
 */
public class NumberComplement {
    public int findComplement(int num) {
        int res = 0;
        int i = 0;
        while (num != 0) {
            if((num & 1) == 0){
                res += (1 << i); // res ^= (1 << i)
            }
            num = (num >> 1);
            i++;
        }
        return res;
    }
}
