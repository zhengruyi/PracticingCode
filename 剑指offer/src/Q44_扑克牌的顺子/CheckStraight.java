package Q44_扑克牌的顺子;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/04/2020 09:44
 **/

public class CheckStraight {
    static final  int LENGTH = 14;
    int[] sort = new int[LENGTH];
    int  zeroTimes;

    public boolean checkStraight(int[] nums){
        if(nums == null || nums.length < 5)
            return false;
        sort(nums);
        int gap = 0;
        for (int i = zeroTimes; i < nums.length - 1; i++) {
            if(nums[i + 1] == nums[i])
                return false;

            gap = nums[i + 1] - nums[i] - 1;
        }
        if(zeroTimes >= gap)
            return true;
        else
            return false;
    }
    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            sort[nums[i]] += 1;
        }
        int j = 0;
        int index = 0;
        zeroTimes = sort[0];
        while(index < sort.length){
            if(sort[index] > 0){
                nums[j] = index;
                sort[index] -= 1;
                j++;
            }else{
                index ++;
            }
        }
    }

    @Test
    void test(){
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(checkStraight(nums));
        nums = new int[]{1, 3, 4, 0, 5};
        Assertions.assertTrue(checkStraight(nums));
        nums = new int[]{1, 4, 5, 0, 0};
        Assertions.assertTrue(checkStraight(nums));
        nums = new int[]{2, 3, 4, 4, 5};
        Assertions.assertFalse(checkStraight(nums));
    }
}
