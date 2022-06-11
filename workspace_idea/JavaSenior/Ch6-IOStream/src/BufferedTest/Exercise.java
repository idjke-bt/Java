package BufferedTest;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author YangFeng
 * @create 2021-02-15 20:31
 */
public class Exercise {

    /*
    对"srcPicture.jpg"文件进行加密操作
     */

    @Test
    public void test1() throws IOException {
        //作为输入的文件
        File srcFile = new File("srcPicture.jpg");
        //作为输出的文件
        File destFile = new File("secret.jpg");

        //造流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //复制操作
        byte[] buffer = new byte[1024];
        int len;
        while((len=bis.read(buffer)) != -1){
            //对字节数据进行加密
            for(int i=0; i<len; i++){
                buffer[i] = (byte) (buffer[i] ^ 5);
            }

            bos.write(buffer, 0, len);
        }

        //关闭流
        bis.close();
        bos.close();

    }

    /*
       统计"hello.txt"文件中各个字符出现的次数,并输出到文件"count.txt"中
     */
    @Test
    public  void test2() throws IOException{
        File srcFile = new File("hello.txt");
        File destFile = new File("count.txt");

        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(destFile);

        //将统计的结果保存到map中，最后再输出到文件中
        Map<Character, Integer> map = new HashMap<>();

        char[] cbuf = new char[10];
        int len;
        while((len=fr.read(cbuf)) != -1){
           for(char c: cbuf){
               if(!map.containsKey(c)){
                   map.put(c, 1);
               }else{
                   int temp = map.get(c);
                   map.put(c, ++temp);
               }
           }
        }

       //遍历map
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character, Integer> entry : entries){
            switch (entry.getKey()){
                case ' ':
                    fw.write("空格="+entry.getValue());
                    break;
                case '\r':
                    fw.write("回车="+entry.getValue());
                    break;
                case '\n':
                    fw.write("换行="+entry.getValue());
                    break;
                default:
                    fw.write(entry.toString());
                    break;
            }
            fw.write("\n");
        }

        fr.close();
        fw.close();
    }


}
