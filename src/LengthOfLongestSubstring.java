/**
 * Created by pengshuang on 17/5/9.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hashmap = new boolean[256];
        int res = 0;
        int j = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            while (j < length && !hashmap[s.charAt(j)]) {
                hashmap[s.charAt(j)] = true;
                res = Math.max(res, j - i + 1);
                j += 1;
            }
            hashmap[s.charAt(i)] = false;
        }
        return res;
    }
}
