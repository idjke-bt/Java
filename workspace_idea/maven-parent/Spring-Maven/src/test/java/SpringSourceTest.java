import com.yf.springDemo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-05-20 14:55
 */
public class SpringSourceTest {

    @Test
    public void test1(){
        //1.ioc容器的创建
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean1.xml");
        //
        Person person1 = ioc.getBean("person1", Person.class);
        System.out.println(person1);
    }

}
