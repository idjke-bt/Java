package inclass;

/**
 * 测试Thread中的常用方法
 *
 * 1. start():启动当前线程；调用当前线程的run()，只有Thread类和他的子类才能调用start()方法
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yield():释放当前cpu的执行权
 * 7. join():在线程a(main)中调用线程b(Thread1)的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
 * 8. stop():已过时。当执行此方法时，强制结束当前线程。
 * 9. sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * 10.isAlive():判断当前线程是否存活
 *
 * 线程的优先级
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5 -->默认优先级
 *
 * 2.如何设置当前线程的优先级
 *      getPriority():获取线程的优先级
 *      setPriority(int p):设置线程的优先级
 *
 * @author YangFeng
 * @create 2020-11-29 16:43
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread2 test = new MyThread2("MyThread-1");
        //test.setName("线程一");
        test.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        for(int i=0; i<100; i++){
            if(i%2==0)
                System.out.println(Thread.currentThread().getName() + ": " + i);

            if(i == 20) {
                try {
                    test.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

class MyThread2 extends Thread {

    public MyThread2(){

    }

    public MyThread2(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}



