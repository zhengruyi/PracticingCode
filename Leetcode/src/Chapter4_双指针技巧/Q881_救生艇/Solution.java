package Chapter4_双指针技巧.Q881_救生艇;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/12/2020 23:27
 **/

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length == 1){
            return 1;
        }
        Arrays.sort(people);
        int left = 0;
        int right = people.length -1;
        int nums = 0;
        while(left < right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
                nums++;
            }else{
                right--;
                nums++;
            }
        }
        if(left == right){
            nums++;
        }
        return nums;
    }
}
