/**
 * Created by pengshuang on 17/3/15.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (j == 0){
                    dp[i][j] = i == 0;
                } else if (p.charAt(j - 1) == '*'){
                    if (j < 2) {
                        return false;
                    }
                    for (int k = 0; k < i; k++) {
                        if (k != 0 && !isSame(s.charAt(i - k), p.charAt(j - 2))){
                            dp[i][j] = false;
                        }

                        if (dp[i - k][j - 2]){
                            dp[i][j] = true;
                            break;
                        }
                    }
                } else {
                    /*
                    首先 s 中至少还要有一个字符，然后再匹配一个字符，以及上一级也要匹配即可
                    */
                    dp[i][j] = i >= 1
                            && isSame(s.charAt(i - 1), p.charAt(j - 1))
                            && dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public boolean isSame(char c, char p) {
        return p == '.' || c == p;
    }
}
