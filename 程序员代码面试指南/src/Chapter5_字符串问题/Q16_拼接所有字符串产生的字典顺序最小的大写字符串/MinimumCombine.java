package Chapter5_字符串问题.Q16_拼接所有字符串产生的字典顺序最小的大写字符串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/06/2020 20:12
 **/

public class MinimumCombine {
    public String combine(String[] strs){
        if(strs == null || strs.length == 0){
            return null;
        }
        Arrays.sort(strs,new MyComparator());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            builder.append(strs[i]);
        }
        return builder.toString();
    }

    @Test
    void test(){
        String[] strs = {"abc","de"};
        Assertions.assertEquals("abcde",combine(strs));
        Assertions.assertEquals("bab",combine(new String[]{"b","ba"}));
    }
}
class MyComparator implements Comparator<String>{
    @Override
    public int compare(String a, String b) {
        return (a+b).compareTo(b+a);
    }
}