package exer;

import org.junit.Test;

import java.util.List;

/**
 * @author YangFeng
 * @create 2021-01-31 15:39
 */
public class DAOTest {

    @Test
    public void test(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 1, "tom"));

        List<User> list = userDAO.list();
        System.out.println(list);
    }
}
