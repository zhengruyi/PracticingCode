package Chapter0_其他.Q372_超级次方;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/10/2020 17:04
 **/

public class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        if(b.length == 0){
            return 1;
        }
        return superPow(a,b,b.length-1);
    }
    public int superPow(int a, int[] b,int i){
        if(i == -1){
            return 1;
        }
        //将末尾的数字提出来计算后，前i-1位数字加算出来的10次方就是目标值
        int part1 = myPow(a,b[i]);
        int part2 = myPow(superPow(a,b,i-1),10);
        return ((part1%base) *(part2%base))%base;
    }
    public int myPow(int a, int k){
        if(k == 0){
            return 1;
        }
        //计算公式 (a*b) % k = ((a%k)*(b%k))%k
        if(k % 2 == 1){
            return ((a%base) * (myPow(a,k-1)%base))%base;
        }else{
            int sub  = myPow(a,k/2);
            return ((sub%base) * (sub%base))%base;
        }
    }
}
