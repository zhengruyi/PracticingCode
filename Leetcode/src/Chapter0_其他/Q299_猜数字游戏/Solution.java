package Chapter0_其他.Q299_猜数字游戏;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 20:35
 **/

public class Solution {
    public String getHint(String secret, String guess) {
        int num = 0;
        HashMap <Character,Integer> s = new HashMap<>();
        HashMap<Character,Integer> g = new HashMap<>();
        //统计secret和guess中字符出现频率，同时统计值和位置都对的数目
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                num++;
            }
            s.put(secret.charAt(i),s.getOrDefault(secret.charAt(i), 0) + 1);
            g.put(guess.charAt(i),g.getOrDefault(guess.charAt(i), 0) + 1);
        }
        int total = 0;
        //统计字符频率的交集，即出现频率中最小的那个，那是总数减去值和位置都相同的就是值相同但位置不同
        for(char c : g.keySet()){
            if(s.containsKey(c)){
                total += Math.min(s.get(c),g.get(c));
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(num).append("A").append(total - num).append("B");
        return builder.toString();
    }
}
