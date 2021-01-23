package Chapter15_面试题.Q1604_井字游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:07
 **/

public class Solution {
    public String tictactoe(String[] board) {
        //分别表示横坐标和纵坐标以及左对角线和右对角线上的x和o的数目
        int horizon = 0;
        int vertical = 0;
        int left = 0;
        int right = 0;
        boolean hasEmpty = false;
        int length = board.length;
        for(int i = 0; i < board.length; i++){
            //统计每行和每列的x或者o的数目
            horizon = 0;
            vertical = 0;
            //统计i行和第i列的棋子数目
            for(int j = 0; j < board[i].length(); j++){
                horizon += (int)board[i].charAt(j);
                vertical += (int) board[j].charAt(i);
                //检测棋盘上是否还有空位
                if(board[i].charAt(j) == ' '){
                    hasEmpty = true;
                }
            }
            //检查是否有棋子填满行或者列
            if(horizon == (int)'X' * length || vertical == (int)'X' *length){
                return "X";
            }
            if(horizon == (int)'O' * length || vertical == (int)'O' * length){
                return "O";
            }
            //没计算一行和一列后，也要更新对角线上的棋子数目
            left += (int)board[i].charAt(i);
            right += (int) board[i].charAt(length - 1 - i);
        }
        //计算对角线上的数目是否满足
        if(left == (int)'X' * length || right == (int)'X' * length){
            return "X";
        }
        if(left == (int)'O' * length || right == (int)'O' * length){
            return "O";
        }
        //返回结果
        if(hasEmpty){
            return "Pending";
        }
        return "Draw";
    }
}
