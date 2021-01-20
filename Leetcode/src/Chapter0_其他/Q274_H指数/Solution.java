package Chapter0_其他.Q274_H指数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/01/2021 20:19
 **/

public class Solution {
    /**
     * 采用降序排序后,利用值和下标的比较来快速判断是否满足条件
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if(citations.length == 0){
            return 0;
        }
        //先排序，由于不可以用arrays.sort()来进行降序排序
        //所以这里是升序排序,后面采用逆序遍历
        Arrays.sort(citations);
        int offset = citations.length - 1;
        int index = 0;
        while(index < citations.length){
            //如果citations[i] > i,那么说明至少有i+1个值 >= citations[i]
            if(citations[offset - index] > index){
                index++;
            }else{
                break;
            }
        }
        //第一个不满足条件的下标就是H指数
        return index;
    }
}
