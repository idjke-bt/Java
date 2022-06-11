package exer;

/**
 * 练习：创建两个分线程，一个线程遍历100以内的偶数，另一个遍历100以内奇数
 *
 * @author YangFeng
 * @create 2020-11-29 16:31
 */
public class ThreadDemo {

    public static void main(String[] args) {
        OddThread t1 = new OddThread();
        EvenThread t2 = new EvenThread();
        t1.start();
        t2.start();
    }
}

class OddThread extends Thread{
    @Override
    public void run() {
        for(int i=1; i<=100; i++)
            if(i%2 != 0)
                System.out.println("Odd: " + i + " !!");
    }
}

class EvenThread extends Thread{
    @Override
    public void run() {
        for(int i=1; i<=100; i++)
            if(i%2 == 0)
                System.out.println("Even: " + i + " @@");
    }
}


