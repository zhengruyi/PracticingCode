package Chapter12_数组和字符串.Q119_杨辉三角II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/12/2020 21:11
 **/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List <Integer> list = new ArrayList <Integer>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
        //所以在压缩状态时，需要反向遍历
        for(int i = 1; i < rowIndex; i++){
            for(int j = i; j >= 1; j--){
                if(j == i){
                    list.add(list.get(j-1)+1);
                }else{
                    list.set(j,list.get(j)+list.get(j-1));
                }
            }
        }
        list.add(1);
        return list;
    }
}
