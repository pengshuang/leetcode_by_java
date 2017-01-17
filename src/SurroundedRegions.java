import java.util.LinkedList;

/**
 * Created by pengshuang on 17/1/17.
 * Answer: 从上下左右四个边界找O，然后进行BFS，找到的都是要保留的，最后遍历一次修改字符即可。
 * 特别注意有一个用例 board 是空，所以进行判断否则会导致RE
 */

public class SurroundedRegions {
    class Point{
        int x,y;
        Point(int i,int j){x=i;y=j;}
    }

    public void solve(char[][] board) {
        int m = board.length;
        if(m==0){
            return;
        }
        int n = board[0].length;
        if(n==0){
            return;
        }
        for (int i=0;i<m;i++){
            bfs(board,i,0);
            bfs(board,i,n-1);
        }
        for (int j=0;j<n;j++){
            bfs(board,0,j);
            bfs(board,m-1,j);
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y){
        if(board[x][y] != 'O'){
            return;
        }
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        board[x][y] = 'A';
        while (!queue.isEmpty()){
            Point top = queue.poll();
            int i = top.x;
            int j = top.y;
            addPoint(board,i-1,j,queue);
            addPoint(board,i+1,j,queue);
            addPoint(board,i,j-1,queue);
            addPoint(board,i,j+1,queue);
        }
    }

    private boolean addPoint(char[][] board, int x, int y, LinkedList<Point> queue){
        if(x < 0 || x > board.length-1 || y < 0 || y > board[0].length-1 || board[x][y] != 'O'){
            return false;
        }
        else {
            queue.add(new Point(x, y));
            board[x][y] = 'A';
            return true;
        }
    }
}
