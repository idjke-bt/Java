import com.yf.xml.MathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-05-18 10:43
 */
public class AOP0518 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("AOP0518.xml");

    @Test
    public void xmlAOPTest(){
        MathCalculator mathCalculator = ioc.getBean(MathCalculator.class);
        mathCalculator.add(1,2);
        System.out.println("=====================");
        mathCalculator.div(1,0);
    }
}
