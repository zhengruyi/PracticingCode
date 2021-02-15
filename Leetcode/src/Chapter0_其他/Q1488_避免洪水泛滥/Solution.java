package Chapter0_其他.Q1488_避免洪水泛滥;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/02/2021 22:03
 **/

public class Solution {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] res = new int[len];
        int[] cnt = new int[len];
        int index = 0;
        //统计总共有多少天可以抽水,具体是哪一天
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                cnt[index++] = i;
            }
        }
        int curIndex = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < rains.length; i++){
            //当天下雨
            if(rains[i] != 0){
                res[i] = -1;
                //当天下雨，且有发洪水的危险
                if(map.containsKey(rains[i]) && map.get(rains[i]) < i){
                    //找到上一次这个湖下雨的时间
                    int small = map.get(rains[i]);
                    //查看两次下雨之间是否有晴天可以抽水
                    int j = curIndex;
                    while(j < index){
                        //找到上一次下雨后的第一个晴天
                        if(cnt[j] > small){
                            break;
                        }
                        j++;
                    }
                    //检查晴天是不是在两个雨天之间
                    if(j >= index){
                        return new int[0];
                    }
                    if(cnt[j] > i){
                        return new int[0];
                    }
                    //将晴天的抽取的湖的id赋值
                    res[cnt[j]] = rains[i];
                    cnt[j] = -1;
                    //更新下一次要搜索的位置,因为之前的晴天都用掉了
                    if(j==curIndex){
                        while(curIndex<index&&cnt[curIndex]==-1){
                            curIndex++;
                        }
                    }

                }
                //跟新下雨的位置
                map.put(rains[i],i);
            }
        }
        //将没用的晴天赋值成1
        for(int i = 0; i < index; i++){
            if(cnt[i] != -1){
                res[cnt[i]] = 1;
            }
        }
        return res;
    }
}
