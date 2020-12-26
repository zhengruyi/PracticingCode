package Chapter0_其他.Q870_优势洗牌;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 21:01
 **/

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        //对A和B进行排序，由于后面需要B的原始顺序,所以这里克隆一个B数组
        //并对B数组进行排序
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);
        HashMap<Integer, Deque <Integer>> map = new HashMap <>();
        for(int b : B){
            map.put(b, new LinkedList <>());
        }
        int j = 0;
        LinkedList<Integer> remain = new LinkedList<>();
        for(int a : A){
            /**
             * 核心思想就是贪心算法，对A和B排序后,如果A对应位置不能大于B，那么也不可能大于
             * B的后续位置,所以这里就采用局部贪心算法，如果a > B[j]，那么就保持不动，更新B数组的索引
             * 指向下一个元素,哈希表里对应元素的链表里保存的是大于当前这个元素的所有A的元素
             */
            if(a > sortedB[j]){
                map.get(sortedB[j++]).add(a);
            }else{
                remain.add(a);
            }
        }
        //重构所有结果集
        int[] res = new int[B.length];
        for(int i = 0; i < B.length; i++){
            if(map.get(B[i]).size() > 0){
                res[i] = map.get(B[i]).pop();
            }else{
                res[i] = remain.pop();
            }
        }
        return res;
    }
}
