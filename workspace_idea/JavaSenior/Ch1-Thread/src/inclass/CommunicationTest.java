package inclass;

/**
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器（锁）。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 	1. wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 	2. wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *      否则，会出现IllegalMonitorStateException异常
 *  3. wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 *
 * @author YangFeng
 * @create 2020-12-15 21:33
 */
public class CommunicationTest {

    public static void main(String[] args) {

        Printer p1 = new Printer();
        Printer p2 = new Printer();

        p1.start();
        p2.start();

    }

}



class Printer extends Thread{

    private static int number = 1;

    @Override
    public void run() {

        while(true){
            synchronized (Printer.class){

                Printer.class.notify();

                if(number <= 100){

                    System.out.println("当前线程："+getName()+"，打印数字："+number++);

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        Printer.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }

    }
}