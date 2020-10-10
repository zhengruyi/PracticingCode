package Q8_把字符串转化成整数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 15:24
 **/

public class ParseInteger {
    public int parseInt(String s){
        if(s == null || s.length() == 0)
            return 0;
        char[] nums = s.toCharArray();
        int result = 0;
        int times = 1;
        int flag = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] >= '0' && nums[i] <= '9'){
                int number = nums[i] - '0';
                result += number*times;
                times *= 10;
            }else if(nums[i] == '-' || nums[i] == '+'){
                flag = nums[i] == '-' ? -1 : 1;
            }else{
                return  0;
            }
        }
        return result * flag;
    }

    @Test
    void test(){
        Assertions.assertEquals(23,parseInt("23"));
        Assertions.assertEquals(-12,parseInt("-12"));
        Assertions.assertEquals(0,parseInt("-12b34"));
    }
}
