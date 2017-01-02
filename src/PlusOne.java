/**
 * Created by pengshuang on 17/1/2.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1;i >=0;i--){
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
            if (carry == 0)
                break;
        }
        if(carry > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for(int i = 0; i < digits.length;i++) {
                res[i+1] = digits[i];
            }
            return res;
        }else {
            return digits;
        }
    }
}
