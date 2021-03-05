package Chapter8_贪心算法.Q1717_删除子字符串的最大得分;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:19
 **/

public class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        int a = 0, b = 0;
        for(int i = 0; i < s.length(); i++){
            //因为前面分值较大的ab或者ba已经删掉了，此时剩下的就是较小的那组
            //而个数就是min(a,b)，每组分数值是min(a,b) * min(x,y)
            //处理完后将a,b都设置成0
            if(s.charAt(i) != 'a' && s.charAt(i) != 'b'){
                if(a > 0 && b > 0){
                    res += Math.min(a,b) * Math.min(x,y);
                }
                a = 0;
                b = 0;
            }else{
                //统计a,b的出现次数
                if(s.charAt(i) == 'a'){
                    a ++;
                }else{
                    b++;
                }
                //如果ab分值加大就贪心先吃下这个分数
                if( a > 0 && s.charAt(i) =='b' && x >= y){
                    res += x;
                    a--;
                    b--;
                }
                //如果ba分值较大,那么就贪心吃下这个分数
                if(b > 0 && s.charAt(i) =='a' && x < y){
                    res += y;
                    a--;
                    b--;
                }
            }
        }
        //由于最后可能不存在特殊字符,为了防止漏算,就在处理一下
        if(a > 0 && b > 0){
            res += Math.min(a,b) * Math.min(x,y);
        }
        return res;
    }
}
