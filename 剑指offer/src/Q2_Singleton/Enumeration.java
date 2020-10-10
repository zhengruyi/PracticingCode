package Q2_Singleton;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/04/2020 21:02
 **/
//最安全的单例模式，可以在反射修改和反序列化的情况下仍能保持单例模式。
public class Enumeration {
    private Enumeration() {

    }

    private enum SingletonHolder {
        INSTANCE;
        private final Enumeration instance;

        SingletonHolder() {
            instance = new Enumeration();
        }

        private Enumeration getInstance() {
            return this.instance;
        }
    }

    private static Enumeration getInstance() {
        return SingletonHolder.INSTANCE.getInstance();
    }
}
