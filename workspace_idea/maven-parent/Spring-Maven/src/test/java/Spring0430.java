import com.yf.factory.AirPlane;
import com.yf.springDemo.Person;
import com.yf.springDemo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-04-30 14:18
 */
public class Spring0430 {
    @Test
    public void parentTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("demo2.xml");
        Person person04 = ioc.getBean("person04", Person.class);
        System.out.println(person04);

    }

    @Test
    public void scopeTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean0430.xml");
        System.out.println("============================");
        ioc.getBean("user", User.class);
    }

    @Test
    public void factoryTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean0430.xml");
        AirPlane airplane01 = ioc.getBean("airplane01", AirPlane.class);
        System.out.println(airplane01);

        System.out.println("==================");
        AirPlane airplane02 = ioc.getBean("airplane02", AirPlane.class);
        System.out.println(airplane02);

        System.out.println("++++++++++++++++++");
        AirPlane airplane03 = ioc.getBean("airplane03", AirPlane.class);
        System.out.println(airplane03);
    }
}
