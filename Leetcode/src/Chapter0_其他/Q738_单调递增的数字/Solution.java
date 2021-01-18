package Chapter0_其他.Q738_单调递增的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 21:17
 **/

public class Solution {
    /**
     * 这里的注意就是找到第一个str[i] > str[i+1],然后将str[i] - 1后，将后面的全部换成'9'
     * 但是有一个问题就是存在str[i]==str[j],那么改变str[j]-1后就不再是单调递增了
     * 解决办法就是记录严格单调递增的末端，然后将后面的相等序列也全部变成'9'
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] nums = String.valueOf(N).toCharArray();
        int max = -1, idx = -1;
        for(int i = 0; i < nums.length - 1; i++){
            //记录严格单调递增的末端
            if(max < nums[i]){
                max = nums[i];
                idx = i;
            }
            if(nums[i] > nums[i+1]){
                //严格单调递增的末端点减去1，后面全部变成'9'
                nums[idx]--;
                for(int j = idx + 1; j < nums.length; j++){
                    nums[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(nums));
    }
}
