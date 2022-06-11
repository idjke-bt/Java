package BufferedTest;

import org.junit.Test;

import java.io.*;

/**
 * BufferedInputStream
 * BufferedOutputStream
 *
 * BufferedReader
 * BufferedWriter
 *
 * @author YangFeng
 * @create 2021-02-08 12:57
 */
public class BufferedTest {
    /*
    实现非文本文件的复制
     */

    @Test
    public void test1() {
        //1.造文件
        File srcFile = new File("srcPicture.jpg");
        File destFile = new File("destPicture2.jpg");
        //2.造流
        //2.1造节点流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造处理流(缓冲流)
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.具体细节
            byte[] buffer = new byte[5];
            int len;
            while((len=bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略
//        fis.close();
//        fos.close();

    }
}
