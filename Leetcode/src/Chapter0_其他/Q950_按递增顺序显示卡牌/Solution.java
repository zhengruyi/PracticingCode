package Chapter0_其他.Q950_按递增顺序显示卡牌;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 22:04
 **/

public class Solution {
    /**
     * 本题比较简单的就是模拟发牌的顺序，将索引装入队列然后模拟翻牌顺序
     * 根据队列中的索引位置一次安排数字
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue <Integer> queue = new LinkedList <>();
        int length = deck.length;
        for(int i = 0; i < length; i++){
            queue.offer(i);
        }
        Arrays.sort(deck);
        int[] res = new int[length];
        for(int num : deck){
            res[queue.poll()] = num;
            if(!queue.isEmpty()){
                queue.add(queue.poll());
            }
        }
        return res;
    }
}
