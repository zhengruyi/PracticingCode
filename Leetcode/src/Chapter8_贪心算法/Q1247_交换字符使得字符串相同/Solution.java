package Chapter8_贪心算法.Q1247_交换字符使得字符串相同;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/02/2021 17:36
 **/

public class Solution {
    /**
     * 这里使用贪心算法,如果两个字符串的对应位置字符相等,那么就需要交换,然后s1,s2对应位置的不同字符的
     * 情况时x-y或者y-x,那么就是统计不同的组合数,如果xy和yx的总和是奇数那么就无法操作,返回-1。然后因为x-y,x-y可以通过一次
     * 交换字符就可以让两个字符串相等,所以如果xy和yx都是偶数,那么总的次数是(xy+yx)/2，如果xy和yx都是奇数,那么就可以
     * 各自拿出一个xy和yx用两次交换,其余用偶数进行交换,那么就变成(xy - 1)/2 + (yx - 1)/2 + 2,总的可以变成
     * (xy+1)/2 + (yx + 1) /2
     * @param s1
     * @param s2
     * @return
     */
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                continue;
            }
            if(s1.charAt(i) == 'x'){
                xy++;
            }else{
                yx++;
            }
        }
        return ((xy + yx) & 1) == 1 ? -1 : (xy + 1)/2 + (yx + 1)/2;
    }
}
