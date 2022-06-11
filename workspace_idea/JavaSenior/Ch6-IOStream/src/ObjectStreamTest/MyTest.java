package ObjectStreamTest;

import org.junit.Test;

import java.io.*;

/**
 * ObjectInputStream 和 ObjectOutputStream的基本使用
 *
 * @author YangFeng
 * @create 2021-02-18 19:38
 */
public class MyTest {

    /*
    ObjectOutputStream：序列化
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            //1.造文件 造流
            File file = new File("object.dat");
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.flush();
            //2.操作流
            oos.writeObject(new String("IOStream"));
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
        File file = new File("object.dat");
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Object o = ois.readObject();
            System.out.println(o);
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
