/**
 * Created by pengshuang on 17/1/17.
 * 细节实现题
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i=0;i<length/2;i++){
            for (int j=0;j<(length + 1)/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length -j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }
    }
}
