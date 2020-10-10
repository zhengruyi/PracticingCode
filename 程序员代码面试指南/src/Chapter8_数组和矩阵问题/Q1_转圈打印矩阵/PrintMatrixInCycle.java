package Chapter8_数组和矩阵问题.Q1_转圈打印矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/06/2020 16:47
 **/

public class PrintMatrixInCycle {
    public static void print(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return;
        }
        int tR = 0;
        int tC = 0;
        int dR = matrix.length -1;
        int dC = matrix[0].length -1;
        while (tR <= dR && tC <= dC){
            printEdge(matrix,tC++,dC--,tR++,dR--);
        }
    }
    public static void printEdge(int[][] matrix, int tc, int dc ,int tr, int dr){
        //只有一行
        if(tr == dr){
            for (int i = tc; i <= dc; i++) {
                System.out.print(matrix[tr][i]+" ");
            }
        }//只有一列
        else if(tc == dc){
            for (int i = tr; i <= dr; i++) {
                System.out.print(matrix[i][tc]+" ");
            }
        }
        else{
            //代表至少存在两行两列的一个矩阵
            int i = tr;
            int j = tc;
            while (j < dc){
                System.out.print(matrix[i][j++]+" ");
            }
            while (i < dr){
                System.out.print(matrix[i++][j]+" ");
            }
            while (j > tc){
                System.out.print(matrix[i][j--]+" ");
            }
            while (i > tr){
                System.out.print(matrix[i--][j]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(matrix);
        System.out.println();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        print(nums);
        System.out.println();
        int[][] m = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        print(m);
    }
}
