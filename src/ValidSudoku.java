/**
 * Created by pengshuang on 17/1/24.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            boolean[] visited = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }
        for(int i = 0; i < 9; i++){
            boolean[] visited = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }
        for (int i = 0; i < 9; i+=3){
            for (int j = 0; j < 9; j+=3){
                boolean[] visited = new boolean[9];
                for (int k = 0; k < 9; k++){
                    if(!process(visited, board[i+k/3][j+k%3]))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }

        int num = (int)(digit - '0');
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }

        visited[num-1] = true;
        return true;
    }
}
