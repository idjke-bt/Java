package FileExer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2021-02-02 12:39
 */
public class SomeTests {

    /*
    利用Fie构造器，new一个文件目录file
    1）在其中创建多个文件和目录
    2）编写方法，实现删除fle中指定文件的操作
     */
    @Test
    public void test1() throws IOException {
        File file = new File("E:\\FileTest");
        file.mkdir();

        File file1 = new File("E:\\FileTest\\hello.txt");
        file1.createNewFile();

        File file2 = new File("E:\\FileTest\\hi.jpg");
        file2.createNewFile();

//        if(file1.exists()){
//            file1.delete();
//        }
//
//        file2.delete();
//        System.out.println(file.delete());
        String[] list = file.list();
        System.out.println(Arrays.toString(list));

    }

    /*
    打印指定目录所有文件名称
     */
    @Test
    public void test3(){
        File file = new File("D:\\学习\\文档\\英语");
        if(file.isDirectory()){
            showSubFile(file);
        }
    }

    //输出文件夹file内的所有文件
    public void showSubFile(File file){
        File[] files = file.listFiles();
        for(File tempFile:files){
            if(tempFile.isFile()){
                System.out.println(tempFile);
            }else{
                showSubFile(tempFile);
            }
        }
    }




}
