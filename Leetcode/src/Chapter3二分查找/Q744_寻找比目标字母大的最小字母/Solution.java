package Chapter3二分查找.Q744_寻找比目标字母大的最小字母;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/03/2021 23:52
 **/

public class Solution {
    /**
     * 简单的最左边界查找,当left = nums.length表示数组中
     * 不存在比target大的字符,这时返回起始的字符
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(letters[mid] - target <= 0){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left == letters.length ?  letters[0] : letters[left];
    }
}
