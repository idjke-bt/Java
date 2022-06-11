package inclass;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。--->JDK5.0新增
 *
 *
 * @author YangFeng
 * @create 2020-12-16 19:19
 */
public class ThreadNew {

    public static void main(String[] args) {

        //3.创建Callable接口实现类的对象
        NumThread callableTest = new NumThread();

        //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中,创建FutureTask的对象
        FutureTask ft = new FutureTask(callableTest);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器,创建Thread对象，并调用start()
        Thread thread = new Thread(ft);
        thread.start();

        try {
            //6.获取Callable中call方法的返回值,get()方法会抛出异常
            Object sum = ft.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}

//1.创建一个实现Callable的实现类
class NumThread implements Callable {

    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i=1; i<=100; i++){
            if(i % 2 == 0)
                System.out.println(i);

            sum += i;
        }
        return sum;
    }
}
