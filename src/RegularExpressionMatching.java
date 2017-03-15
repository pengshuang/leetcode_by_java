/**

 D[i][j]: 表示string s中取i长度的字串，string p中取j长度字串，进行匹配。

 状态转移：

 1. j >= 2 && P[j - 1] = *，这时，我们可以选择匹配s中的空字串，或匹配无限个。

 k: 在s中匹配的字符的个数

 所以转移式是：D[i][j] = D[i - k][j - 2] && isSame(s.charAt(i - k), p.charAt(j - 2))   (k: 1-i)

 D[i - k][j - 2]  (k = 0)

 2. p最后一个字符不是*

 那么首先，s中至少还要有一个字符，然后再匹配一个字符，以及上一级也要匹配即可。

 D[i][j] = i >= 1
 && isSame(s.charAt(i - 1), p.charAt(j - 1))
 && D[i - 1][j - 1];

 3. j = 0;

 D[i][j] = i == 0;  (p为空，则s也是要为空才可以匹配）
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
