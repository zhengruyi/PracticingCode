package Q50_数组中出现次数超过一半的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/12/2020 22:36
 **/

public class Solution {
    /**
     * 摩尔投票，假设第一个元素就是众数，以后遇到相同的数字就加1，
     * 不相同的就减去1，当投票数等于0时就更换众数，因为如果第一个数字
     * 就是众数那么剩余的数字中，众数的个数仍然较多，如果第一个数不是众数
     * 那么后半段是数字更多
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int votes = 0;
        int num = 0;
        for(int i : nums){
            if(votes == 0){
                num = i;
                votes++;
            }else{
                votes = num == i ? votes+1 : votes-1;
            }
        }
        return num;
    }
}
