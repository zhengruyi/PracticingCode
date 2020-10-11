package Chapter2回溯算法.Q37_数独问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/10/2020 23:21
 **/

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null){
            return;
        }
        backTrack(board, 0,0);
    }
    public boolean backTrack(char[][] board, int row, int column){
        int m = 9; int n =9;
        //到达列的尽头则自动切换到下一行
        if(column == n){
            return backTrack(board,row+1, 0);
        }
        if(row == m){
            return true;
        }
        if(board[row][column] != '.'){
            return backTrack(board,row,column+1);
        }
        for( char ch = '1'; ch <= '9'; ch++){
            if(!check(board,row,column,ch)){
                continue;
            }
            board[row][column] = ch;
            if(backTrack(board,row,column+1)){
                return true;
            }
            board[row][column] = '.';
        }
        return false;
    }

    public boolean check(char[][] board, int row, int column, char num){
        for(int i =0; i < 9; i++){
            if(board[row][i] == num){
                return false;
            }else if(board[i][column] == num){
                return false;
            }else if(board[(row/3)*3 + i/3][(column/3)*3 + i % 3] == num){
                return false;
            }
        }
        return true;
    }
}
