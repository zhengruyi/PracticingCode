package Chapter4_双指针技巧.Q921_使括号有效的最少添加;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:49
 **/

public class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        //需要添加的爱那个框有两种一是结束时左括号有多余
        //另外就是部分右括号多余左括号
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i) == ')'){
                if(left == 0){
                    res++;
                }else{
                    left--;
                }
            }
        }
        return res + left;
    }
}
