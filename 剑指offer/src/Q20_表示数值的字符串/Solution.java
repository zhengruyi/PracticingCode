package Q20_表示数值的字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/01/2021 18:54
 **/

public class Solution {
    public boolean isNumber(String s) {
        //用哈希表数组来表示自动状态机的状态转换
        //自动状态机的状态转移需要根据有效的实例来判断
        Map[] states = {
                new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',4);}}, //0
                new HashMap(){{put('.',4);put('d',2);}}, //1
                new HashMap(){{put('.',3);put('d',2);put('e',5);put(' ',8);}},//2
                new HashMap(){{put('d',3);put('e',5);put(' ',8);}},//3
                new HashMap(){{put('d',3);}},//4
                new HashMap(){{put('s',6);put('d',7);}},//5
                new HashMap(){{put('d',7);}},//6
                new HashMap(){{put('d',7);put(' ',8);}},//7
                new HashMap(){{put(' ',8);}},//8
        };
        //起始状态
        int p = 0;
        char c;
        //判断字符的类别，并且根据这个来进行状态转移
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                c = 'd';
            }else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                c = 'e';
            }else if(s.charAt(i) =='+' || s.charAt(i) == '-'){
                c = 's';
            }else if(s.charAt(i) == ' ' || s.charAt(i) == '.'){
                c = s.charAt(i);
            } else{
                c = '?';
            }
            //如果字符不在已知类别，则直接返回false
            if(!states[p].containsKey(c)){
                return false;
            }
            //转移到下一个状态
            p = (int)states[p].get(c);
        }
        //如果最后停在有效状态，那么数字有效，否则返回false
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
