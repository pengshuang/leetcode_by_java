import java.util.Stack;

/**
 * Created by pengshuang on 17/1/20.
 * 类比 LargestRectangleinHistogram
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
     if(matrix.length < 1) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] height = new int[n][m];

        // 将这个长方形 类比为 直方图
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0)
                    height[i][j] = ((matrix[i][j] == '1') ? 1 : 0);
                else
                    height[i][j] = ((matrix[i][j] == '1') ? height[i-1][j] + 1 : 0);
            }
        }
        int max = 0;
        for (int  i = 0; i < n; i++) {
            Stack<Integer> S = new Stack<>();
            for (int j = 0; j < m; j++) {
                int curt = (j == height[i].length) ? -1 : height[i][j];
                while (!S.isEmpty() && curt < height[i][S.peek()]) {
                    int h = height[i][S.pop()];
                    int w = S.isEmpty() ? j : j - S.peek() - 1;
                    max = Math.max(max, h * w);
                }
                S.push(j);
            }
            while (!S.empty()) {
                int pos = S.peek();
                S.pop();
                max = Math.max(max, height[i][pos]*(S.empty()? m : m-S.peek()-1));
            }
        }
        return max;
    }
}
