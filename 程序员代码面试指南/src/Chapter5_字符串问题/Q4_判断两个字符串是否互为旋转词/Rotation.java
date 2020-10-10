package Chapter5_字符串问题.Q4_判断两个字符串是否互为旋转词;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/06/2020 11:11
 **/

public class Rotation {
    public boolean isRotation(String origin, String target){
        if(origin == null || target == null || origin.length() != target.length()){
            return  false;
        }
        //判断旋转词可以转换成在两个原字符串合并后的结果串上搜索目标字符串的存在
        // 采用kmp算法，所以时间复杂度是O(N)
        String combine = origin + origin;
        return combine.contains(target) ;
    }

    @Test
    void test(){
        Assertions.assertTrue(isRotation("cdab","abcd"));
        Assertions.assertFalse(isRotation("1ab2","ab12"));
        Assertions.assertTrue(isRotation("2ab1","ab12"));
    }
}
