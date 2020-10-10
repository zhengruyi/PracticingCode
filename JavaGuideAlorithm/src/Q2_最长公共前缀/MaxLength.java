package Q2_最长公共前缀;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/05/2020 21:37
 **/
/*
时间复杂度: 但是最好的情况下，算法只需要进行 n*minLen 次比较，其中 minLen 是数组中最短字符串的长度。最坏时是S=m∗n 次比较
空间复杂度O(1)：不需要额外的空间

 */
public class MaxLength {
    public String getCommonPrefix(String[] list){
        if(list == null || list.length == 0)
            return null;
        else if(list.length == 1)
            return list[0];
        else{
            String first = list[0];
            int i;
            end:
            for (i = 0; i < first.length(); i++) {
                char c = first.charAt(i);
                for (int j = 1; j < list.length; j++) {
                    if(i == list[j].length() || list[j].charAt(i) != c)
                        break end;
                }
            }
            return first.substring(0,i);
        }
    }

    @Test
    void test(){
        String[] list = {"flower","flow","flight"};
        Assertions.assertEquals("fl",getCommonPrefix(list));
        list = new String[]{"dog","racecar","car"};
        Assertions.assertEquals("",getCommonPrefix(list));
    }
}
