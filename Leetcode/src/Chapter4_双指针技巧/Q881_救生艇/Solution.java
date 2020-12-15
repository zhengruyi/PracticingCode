package Chapter4_双指针技巧.Q881_救生艇;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/12/2020 23:27
 **/

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //如果只有一个人，那么只用一艘船
        if(people.length == 1){
            return 1;
        }
        //双指针来计算最少需要多少艘船
        Arrays.sort(people);
        int left = 0;
        int right = people.length -1;
        int nums = 0;
        while(left <= right) {
            //如果两个人的体重小于船的最大载重,那么可以放两个人上去
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                nums++;
                //表示最能一个人上去，则这个人是体重较大的那个，即右边的那个人
            } else {
                right--;
                nums++;
            }
        }
        return nums;
    }
}
