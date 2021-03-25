package Chapter0_其他.Q541_反转字符串II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/03/2021 23:42
 **/

public class Solution {
    /**
     * 简单的逻辑实现,注意一下分情况处理就可以
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int index = 2 * k;
        for(;index < chars.length; index += 2 * k){
            reverse(chars,index - 2 *k, index - k - 1);
        }
        index -= 2*k;
        if(chars.length - index < k){
            reverse(chars,index, chars.length - 1);
        }else{
            reverse(chars,index,index+k - 1);
        }
        return new String(chars);
    }
    public void reverse(char[] chars, int start, int end){
        while(start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
