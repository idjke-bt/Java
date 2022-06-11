package exer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * @author YangFeng
 * @create 2020-12-15 21:14
 */
public class AccountTest {

    public static void main(String[] args) {
        Account a = new Account();

        Thread account1 = new Thread(a);
        Thread account2 = new Thread(a);

        account1.start();
        account2.start();
    }



}


class Account implements Runnable{

    private double balance = 0;

    @Override
    public void run() {
        for(int i=0; i<3; i++){
            synchronized(Account.class){
                balance += 1000;
                System.out.println(Thread.currentThread().getName()+"存钱成功，账户余额："+balance);

            }
        }
    }
}
