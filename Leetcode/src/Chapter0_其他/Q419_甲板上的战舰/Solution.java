package Chapter0_其他.Q419_甲板上的战舰;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 18:23
 **/

public class Solution {
    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //战舰的上头和右边都没有连续的x，说明当前是一艘新的战舰的战舰头，所以加1
                if(board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == board[0].length - 1
                        || board[i][j+1] == '.')){
                    ++count;
                }
            }
        }
        return count;
    }
}
