package Chapter15_面试题.Q1003_搜索旋转数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:48
 **/

public class Solution {
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            //由于存在左边界,所以只要左边界的元素使我们要的元素，那么直接返回
            if(arr[left] == target){
                return left;
            }
            int mid = left + (right - left) /2;
            //收缩右边界
            if(arr[mid] == target){
                right = mid;
                //mid在上升序列中
            }else if(arr[left] < arr[mid]){
                //排除右边的元素
                if(arr[left] <= target && target <= arr[mid]){
                    right = mid;
                }else{
                    //排除左边的元素
                    left = mid + 1;
                }
                //mid 在右边的序列中
            }else if(arr[mid] < arr[left]){
                if(arr[mid] <= target && target <= arr[right]){
                    //排除左边元素
                    left = mid;
                }else{
                    right = mid -1;
                }
            }else{
                //相同，无法判断只能缩小一格范围
                left++;
            }
        }
        return -1;
    }
}
