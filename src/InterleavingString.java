/**
 * Created by pengshuang on 17/1/20.
 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.

 * answer: 动态规划，dp[i][n-i] 表示s3的前n的子串是否可以由s1前i的子串和s2前(n-i)的子串构成
 * 则有动态方程：
 * dp[i][n-i] = (i-1 >=0 && dp[i-1][n-i] && s1[i-1]==s3[n-1]) ||
 * 		        (n-i-1 >= 0 && dp[i][n-i-1] && s2[n-i-1]==s3[n-1])
 */

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0])
                dp[i][0] = true;
        }

        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && dp[0][j - 1])
                dp[0][j] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]))
                        || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && dp[i][j - 1]))
                    dp[i][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
