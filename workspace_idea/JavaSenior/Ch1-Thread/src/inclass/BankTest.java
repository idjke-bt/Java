package inclass;

/**
 * 使用同步机制将单例模式改写为线程安全的
 *
 * @author YangFeng
 * @create 2020-12-15 17:57
 */
public class BankTest {
}

class Bank{

    //1.私有化类的构造器
    private Bank(){

    }

    //2.声明当前类的对象
    //4.此对象也必须声明为static的
    private static Bank instance = null;

    //3.声明public、static的返回当前对象的方法
    public static Bank getInstance(){

        //方式一：效率稍差
//        synchronized(Bank.class){
//            if(instance == null)
//                instance = new Bank();
//
//            return instance;
//        }

        //方式二(二重判断)：效率更高
        if(instance == null){
            synchronized(Bank.class) {
                if (instance == null)
                    instance = new Bank();
            }
        }
        return instance;
    }
}
