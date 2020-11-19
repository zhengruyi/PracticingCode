package Chapter10_动态规划.Q1371_每个元音包含偶数次的最长子字符串;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/11/2020 22:58
 **/

public class Solution {
    public int findTheLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chas = s.toCharArray();
        int[] status = new int[1 << 5];
        Arrays.fill(status,-1);
        status[0] = 0;
        int count = 0;
        int res = 0;
        for(int i =0; i < chas.length; i++){
            //这里采用0-31来表示五位数字的奇偶数,由于奇数和奇数的差必定是偶数，而偶数和偶数的差也是偶数
            //索引如果对应的下标里面已经不是初始值，代表现在的索引和数组中的索引中间的字符包含偶数位元音字母
            //由于也是求最长子字符串所以只存最初的赋值，当某个元音字母为偶数时，count或变成上一个原因字母的地址
            //不包括刚刚组成偶数的元音字母，所以这里不需要在将相减的结果加1，初始状态设置为0,是考虑到无元音字母的情况
            //也可以很容易的包括在内
            if(chas[i] == 'a'){
                count ^= (1 << 0);
            }else if(chas[i] == 'e'){
                count ^= (1 << 1);
            }else if(chas[i] == 'i'){
                count ^= (1 << 2);
            }else if(chas[i] == 'o'){
                count ^= (1 << 3);
            }else if(chas[i] == 'u'){
                count ^= (1 << 4);
            }
            if(status[count] >= 0){
                res = Math.max(res, i+1 - status[count]);
            }else{
                status[count] = i+1;
            }
        }
        return res;
    }
}
