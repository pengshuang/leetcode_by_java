/**
 * Created by pengshuang on 17/1/16.
 * answer: 先把第0行和第0列的状态保存下来，再将剩下矩阵的状态映射到第0行和第0列
 * 空间O(1) 时间O(N*N)
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean is_row0 = false;
        boolean is_col0 = false;
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                is_row0 = true;
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                is_col0=true;
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(is_row0){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
        if(is_col0){
            for(int j=0;j<n;j++){
                matrix[0][j] = 0;
            }
        }
    }
}
