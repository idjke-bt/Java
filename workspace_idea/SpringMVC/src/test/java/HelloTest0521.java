import com.mvc.controller.MyFirstController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2022-05-21 16:57
 */
public class HelloTest0521 {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("dispatcherServlet.xml");

    @Test
    public void test01(){
        MyFirstController bean = ioc.getBean(MyFirstController.class);
        String s = bean.firstRequest();
        System.out.println(s);
    }


    @Test
    public void test02() throws Exception{
        File file = new File("id_k.dat");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String[] split = br.readLine().split("\\s+");
        System.out.println(Arrays.toString(split));
        System.out.println("===================================");
        split = br.readLine().split("\\s+");
        System.out.println(Arrays.toString(split));

        int num = Integer.parseInt(br.readLine().split("\\s+")[1]);
        System.out.println(num);
    }

    @Test
    public void test03(){
        int a=2, b=3;
        double c = (double)a /b;
        System.out.println(c);
    }



}
