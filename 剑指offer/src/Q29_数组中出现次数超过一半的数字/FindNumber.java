package Q29_数组中出现次数超过一半的数字;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/04/2020 17:08
 **/

public class FindNumber {
    public int find(int[] nums) throws RuntimeException{

        if (nums.length == 0 || nums == null)
            throw new RuntimeException(" error");

        int num = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {

            if (times == 0) {
                num = nums[i];
                times = 1;
            } else if (nums[i] == num)
                times++;
            else {
                times--;

            }
        }
        if(checkMoreThanHalf(nums, num))
            return num;
        else
            throw new RuntimeException("No number is more than half");
    }
    public boolean checkMoreThanHalf(int[] nums, int num){
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == num)
                times++;
        }
        if(times > nums.length / 2)
            return true;
        else
            return false;
    }


    @Test
    void test() {
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 2, 4, 5, 6};
        Assertions.assertEquals(2, find(nums));
        // int[] list = {1, 1, 1, 2, 2, 2};
        // Assertions.assertThrows(Exception.class,()->find(nums));
    }
}
