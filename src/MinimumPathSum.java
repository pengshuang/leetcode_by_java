/**
 * Created by pengshuang on 17/1/7.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] w = new int[m][n];
        w[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            w[0][i] = w[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            w[i][0] = w[i-1][0]+grid[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                w[i][j] = Math.min(w[i-1][j], w[i][j-1]) + grid[i][j];
            }
        }
        return w[m-1][n-1];
    }
}
