package Chapter14_深度搜索和广度搜索.Q529_扫雷游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/01/2021 22:55
 **/

public class Solution {
    //八个方向的偏移量
    int[] dx = {0,0,1,-1,-1,-1,1,1};
    int[] dy = {1,-1,0,0, -1,1,-1,1};
    int m;
    int n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        //点击点的横纵坐标
        int l1 = click[0];
        int l2 = click[1];
        //点击的位置时地雷，那么把地雷标记成引爆返回
        if(board[l1][l2] == 'M'){
            board[l1][l2] = 'X';
            return board;
        }else{
            //深度遍历更新矩阵
            dfs(board,l1, l2);
        }
        return board;
    }
    public void dfs(char[][] board, int l1, int l2){
        int cnt = 0;
        for(int i = 0; i < dx.length; i++){
            int x = l1 + dx[i];
            int y = l2 + dy[i];
            //统计这个方块周围的地雷数目
            if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M'){
                cnt++;
            }
        }
        //如果周围有地雷，那么搜索到这个位置就结束了
        if(cnt > 0){
            board[l1][l2] = (char)(cnt + '0');
            return;
        }
        //如果周围没有地雷,那么标记成空白块,递归下一个节点
        board[l1][l2] = 'B';
        for(int i = 0; i < dx.length; i++){
            int x = l1 + dx[i];
            int y = l2 + dy[i];
            if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'E'){
                dfs(board,x,y);
            }
        }
    }
}
