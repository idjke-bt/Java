package inclass;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *
 * @author YangFeng
 * @create 2020-12-02 20:01
 */
public class ThreadTest1 {

    public static void main(String[] args) {

        //3.创建实现类的对象
        OtherThread test = new OtherThread();

        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(test);

        //5.5.通过Thread类的对象调用start():①启动当前线程；②运行当前线程的run()方法--->调用了Runnable类型的start()
        t1.setName("线程一");
        t1.start();

        //再启动一个线程
        Thread t2 = new Thread(test);
        t2.setName("线程二");
        t2.start();
    }

}


//1.创建一个实现了Runnable接口的类
class OtherThread implements Runnable{
    //2.实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for(int i=0; i<100; i++)
            if(i%2==0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
    }
}


