import com.yf.calculator.Calculator;
import com.yf.calculator.MathCalculator;
import com.yf.calculator.MyProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-05-12 21:33
 */
public class AOPTest0512 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("AOP0512.xml");

    @Test
    public void test1(){
        //测试动态代理
//        Calculator cal = new MathCalculator();
//        Calculator proxyInstance = (Calculator) MyProxy.getProxyInstance(cal);
//        int add = proxyInstance.add(1, 2);
//        System.out.println(add);
    }

    @Test
    public void test2(){
        //测试AOP
        //1.从ioc容器中拿到目标对象，注意，使用接口类型获取
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,2);
        System.out.println(bean);//com.yf.calculator.MathCalculator@4f25b795
        System.out.println(bean.getClass());//class com.sun.proxy.$Proxy16
    }

}
