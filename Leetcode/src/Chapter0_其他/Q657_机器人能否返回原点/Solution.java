package Chapter0_其他.Q657_机器人能否返回原点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/03/2021 23:04
 **/

public class Solution {
    /**
     * 直接统计是否纵向和横向上的偏移量相互抵消,相互抵消就是回到原点
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizon = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'U'){
                vertical++;
            }else if(moves.charAt(i) == 'D'){
                vertical--;
            }else if(moves.charAt(i) == 'L'){
                horizon--;
            }else if(moves.charAt(i) == 'R'){
                horizon++;
            }
        }
        return vertical == 0 && horizon == 0;
    }
}
