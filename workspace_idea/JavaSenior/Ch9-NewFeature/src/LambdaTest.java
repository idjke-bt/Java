import org.junit.Test;

import java.util.Comparator;

/**
 * @author YangFeng
 * @create 2022-05-03 14:24
 */
public class LambdaTest {


    @Test
    public void lambda1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello java r1");
            }
        };
        r1.run();

        //使用lambda重写上面的程序
        Runnable r2 = () -> System.out.println("hello java r2");
        r2.run();
    }

    @Test
    public void lambda2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        System.out.println(com1.compare(11,22));

        //lambda表达式写法
        Comparator<Integer> com2 = (o1,o2)->Integer.compare(o1,o2);
        System.out.println(com2.compare(11,21));

        //方法引用写法
        Comparator<Integer> com3 = Integer::compare;

    }

}
