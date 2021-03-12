package Chapter0_其他.Q1041_困于环中的机器人;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/03/2021 22:36
 **/

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int dir = 0;
        int num = 4;
        for (int i = 0; i < instructions.length(); i++) {
            //直行时找到对应的方向,计算偏移量
            if (instructions.charAt(i) == 'G') {
                switch (dir) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x++;
                        break;
                }
            }
            //往左转的方向变化
            if (instructions.charAt(i) == 'L') {
                dir = (++dir) % num;
            }
            //往右转的方向变化
            if (instructions.charAt(i) == 'R') {
                dir = (--dir + num) % num;
            }
        }
        //如果一轮结束,回到原点，或者方向不是北方，那就一定被困
        return (x == 0 && y == 0) || dir != 0;
    }
}
