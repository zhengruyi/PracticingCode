package Chapter0_其他.Q36_有效的数独;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:37
 **/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return true;
        }
        //记录横行的元素出现的情况
        int[][] row = new int[9][9];
        //记录数列的元素出现的情况
        int[][] col = new int[9][9];
        //记录所有小九宫格的情况
        int[][] box = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '1';
                if(row[i][num] == 1){
                    return false;
                }
                if(col[j][num] == 1){
                    return false;
                }
                //计算属于哪个九宫格
                int index = (i/3) * 3 + j/3;
                if(box[index][num] == 1){
                    return false;
                }
                //更新对应位置的情况
                row[i][num] = 1;
                col[j][num] = 1;
                box[index][num] = 1;
            }
        }
        return true;
    }
}
