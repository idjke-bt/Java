package inclass;

/**
 * @author YangFeng
 * @create 2020-11-29 16:01
 *
 * 多线程创建，方式一：继承Thread类的方式
 *
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象
 * 4.通过此对象调用start()：①启动当前线程 ② 调用当前线程的run()
 *
 * <p>例子：遍历100以内的偶数</p>
 */

public class ThreadTest {
    public static void main(String[] args) {
        //3.新建Thread对象
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();

        //4.调用start方法：①启动当前线程， ②调用当前线程的run()
        myThread.start();
        myThread1.start();

//        //如下操作仍然是在main线程中执行
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                System.out.println(Thread.currentThread().getName()+":  "+i+ "******main*******");
//            }
//        }
    }
}


//1.继承Thread类
class MyThread extends Thread {
    public MyThread() {
    }
    //2.重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":  " + i);
            }
        }
    }
}



