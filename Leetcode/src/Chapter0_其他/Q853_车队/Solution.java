package Chapter0_其他.Q853_车队;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/02/2021 18:08
 **/

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        //构造车对象,分别传入车的位置和到达终点的时间
        for(int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i],(target - position[i])/(speed[i] * 1.0));
        }
        //按照起始位置从小到大排序
        Arrays.sort(cars,(a, b) -> a.position - b.position);
        int ans = 0;
        int t = N;
        //这里t = t-1,然后在判断t是否大于0
        while(--t > 0){
            //由于t-1的起始点更远,如果再花费更多的时间,那么一定不可能追上当前车
            //所以t必定是一个独立的车队
            if(cars[t].time < cars[t-1].time){
                ans++;
            }else{
                //t - 1会追上t,然后以共同速度驶向终点
                cars[t-1] = cars[t];
            }
        }
        //最后末尾要再加上1,防止结尾的情况被忽略
        return ans +(t == 0 ? 1 : 0);
    }
}
class Car{
    int position;
    double time;
    public Car(int position, double time){
        this.position = position;
        this.time = time;
    }
}