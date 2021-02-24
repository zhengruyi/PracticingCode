package Chapter0_其他.Q266_回文排列;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/02/2021 23:15
 **/

public class Solution {
    /**
     * 查看字符的出现次数，保证所有的字符的出现次数为奇数的总数目不超过 1个，那么就是回文字符串
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashMap <Character,Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int odd = 0;
        for(int v : map.values()){
            if(v % 2 == 0){
                continue;
            }
            odd++;
        }
        return odd <= 1;
    }
}
