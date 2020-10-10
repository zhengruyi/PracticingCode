package Chapter5_字符串问题.Q17_找到字符串的最长无重复字符子串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/06/2020 20:42
 **/

public class FindMaxSubstring {
    public int get(String s){
        if(s == null || s.length() == 0){
            return -1;
        }
        HashSet<Character> set = new HashSet <>();
        char[] chas = s.toCharArray();
        int index = 0;
        int res = 0;
        for (int i = 0; i < chas.length; i++) {
            if(set.contains(chas[i])){
                res = Math.max(res,set.size());
                while (set.contains(chas[i])){
                    set.remove(chas[index++]);
                }
                set.add(chas[i]);
            }else{
                set.add(chas[i]);
            }
        }
        res = Math.max(res,set.size());
        return res;
    }
    @Test
    void test(){
        Assertions.assertEquals(4,get("abcd"));
        Assertions.assertEquals(3,get("aabcb"));
        Assertions.assertEquals(6,get("abcdeabdecf"));
    }
}
