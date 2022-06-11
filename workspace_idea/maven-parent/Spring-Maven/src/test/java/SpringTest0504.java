import com.yf.book.BookDAO;
import com.yf.book.BookService;
import com.yf.book.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangFeng
 * @create 2022-05-04 10:22
 */
public class SpringTest0504 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("bean0504.xml");

    @Test
    public void test01(){
        BookDAO bookDAO = ioc.getBean("bookDao", BookDAO.class);
        BookDAO bookDAO2 = ioc.getBean("bookDao", BookDAO.class);
        System.out.println(bookDAO2==bookDAO);//false
    }

    @Test
    public void test02(){
        BookServlet bean = ioc.getBean(BookServlet.class);
        bean.doGet();
    }
}
