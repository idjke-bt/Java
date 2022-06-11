package FileInputOutputStream;

import org.junit.Test;

import java.io.*;

/**
 * @author YangFeng
 * @create 2021-02-05 16:43
 */
public class InputOutputStreamTest {

    @Test
    public void testFileInputStream1() throws IOException {
        //1.造文件
        File file = new File("hello.txt");

        //2.造流
        FileInputStream fis = new FileInputStream(file);

        //3.读数据
        byte[] buffer = new byte[1];
        int len;
        while((len=fis.read(buffer)) != -1){
            String str = new String(buffer, 0, len);
            System.out.print(str);
        }

        //4.关闭资源
        fis.close();
    }

    /*
    实现对文件的复制操作
     */
    @Test
    public void testFileInputStream2(){

        File srcFile = new File("srcPicture.jpg");
        File destFile = new File("destPicture.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            try {
                while((len=fis.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
