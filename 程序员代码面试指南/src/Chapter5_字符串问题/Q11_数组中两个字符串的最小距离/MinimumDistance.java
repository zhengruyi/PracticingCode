package Chapter5_字符串问题.Q11_数组中两个字符串的最小距离;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/06/2020 13:45
 **/

public class MinimumDistance {
    public int getMinimumDistance(String[] strs, String s1, String s2){
        if (s1 == null || s2 == null){
            return  -1;
        }
        int last1 = -1;
        int last2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].equals(s1)){
                last1 = i;
            }else if(strs[i].equals(s2)){
                last2 = i;
            }
            if(last1 != -1 && last2 != -1){
                distance = Math.min(Math.abs(last1 - last2),distance);
            }
        }
        if(last1 == -1 || last2 == -1){
            return -1;
        }else{
            return distance;
        }
    }
    @Test
    void test(){
        String[] strs1 = {"1","3","3","3","2","3","1"};
        Assertions.assertEquals(2,getMinimumDistance(strs1,"1","2"));
        String[] strs2 = {"CD"};
        Assertions.assertEquals(-1,getMinimumDistance(strs1,"CD","AB"));
    }
}
