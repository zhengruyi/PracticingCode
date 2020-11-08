package Chapter10_动态规划.Q975_奇偶跳;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 21:34
 **/

public class Solution {
    public int oddEvenJumps(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int len = A.length;
        //这里申明成Integer[]类型的数组，是因为后面需要用Arrays.sort()进行特定的排序
        //如果只是声明成int[]会应发错误
        Integer[] arr = new Integer[len];
        //存储数组下标
        for(int i =0; i < len; i++){
            arr[i] = i;
        }
        //按A[]中下标对应元素的大小，将数组下标排序，按照A[]中元素从小到大排列
        Arrays.sort(arr, (a, b) -> A[a] == A[b] ? a - b : A[a] - A[b]);
        //获取每个元素奇数跳可以跳到的位置
        int[] odd = order(arr);
        //按A[]中下标对应元素的大小，将数组下标排序，按照A[]中元素从大到小排列
        Arrays.sort(arr, (a,b) -> A[a] == A[b] ? a - b : A[b] -A[a]);
        //获取偶数跳能跳到的位置
        int[] even = order(arr);
        int[][] dp =new int[len][2];
        //最后一个数组元素的奇数和偶数跳都能跳到对应位置
        dp[len-1][0] = 1;
        dp[len-1][1] = 1;
        for(int i = len -2; i>= 0; i--){
            //如果奇数跳可以跳到后续位置，且这个后续位置的偶数跳也存在，则当前奇数跳有效
            if(odd[i] != -1 && dp[odd[i]][1] == 1){
                dp[i][0] = 1;
            }
            //如果偶数跳可以跳到后续位置，且这个后续位置的奇数跳也存在，则当前偶数跳有效
            if(even[i] != -1 && dp[even[i]][0] == 1){
                dp[i][1] = 1;
            }
        }
        //统计有多少个索引的奇数跳存在
        int count = 0;
        for(int i = 0; i < len; i++){
            if(dp[i][0] == 1){
                count++;
            }
        }
        return count;
    }
    public int[] order(Integer[] arr){
        //单调栈来求得后续最近一个比自己大的索引
        Deque <Integer> deque = new LinkedList <Integer>();
        deque.addLast(arr[0]);
        int[] res = new int[arr.length];
        Arrays.fill(res,-1);
        for(int i =1; i < arr.length; i++){
            while(!deque.isEmpty() && deque.peekLast() < arr[i]){
                res[deque.pollLast()] = arr[i];
            }
            deque.addLast(arr[i]);
        }
        return res;
    }
}
