package inclass;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 --- JDK 5.0新增
 *
 *
 * @author YangFeng
 * @create 2020-12-15 20:22
 */
public class LockTest {

    public static void main(String[] args) {
        WindowA obj = new WindowA();

        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj);
        Thread thread3 = new Thread(obj);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class WindowA implements Runnable{

    private int tickets = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                //2.调用锁定方法lock()
                lock.lock();

                if(tickets > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":售票，票号为："+tickets--);
                }else{
                    break;
                }
            }finally {
                //3.调用解锁方法unlock()
                lock.unlock();
            }

        }
    }
}
