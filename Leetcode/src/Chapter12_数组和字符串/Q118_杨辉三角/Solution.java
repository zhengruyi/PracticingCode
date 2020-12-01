package Chapter12_数组和字符串.Q118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/12/2020 21:10
 **/

public class Solution {
    public List<List <Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList <List<Integer>>();
        for(int row = 1; row <= numRows; row++){
            List<Integer> nums = new ArrayList<Integer>();
            for(int i = 0; i < row; i++){
                if(i == 0){
                    nums.add(1);
                }else if(i == row -1){
                    nums.add(1);
                }else{
                    nums.add(list.get(row-2).get(i-1) + list.get(row-2).get(i));
                }
            }
            list.add(nums);
        }
        return list;
    }
}
