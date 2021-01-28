package Q5_观察者模式;

import Q5_观察者模式.Observer.BinaryObserver;
import Q5_观察者模式.Observer.HexaObserver;
import Q5_观察者模式.Observer.OctalObserver;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 00:03
 **/

/**
 * 意图：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 *
 * 主要解决：一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。
 *
 * 何时使用：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
 *
 * 如何解决：使用面向对象技术，可以将这种依赖关系弱化。
 *
 * 关键代码：在抽象类里有一个 ArrayList 存放观察者们。
 *
 * 优点： 1、观察者和被观察者是抽象耦合的。 2、建立一套触发机制。
 *
 * 缺点： 1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
 * 2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
 * 3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
