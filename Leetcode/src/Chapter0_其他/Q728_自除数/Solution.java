package Chapter0_其他.Q728_自除数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/02/2021 23:35
 **/

public class Solution {
    /**
     * 对于每个数字进行检查，检查方法就是转化成字符串，然后挨个字符进行检查
     * @param left
     * @param right
     * @return
     */
    public List <Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList();
        for(int i = left; i <= right; i++){
            if(isValid(i)){
                res.add(i);
            }
        }
        return res;
    }
    public boolean isValid(int num){
        String s = String.valueOf(num);
        for(int i = 0; i < s.length(); i++){
            int divide = s.charAt(i) - '0';
            if(divide == 0){
                return false;
            }
            if(num % divide != 0){
                return false;
            }
        }
        return true;
    }
}
