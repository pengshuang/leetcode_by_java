/**
 * Created by pengshuang on 17/1/1.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null) return null;
        String result = s.substring(0, 1);
        for(int i=1;i<s.length();i++){
            String p1 = findPalindrome(s,i-1,i);
            String p2 = findPalindrome(s,i-1,i+1);

            String longer = p1.length() > p2.length() ? p1:p2;
            result = longer.length() > result.length() ? longer:result;
        }
        return result;
    }

    private String findPalindrome(String s, int start, int end){
        while (start >= 0 && end <= s.length()-1){
            if(s.charAt(start) != s.charAt(end))
                break;
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}
