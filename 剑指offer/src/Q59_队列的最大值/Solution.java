package Q59_队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:11
 **/

/**
 * 总的来说怎么在保证新的最大值加入进来后，能快速更新整个队列的最大值
 * 以及在最大值移出队列后怎么快速获取下一个的最大值
 *
 * 解决方法就是: 在新加入值时，如果队尾元素小于当前元素时，那么就一直弹出，直到队尾元素大于当前元素后入队
 */
public class Solution {
    Queue <Integer> queue;
    Deque <Integer> max;
    public Solution() {
        queue = new LinkedList <>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if(max.size() == 0){
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        //如果队尾的元素值较小，那么就一直弹出队尾元素直到队尾元素大于当前元素
        //然后入队
        while(!max.isEmpty() && max.peekLast() < value){
            max.pollLast();
        }
        max.offer(value);
    }

    public int pop_front() {
        if(queue.size() == 0){
            return -1;
        }
        int v = queue.poll();
        if(v == max.peekFirst()){
            max.poll();
        }
        return v;
    }
}
