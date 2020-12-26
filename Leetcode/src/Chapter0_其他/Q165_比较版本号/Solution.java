package Chapter0_其他.Q165_比较版本号;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 21:39
 **/

public class Solution {
    /**
     * 这里主要考虑一点,由于"."在正则表达式中有特殊意义(表示任意一个字符),，所以当要切割的分解符是'.'
     * 时需要加\\来表示转义
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while(index1 < s1.length || index2 < s2.length){
            int i1 = 0;
            if(index1 < s1.length){
                i1 = Integer.parseInt(s1[index1++]);
            }
            int i2 = 0;
            if(index2 < s2.length){
                i2 = Integer.parseInt(s2[index2++]);
            }
            if(i1 > i2){
                return 1;
            }else if(i1 < i2){
                return -1;
            }
        }
        return 0;
    }
}
