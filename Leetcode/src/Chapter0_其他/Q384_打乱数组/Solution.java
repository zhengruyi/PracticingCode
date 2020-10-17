package Chapter0_其他.Q384_打乱数组;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/10/2020 17:02
 **/

public class Solution {
    int[] origin;
    int[] run;
    Random rand;
    public Solution(int[] nums) {
        origin = nums;
        run = Arrays.copyOf(origin,origin.length);
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        run = Arrays.copyOf(origin,origin.length);
        return run;
    }

    /**
     * 洗牌算法要求出现所有排列的概率都相等，所以共有n!种算法,
     * 该算法总共可能有的拍列是n-1*n-2*n-3 ... 1 = n!中可能性
     * Returns a random shuffling of the array.
     * */
    public int[] shuffle() {
        for(int i = 0; i < run.length; i++){
            int j = rand.nextInt(run.length - i)+i;
            swap(run,i,j);
        }
        return run;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
