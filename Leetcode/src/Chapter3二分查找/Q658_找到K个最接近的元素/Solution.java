package Chapter3二分查找.Q658_找到K个最接近的元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 21:41
 **/

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList <>();
        //取前k个元素
        if(x <= arr[0]){
            enter(arr,0,k,res);
            //取最后的k个元素
        }else if( x >= arr[arr.length - 1]){
            enter(arr,arr.length-k,arr.length,res);
        }else{
            //这里的find方法对于存在的元素返回值为具体的索引
            //而对于不存在的元素。则会返回一个负数索引
            // -index-1指向的元素是数组中第一个大于目标的元素
            int index = Arrays.binarySearch(arr,x);
            if(index < 0){
                index = -index - 1;
            }
            //左边小于x的k个元素
            int left = Math.max(0,index - k);
            //右边大于x的k个元素，因为包含index,所以上界是index + k - 1
            int right = Math.min(arr.length - 1, index + k - 1);
            //缩小区间,由于要求元素从小到达排列，所以在差值相等时优先减少右边的区间
            //这里left,right都是闭区间所以是right - left > k - 1 而且最后调用函数时用了right + 1
            while(right - left > k - 1){
                if((x - arr[left]) > (arr[right] - x)){
                    left++;
                }else{
                    right--;
                }
            }
            enter(arr,left,right+1,res);
        }
        return res;
    }

    /**
     * 把数组的一部分元素赋值到数组中区间范围是[left,right)
     * @param arr
     * @param left
     * @param right
     * @param res
     */
    public void enter(int[] arr, int left, int right, List <Integer> res){
        for(int i = left; i < right; i++){
            res.add(arr[i]);
        }
    }
}
