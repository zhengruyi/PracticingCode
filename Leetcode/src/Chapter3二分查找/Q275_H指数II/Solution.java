package Chapter3二分查找.Q275_H指数II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/02/2021 17:57
 **/

public class Solution {
    /**
     * 本质就是用二分搜索求满足条件的左边界的数
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if(citations.length == 0){
            return 0;
        }
        int left = 0;
        int right = citations.length;
        int len = citations.length;
        while(left < right){
            int mid = left + (right - left)/2;
            //如果citations[mid] > len - mid，说明至少有 len - mid 篇文章,它的引用次数大于citations[mid]
            //所以收缩右边界,否则收缩左边界
            if(citations[mid] < len -  mid){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        //最后右半部分的个数就是H指数
        return len - left;
    }
}
