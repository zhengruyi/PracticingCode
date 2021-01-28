package Chapter0_其他.Q777_在LR字符串中交换相邻字符;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 23:03
 **/

public class Solution {
    /**
     * 总的来说是L只能往左移动而R只能往右移动，所以如果目标字符串中的所有L都砸原始字符串L的相同位置
     * 或者更左边，目标字符串的R都在原始字符串的对应位置挥着右边，那么就可以断定原始字符串经过
     * 一定次数的转移后会变成目标字符串
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        //去掉X后,两个字符串需要相等
        if(!start.replace("X","").equals(end.replace("X",""))){
            return false;
        }
        int t = 0;
        //检查字符L的相对关系
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) == 'L'){
                while(end.charAt(t) != 'L'){
                    t++;
                }
                if(i < t){
                    return false;
                }
                t++;
            }
        }
        t = 0;
        //检查字符R的相对关系
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) == 'R'){
                while(end.charAt(t) != 'R'){
                    t++;
                }
                if(i > t){
                    return false;
                }
                t++;
            }
        }
        return true;
    }
}
