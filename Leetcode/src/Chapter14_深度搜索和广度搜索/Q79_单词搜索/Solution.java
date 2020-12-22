package Chapter14_深度搜索和广度搜索.Q79_单词搜索;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:45
 **/

public class Solution {
    //四个方向的偏移量
    int[] dx = {0,0,1,-1};
    int[] dy = {-1,1,0,0};
    char[][] board;
    String word;
    //标记是否访问过
    boolean[][] mark;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        mark = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //从所有地方尝试遍历
                if(searchWord(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean searchWord(int x, int y,int index){
        //防止出现一个字符的情况
        if(index == word.length() - 1){
            return board[x][y] == word.charAt(index);
        }
        //如果当前字符等于字符串对应位置的字符则开始向四个方向搜索
        if(board[x][y] == word.charAt(index)){
            //将当前标志标记为已访问
            mark[x][y] = true;
            for(int i = 0; i < dx.length; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(inArea(newX,newY)&& !mark[newX][newY]){
                    //向四个方向开始搜索
                    if(searchWord(newX,newY,index+1)){
                        return true;
                    }
                }
            }
            //复位当前位置标记
            mark[x][y] = false;
        }
        return false;
    }
    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
