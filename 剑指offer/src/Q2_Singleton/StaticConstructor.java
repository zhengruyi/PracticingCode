package Q2_Singleton;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/04/2020 20:28
 **/
// 缺点在于在类加载时候就出初始化，浪费内存空间
public class StaticConstructor {
    private static final StaticConstructor sc = new StaticConstructor();

    private StaticConstructor() {

    }

    public static StaticConstructor getInstance() {
        return sc;
    }

}

class Test{
    public static void main(String[] args) {
        StaticConstructor sc1 = StaticConstructor.getInstance();
        StaticConstructor sc2 = StaticConstructor.getInstance();
        System.out.println(sc1 == sc2);
    }
}