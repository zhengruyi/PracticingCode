package Q34_丑数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/04/2020 10:51
 **/

public class UglyNumber {
    public static int[] find(int n){
        if(n < 0)
            throw new RuntimeException();

        int[] result = new int[n];
        result[0] = 1;

        if(n == 1)
            return result;

        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = result[t2] * 2;
            int n3 = result[t3] * 3;
            int n5 = result[t5] * 5;
            int min = Math.min(n5, Math.min(n2, n3));
            result[i] = min;
            t2 = min == n2 ? ++t2 : t2;
            t3 = min == n3 ? ++t3 : t3;
            t5 = min == n5 ? ++t5 : t5;
        }
        return result;
    }


    public static void main(String[] args) {
        int n =10;
        int[] result = find(n);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
