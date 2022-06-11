package inclass;

/**
 * 使用同步方法解决Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 *  1.同步方法仍然设计到同步监视器，只是不需要我们显示的声明。
 *  2.非静态的同步方法，同步监视器是：this
 *    静态同步方法，同步监视器是：当前类本身
 *
 * @author YangFeng
 * @create 2020-12-15 11:57
 */
public class WindowTest2 {


}

class Window2 implements Runnable{

    private int tickets = 100;
    private boolean isFlag = true;
    @Override
    public void run() {

        while(isFlag){
            show();
        }
    }

    public synchronized void show(){  //同步监视器默认为this
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当前窗口：" + Thread.currentThread().getName() + ", 剩余票数：" + tickets--);
        } else {
            isFlag = false;
        }
    }
}
