/**
 * Created by pengshuang on 17/1/15.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String  tmp = a;
            a = b;
            b = tmp;
        }
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String rst = "";

        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
            pb --;
        }

        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0')  + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }

        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }

    public String addBinary2(String a, String b) {
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int carry = 0;
        String rst = "";
        int x, y;
        while (len1 >= 0 || len2 >= 0){
            if (len1 >= 0)
                x = (int)(a.charAt(len1) - '0');
            else
                x = 0;
            if (len2 >= 0)
                y = (int)(b.charAt(len2) - '0');
            else
                y = 0;
            if ((x + y + carry) % 2 == 0)
                rst = '0' + rst;
            else
                rst = '1' + rst;
            carry = (x + y + carry) / 2;
            len1 -= 1;
            len2 -= 1;
        }
        if (carry == 1){
            rst = '1' + rst;
        }
        return rst;
    }
}
