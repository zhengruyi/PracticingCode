import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return;
        }
        int r = (n >> 2 ) - 1;
        int c = (n - 1) >> 2;
        for(int i = 0; i<= r; i++){
            for(int j = 0; j <= c; j++){
                swap(matrix,i,j,j,n-1-i);
                swap(matrix,i,j,n-1-i,n-1-j);
                swap(matrix,i,j,n-1-j,i);
            }
        }
    }
    public static void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2,3},{4,5,6},{7,8,9}};
       rotate(intervals);
    }
}
