package Chapter14_深度搜索和广度搜索.Q291_单词规律II;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/02/2021 21:53
 **/

public class Solution {
    HashMap<Character,String> map = new HashMap <>();
    public boolean wordPatternMatch(String pattern, String s) {
        //模式串和字符串都为空，那么就表示匹配成功
        if(pattern.length() == 0){
            return s.length() == 0;
        }
        //pattern里面待匹配的字符
        char letter = pattern.charAt(0);
        //因为i这里是作为截止位置字符且不被包含，所以 i <= s.length() - pattern.length()+1
        for(int i = 1; i <= s.length() - pattern.length()+1; i++){
            String mapStr = map.get(letter);
            //截取子串
            String str  = s.substring(0,i);
            //如果这个字符lettre还没被匹配或者和上一次匹配的结果一样
            if((mapStr != null && str.equals(mapStr))||(mapStr == null && !map.containsValue(str))){
                map.put(letter,str);
                //问题化成pattern 1..len 能否和 s 的 i..n的能否成功匹配
                if(wordPatternMatch(pattern.substring(1),s.substring(i))){
                    return true;
                    //表示lettre和s的0..i匹配失败，所以下一次循环来匹配
                }else if(mapStr == null){
                    map.remove(letter);
                }
            }
        }
        //返回false
        return false;
    }
}
