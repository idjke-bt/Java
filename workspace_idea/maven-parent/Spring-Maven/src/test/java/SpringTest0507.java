import com.generics.serivce.BookService;
import com.generics.serivce.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-05-07 16:10
 */
public class SpringTest0507 {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("generics0507.xml");

    @Test
    public void test1(){
        BookService bookService = ioc.getBean(BookService.class);
        bookService.save();
        UserService userService = ioc.getBean(UserService.class);
        userService.save();
    }
}
