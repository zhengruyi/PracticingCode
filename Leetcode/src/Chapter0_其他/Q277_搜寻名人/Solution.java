package Chapter0_其他.Q277_搜寻名人;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/02/2021 22:58
 **/

public class Solution {
    /**
     * 这里利用名人的特性，即所偶遇人都认识它，而他不认识任何人
     * 先循环来找出没有人认识的人，然后再检查是不是他不认识任何一个人
     * 且所偶遇的人都认识他
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int res = 0;
        for(int i = 1; i < n; i++){
            if(knows(res,i)){
                res = i;
            }
        }
        for(int i = 0; i < n; i++){
            if(i == res){
                continue;
            }
            if(knows(res,i) || !knows(i,res)){
                return -1;
            }
        }
        return res;
    }
    public boolean knows(int a, int b){
        return true;
    }
}

