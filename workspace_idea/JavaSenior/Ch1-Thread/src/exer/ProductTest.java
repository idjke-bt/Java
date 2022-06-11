package exer;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品。
 *
 *
 * 分析：
 * 1.是否是多线程的问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）---->把对象（产品）以及操作对象的方法（生产产品、消费产品）放在同一个类中
 * 3.如何解决线程的安全问题？
 * 4.是否涉及到线程的通信？
 *
 * @author YangFeng
 * @create 2020-12-16 16:01
 */
public class ProductTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer producer1 = new Producer(clerk);
        producer1.setName("生产者1");

        Customer customer1 = new Customer(clerk);
        customer1.setName("消费者1");

        producer1.start();
        customer1.start();

    }
}


class Clerk{

    private static int numOfProduct = 0;

    //生产产品
    public synchronized void produceProduct(){
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(numOfProduct < 20){
            System.out.println("当前生产者："+Thread.currentThread().getName()+",正在生产第"+(++numOfProduct)+"个产品");
            notify();
        }else{
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized  void consumeProduct(){
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(numOfProduct > 0){
            System.out.println("当前消费者："+Thread.currentThread().getName()+",正在消费第"+(numOfProduct--)+"个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}


class Producer extends Thread{ //生产者

    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产.....");
        while(true) {
            clerk.produceProduct();
        }
    }
}


class Customer extends Thread{  //消费者

    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName()+":开始消费.....");
        while(true) {
            clerk.consumeProduct();
        }
    }
}
