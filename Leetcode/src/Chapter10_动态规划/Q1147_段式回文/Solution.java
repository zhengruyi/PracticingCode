package Chapter10_动态规划.Q1147_段式回文;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/11/2020 20:20
 **/

public class Solution {
    public int longestDecomposition(String text) {
        int i = 0, i0 = 0;
        int j = text.length()-1, j0 = text.length()-1;
        int ans = 0;
        int tmp = 0;
        while(i < j){
            //找到第一个与j相等的字符，然开始倒退式匹配
            while(i < j){
                if(text.charAt(i++) == text.charAt(j)){
                    break;
                }
            }
            //由于即使text.charAt(i)和text.charAt(j)不相等，任然会i++,所以在
            //开始倒退式匹配前，需要先进行i--运算
            tmp = i--;
            //从i--开始和j指向的位置进行匹配，比如"ghighi"这样，i从2，j从5开始匹配
            //每次成功都各自倒退一格
            while(i >= i0){
                if(text.charAt(i) != text.charAt(j)){
                    break;
                }
                i--;
                j--;
            }
            //如果 i < i0表示从初始的i和j位置匹配成功，所以要更新i0和j0的位置，这里i0和j0表示上一个匹配成功的子串
            //的结束位置
            if(i < i0){
                ans += 2;
                i0 = tmp;
            }else{
                //匹配不成功，那么j恢复到原位置
                j = j0;
            }
            //更新i和j0的位置
            i = tmp;
            j0 = j;
        }
        //如果出现"highi"这种情况，最终i0和j0相等都为2，所以对于奇数的回文字符串要多加1
        return i0 > j0? ans : ans+ 1;
    }
}
