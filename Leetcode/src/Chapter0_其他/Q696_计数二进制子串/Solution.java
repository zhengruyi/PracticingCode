package Chapter0_其他.Q696_计数二进制子串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/02/2021 23:38
 **/

public class Solution {
    /**
     * 本题因为统计相同子串的次数,并且要求子串的0和1出现次数相同且0和1只能靠在一起
     * 所以0011这种情况只会有两者符合要求的情况及01和0011，所以题目而对于00011这种情况
     * 结果任然是01和0011，所以题目转化成把原字符串相邻的字符统计一下比如有u个0和v个1
     * 那么符合要求的子字符串个数是min{u,v}
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        List <Integer> list = new ArrayList <>();
        int times = 0;
        int index = 0;
        int len = s.length();
        //统计相邻的相同字符的个数
        while(index < len){
            char  c = s.charAt(index);
            times = 0;
            while(index < len && s.charAt(index) == c){
                index++;
                times++;
            }
            list.add(times);
        }
        //计算最终的结果
        int sum = 0;
        for(int i = 0; i < list.size() - 1; i++){
            sum += Math.min(list.get(i),list.get(i+1));
        }
        return sum;
    }
}
