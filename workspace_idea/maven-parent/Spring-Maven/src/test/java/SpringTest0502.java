import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author YangFeng
 * @create 2022-05-02 15:22
 */
public class SpringTest0502 {

    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("bean0502.xml");

    @Test
    public void poolTest() throws SQLException {
        //1.从容器中拿到连接池
//        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        /**只有一个连接池，也可以用下面的方式**/
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
