package Chapter0_其他.Q137_只出现一次的数字II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 00:03
 **/

public class Solution {
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for(int num : nums){
            //twice会在奇数次遇到时变成0,在偶数次时保存数据
            //而once会在遇到一次时保留数据，其余的次数都会变成0
            once =  ~twice &(once ^ num);
            twice = ~once &(twice ^ num);
        }
        return once;
    }
}
