package inclass;

/**
 * 例子：创建三个窗口卖票，总票数为100张
 *
 * 存在线程安全问题，待解决
 * 1.问题：买票过程中出现重票、错票的问题 --->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，
 *            其他线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
 * 4。在Java中，我们通过同步机制，来解决线程的安全问题。
 *
 * 方法一：同步代码块
 *
 * synchronized(同步监视器){//同步监视器就是需要同步线程的公共对象
 *    //需要被同步的代码
 *
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码。 -->不能包含代码多了，也不能包含代码少了。
 *      2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 *      3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *          要求: 多个线程必须要共用同一把锁。
 *
 * 在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 * 在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 *
 * 5.同步的方式，解决了线程的安全问题。--->好处
 *      操作同步代码时，只能有一个线程参与，其余线程等待。相当于是一个单线程的过程，效率低。--->局限性
 *
 * @author YangFeng
 * @create 2020-12-01 22:28
 */


public class WindowTest {

    public static void main(String[] args) {
        Window window = new Window();
        Thread test1 = new Thread(window);
        Thread test2 = new Thread(window);
        Thread test3 = new Thread(window);
        test1.setName("窗口一");
        test2.setName("窗口二");
        test3.setName("窗口三");
        test1.start();
        test2.start();
        test3.start();
    }
}

class Window implements Runnable{

    private int tickets = 100;
    Object obj = new Object();

    @Override
    public void run() {

        while(true) {
            synchronized (obj) {  //可以用synchronized(this) 此时的this:唯一的window1的对象
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("当前窗口：" + Thread.currentThread().getName() + ", 剩余票数：" + tickets--);
                } else {
                    break;
                }

            }
        }

    }
}
