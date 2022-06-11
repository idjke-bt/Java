package ObjectStreamTest;

import org.junit.Test;

import java.io.*;

/**
 * 实现自定义类(Person类)的序列化与反序列化
 * Person类可序列化的要求：
 * 1.实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 *
 * @author YangFeng
 * @create 2021-02-18 20:04
 */
class Person implements Serializable{

    private static final long serialVersionUID = -6849797754667710L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}

public class MyHardTest {

    /*
    ObjectOutputStream：序列化
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            //1.造文件 造流
            File file = new File("Person.dat");
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            //2.操作流
            oos.writeObject(new String("IOStream"));
            oos.writeObject(new Person("安琪", 12));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /*
    反序列化：ObjectInputStream 将磁盘文件中的对象还原为内存中的一个java对象
     */
    @Test
    public void test2(){
        File file = new File("Person.dat");
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Object o1 = ois.readObject();
            System.out.println(o1);

            Object o2 = ois.readObject();
            System.out.println(o2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
