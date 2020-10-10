package Chapter0_功能验证性代码.Q3_Synchronized实现多线程轮流打印ABC;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/06/2020 21:02
 **/

public class PrintThread extends Thread {
    volatile static int state = 0;
    volatile static int count = 0;
    private int id;
    private static final Object ob = new Object();

    public PrintThread(int id) {
        this.id = id;

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            //确定监控器对象
            synchronized (ob) {
                //一直等到轮到自己时打印出对应的值，算完成一次循环
                while (state % 3 != id) {
                    try {
                        ob.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println((char) ('A' + id));
                //改变全局状态，需要注意state前要加上volatile来进行多线程统一
                state++;
                //唤醒其余线程重新竞争锁，由于每一次至少一个线程可以打印，所以不存在全都沉睡的问题
                ob.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        new PrintThread(0).start();
        new PrintThread(1).start();
        new PrintThread(2).start();
    }
}
