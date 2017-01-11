/**
 * Created by pengshuang on 17/1/11.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() < 1 || s.charAt(s.length()-1) == 'e') return false;
        String[] sp = s.split("e");
        if (sp.length > 2 || sp.length < 1) return false;
        // 验证 e 的前半部分,可以允许是小数
        if (!validNumberic(sp[0], false)) return false;
        // 如果 e 后半部分是整数
        if (sp.length == 1 || (sp.length == 2 && validNumberic(sp[1], true))) return true;
        return false;
    }
    private boolean validNumberic(String s, boolean integer){
        int index = 0;
        if (s.length() < 1 || s.equals("."))
            return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            index++;
        if (index == s.length())
            return false;
        char c;
        boolean hasPoint = false;
        boolean hasNum = false;
        for(;index < s.length();index++){
            c = s.charAt(index);
            if(c == '.'){
                if(!hasPoint && !integer) hasPoint = true;
                else return false;
                continue;
            }
            if(c < '0' || c > '9') return false;
            hasNum = true;
        }
        return hasNum;
    }
}
