package inclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YangFeng
 * @create 2020-12-16 20:00
 */
public class ThreadPool {

    public static void main(String[] args) {

        //1.提供指定线程数量的的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread()); //适合适用于Runnable

        //3.关闭连接池
        service.shutdown();
    }

}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i=1; i<=100; i++){
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() +": "+i);
        }
    }
}
