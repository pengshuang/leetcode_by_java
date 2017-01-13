/**
 * Created by pengshuang on 17/1/13.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            char lc = validChar(s.charAt(left));
            while (lc == 0 && left < right)
                lc = validChar(s.charAt(++left));
            char rc = validChar(s.charAt(right));
            while (rc == 0 && left < right)
                rc = validChar(s.charAt(--right));
            if(lc==rc){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    private char validChar(char c){
        if(c >= '0' && c <= '9'){
            return c;
        }else if(c >= 'a' && c <= 'z'){
            return c;
        }else if(c >= 'A' && c <= 'Z'){
            return Character.toLowerCase(c);
        }
        return 0;
    }
}
