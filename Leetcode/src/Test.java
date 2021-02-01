import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        minKnightMoves(2,1);
    }

    public static void main(String[] args) {
        Integer[] tmp = {1,2,3};
        List<Integer> list = Arrays.asList(tmp);
    }
    int[] dx = {-2,-2,-1,-1,1,1,2,2};
    int[] dy = {1,-1,2,-2,2,-2,1,-1};
    public int minKnightMoves(int x, int y) {
        Set<Point> set = new HashSet();
        Queue<Point> queue = new LinkedList<>();
        int step = 0;
        queue.offer(new Point(0,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            Point p = queue.poll();
            set.add(p);
            int l1 = p.x;
            int l2 = p.y;
            if(l1 == x && l2 == y){
                return step;
            }
            for(int i = 0; i < dx.length; i++){
                Point newPoint = new Point(l1+dx[i],l2+dy[i]);
                if(!set.contains(newPoint)){
                    queue.offer(newPoint);
                }
            }
            step++;
        }
        return step;
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode(){
        return  Integer.hashCode(x) ^ Integer.hashCode(y);
    }
}