/**
 * Created by pengshuang on 17/1/18.
 * answer: 数字反转会溢出，所以每次取数字的第一个和最后一个进行比较
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while((x/div) >= 10) div *= 10;
        int mod = 10;
        // 如果 x 小于 10
        while (mod <= div) {
            int left = x/div;
            int right = x%mod;
            if (left != right){
                return false;
            }
            x = (x % div)/10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome(String s){
        if (s == null || s.length() == 0) {
            return true;
        }
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){
                front++;
            }
            if (front == s.length())
                return true;
            while (end >= 0 && !isvalid(s.charAt(end))){
                end--;
            }
            if (end == 0)
                return true;
            if (Character.toLowerCase(front) == Character.toLowerCase(end)){
                end--;
                front++;
            } else {
                break;
            }
        }
        return end <= front;
    }

    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

}
