import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        int index = 0;
        while(index < n){
            int num = pq.poll();
            index++;
            if(index == n - 1){
                return num;
            }
            for(int i = 0; i < primes.length; i++){
                if(!pq.contains(num*primes[i])){
                    pq.offer(num*primes[i]);
                }
            }
        }
        return 0;
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[] num ={2,7,13,19};
        nthSuperUglyNumber(12,num);

    }

    public static void main(String[] args) {
        int i = 5;
        while (i > 0) {
            i -= lowbit(i);
            System.out.println(i);
        }
    }
    public static int lowbit(int x) {
        // 等价：x & (~x +1)
        return x & (-x);
    }

}
