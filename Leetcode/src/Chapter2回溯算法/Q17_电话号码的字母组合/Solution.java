package Chapter2回溯算法.Q17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/12/2020 23:51
 **/

public class Solution {
    public List <String> letterCombinations(String digits) {
        List<String> list = new ArrayList <String>();
        if(digits.length() == 0){
            return list;
        }
        Map <Character,String[]> map = new HashMap <>();
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});
        recursive(digits.toCharArray(),list,0,new StringBuilder(),map);
        return list;
    }
    public void recursive(char[] digits, List<String> list, int index,StringBuilder builder, Map<Character,String[]> map){
        if(index == digits.length){
            list.add(builder.toString());
            return;
        }
        String[] strs = map.get(digits[index]);
        for(int i = 0; i < strs.length; i++){
            //添加当前按键对应的值
            builder.append(strs[i]);
            recursive(digits,list,index+1,builder, map);
            //删除刚刚添加的值
            builder.deleteCharAt(builder.length() -1);
        }
    }
}
