import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengshuang on 17/2/16.
 */
public class PacificAtlanticWaterFlow {
    int dx[] = {0,0,-1,1};
    int dy[] = {1,-1,0,0};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int n = matrix.length;
        if(n == 0)
            return res;
        int m = matrix[0].length;
        boolean p[][] = new boolean[n][m];
        boolean a[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            flow(p, matrix, i, 0, n, m);
            flow(a, matrix, i, m - 1, n, m);
        }

        for (int j = 0; j < m; j++) {
            flow(p, matrix, 0, j, n, m);
            flow(a, matrix, n - 1, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void flow(boolean visited[][], int matrix[][], int x, int y, int n, int m) {
        visited[x][y] = true;
        for(int i = 0;i < 4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                if (visited[nx][ny] == false && matrix[nx][ny] >= matrix[x][y])
                    flow(visited, matrix, nx, ny, n, m);
            }
        }
    }
}
