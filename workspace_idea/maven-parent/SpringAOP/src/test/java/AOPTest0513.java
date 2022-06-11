import com.yf.calculator.LogUtils;
import com.yf.calculator.MathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-05-13 13:54
 */
public class AOPTest0513 {
    ApplicationContext ioc  = new ClassPathXmlApplicationContext("AOP0512.xml");

    @Test
    public void test1(){
        //没有接口就是本类类型
        //cglib包会帮我们创建好代理对象
        MathCalculator bean = ioc.getBean(MathCalculator.class);
        bean.add(1,2);
        System.out.println(bean.getClass());
        //class com.yf.calculator.MathCalculator$$EnhancerBySpringCGLIB$$53bfa2cc
    }

    @Test
    public void test2(){
        MathCalculator bean = ioc.getBean(MathCalculator.class);
        bean.add(1,2);
        System.out.println("==============================");
//        bean.div(1,0);
    }
}
