package Chapter0_其他.Q1419_数青蛙;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/03/2021 22:51
 **/

public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int res  = 0;
        String son = "croak";
        //统计字数的出现次数
        int[] times = new int[son.length()];
        //字符到下标的映射
        HashMap <Character,Integer> map = new HashMap();
        for(int i = 0; i < son.length(); i++){
            map.put(son.charAt(i),i);
        }
        for(int i = 0; i < croakOfFrogs.length(); i++){
            char c = croakOfFrogs.charAt(i);
            int index = map.get(c);
            //检查字符的出现是否按顺序,不是就返回-1
            for(int j = 0; j < index; j++){
                if(times[j] <= times[index]){
                    return -1;
                }
            }
            times[index]++;
            //有一只青蛙唱完了,可以复用
            if(c == 'k'){
                for(int j = 0; j < times.length; j++){
                    times[j]--;
                }
            }
            //统计最少需要的青蛙数目
            res = Math.max(times[index],res);
        }
        //最后检查是否有多余的字符
        for(int i = 0; i < times.length; i++){
            if(times[i] != 0){
                return -1;
            }
        }
        return res;
    }
}
