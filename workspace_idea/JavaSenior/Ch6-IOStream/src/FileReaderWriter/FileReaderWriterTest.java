package FileReaderWriter;

import org.junit.Test;

import java.io.*;

/**
 * @author YangFeng
 * @create 2021-02-04 20:10
 */
public class FileReaderWriterTest {

    /*
    例：读入Ch6-IOStream下的hello.txt文件，并输出到控制台
     */
    @Test
    public void fileReaderTest1() {
        FileReader fileReader = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //2.提供具体的流
            fileReader = new FileReader(file);

            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，这则返回-1
            int data = fileReader.read();
            while(data != -1){
                System.out.print((char)data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.文件的关闭
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //对read()操作升级，使用read的重载方法
    @Test
    public void fileReaderTest2(){
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileReader流的实例化
            fileReader = new FileReader(file);

            //3.读入的操作
            char[] cbuf = new char[5];
            int len;
            while((len=fileReader.read(cbuf)) != -1){
    //            for(int i=0; i<len; i++){
    //                System.out.print(cbuf[i]);
    //            }
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /*
    从内存中写出数据到硬盘的文件里
     */
    @Test
    public void fileWriterTest() throws IOException {
        //1.提供File类的对象，指明写出到的文件
        File file = new File("writerFile.txt");

        //2.提供FileWriter的对象，用于数据的写出
        FileWriter fileWriter = new FileWriter(file);

        //3.写出操作
        fileWriter.write("Java");

        //4.流资源的关闭
        fileWriter.close();
    }

    /*
    复制操作：将hello.txt文件的内容复制到writerFile.txt中
     */
    @Test
    public void fileReaderWriterTest(){

        File sourceFile = new File("hello.txt");
        File destFile = new File("writerFile.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(sourceFile);
            fileWriter = new FileWriter(destFile);
            char[] cbuf = new char[5];
            int len;
            while((len=fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader != null){
                    fileReader.close();
                }
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
