package Q67_把字符串转化成整数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:16
 **/

public class Solution {
    /**
     * 总的思路就是画出有限状态机然后根据状态机
     * 来将字符串专户成数字，这题有更简单的办法
     * @param str
     * @return
     */
    public int strToInt(String str) {
        Map<Character,Integer>[] maps =new Map[]{
                new HashMap(){{put(' ',0); put('s',1);put('n',2);}},
                new HashMap(){{put('n',2);}},
                new HashMap(){{put('n',2);}}
        };
        long ans = 0;
        char c;
        int index = 0;
        boolean isNegative = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                c = 'n';
            }else if(str.charAt(i) == '-' || str.charAt(i) == '+'){
                c = 's';
            }else if(str.charAt(i) == ' '){
                c = ' ';
            }else{
                c = '?';
            }
            if(!maps[index].containsKey(c)){
                return isNegative ? (int) -ans : (int)ans;
            }else{
                if(index == 0 && c == 's'){
                    isNegative = str.charAt(i) == '-';
                }else if(c == 'n'){
                    ans = ans * 10 + str.charAt(i) - '0';
                    if(!isNegative && ans > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }else if(isNegative && -ans < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
                index = maps[index].get(c);
            }
        }
        return isNegative ? (int) -ans : (int)ans;
    }
}
