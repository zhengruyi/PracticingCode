package Chapter6_位运算.Q289_生命游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/12/2020 23:03
 **/

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        //八个方向上相对于当前点的偏移量
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        //行数
        int m = board.length;
        //列数
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                //统计八个方向上的存活细胞数目
                for(int k = 0; k < dx.length; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                        sum += (board[nx][ny] & 1 );
                    }
                }
                //如果当前是存活细胞，且八个方向上相邻的活细胞数目刚好是2或者3
                //那么这个细胞在下一轮任然存活，所以在在第二个bit上置成1
                if(board[i][j] == 1){
                    if(sum == 2 || sum == 3){
                        board[i][j] |= 2;
                    }
                }
                //如果当前是死细胞，那么下回合将存活，所以将第二个bit设置成1
                else{
                    if(sum == 3){
                        board[i][j] |= 2;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //将所有元素右移一位，所有第二位没有被设置成1的数都会变成0
                board[i][j] >>= 1;
            }
        }
    }
}
