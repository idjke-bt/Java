import org.junit.Test;

import java.util.*;

/**
 * @author YangFeng
 * @create 2021-01-19 18:19
 */
public class IteratorTest {

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(22);
        list.add(22);
        list.add(22);
        list.add(25);

        List dest = new ArrayList();

        dest.addAll(list);
        System.out.println(dest);

        Collections.sort(list);
        System.out.println("list:"+list);
        System.out.println(dest);
    }

}

class Student{
    private String name;
    private int id;

    public Student() {
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
