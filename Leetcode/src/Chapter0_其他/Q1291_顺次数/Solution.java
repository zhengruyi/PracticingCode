package Chapter0_其他.Q1291_顺次数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/03/2021 22:48
 **/

public class Solution {
    public List <Integer> sequentialDigits(int low, int high) {
        //滑动窗口从左往右运动,所有被框住的数字都是符合要求的数字
        String s = "123456789";
        //最低和最高数字的长度
        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();
        List<Integer> res = new ArrayList();
        while(min <= max){
            for(int i = 0; i + min <= s.length(); i++){
                //将字符串转化成数字
                int num = Integer.parseInt(s.substring(i,i+min));
                //小于最小值跳过，大于最大值则循环结束
                if(num <low){
                    continue;
                }else if(num > high){
                    break;
                }
                res.add(num);
            }
            //当前窗口长度的所有数字都已经找到了，那么就将窗口长度加1
            min++;
        }
        return res;
    }
}
