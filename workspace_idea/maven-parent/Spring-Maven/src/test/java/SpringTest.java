import com.yf.springDemo.Book;
import com.yf.springDemo.Person;
import com.yf.springDemo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @author YangFeng
 * @create 2022-04-15 12:21
 */
public class SpringTest {

    @Test
    public void test(){
        //加载spring配置文件
        ApplicationContext context =new ClassPathXmlApplicationContext("bean1.xml");

        //获取配置创建的对象
        User user=context.getBean("user",User.class);

    }

    @Test
    public void personTest(){
        // ApplicationContext：代表IOC容器
        //ClassPathXmlApplicationContext：当前xml配置文件在ClassPath下
        ApplicationContext ioc = new ClassPathXmlApplicationContext("demo2.xml");
        System.out.println("---------------------");
        Person person1 = ioc.getBean("person01", Person.class);
        System.out.println(person1.getUser().getTimes());
    }

    @Test
    public void test0429(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("demo2.xml");
        System.out.println("--------------1-------------------");
        Person person01 = ioc.getBean("person01", Person.class);
//        List<Book> books = person01.getBooks();
//        for(Book book:books){
//            System.out.println(book);
//        }

        Map<String, Object> map = person01.getMap();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey()+"------"+next.getValue());
        }

        System.out.println("======================================");
        Properties pros = person01.getPros();
        System.out.println(pros);
        Set<Map.Entry<Object, Object>> entries = pros.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Map.Entry<Object, Object> next = iterator1.next();
            System.out.println(next.getKey()+"=============="+next.getValue());
        }


    }

    @Test
    public void test0430(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("demo2.xml");
        Person person02 = ioc.getBean("person02", Person.class);
        User user = person02.getUser();
        System.out.println(user.getTimes());
    }
}
