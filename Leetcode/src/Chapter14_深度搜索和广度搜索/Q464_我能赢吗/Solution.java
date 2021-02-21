package Chapter14_深度搜索和广度搜索.Q464_我能赢吗;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/02/2021 21:52
 **/

public class Solution {
    //记录是否能赢
    HashMap<String,Boolean> map = new HashMap();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //直接第一次选取最大值,直接获胜
        if(maxChoosableInteger >= desiredTotal){
            return true;
        }
        //数字总和就不能达到目标
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal){
            return false;
        }
        int[] state = new int[maxChoosableInteger + 1];
        return backTrack(maxChoosableInteger, desiredTotal,state);
    }
    public boolean backTrack(int maxChoosableInteger,int desiredTotal, int[] state){
        //记录当前的状态
        String key = Arrays.toString(state);
        //记忆化搜索
        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i = 1; i <=  maxChoosableInteger; i++){
            if(state[i] == 0){
                state[i] = 1;
                //选取数字后是否达到目标,或者选取这个数字后后续能否获胜
                if(desiredTotal - i <= 0 || !backTrack(maxChoosableInteger,desiredTotal - i,state)){
                    //记录结果
                    map.put(key,true);
                    state[i] = 0;
                    return true;
                }
                //回溯状态
                state[i] = 0;
            }
        }
        map.put(key,false);
        return false;
    }
}
