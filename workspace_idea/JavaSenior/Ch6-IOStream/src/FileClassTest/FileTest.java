package FileClassTest;

import org.junit.Test;

import java.io.File;

/**
 * @author YangFeng
 * @create 2021-01-31 21:05
 */
public class FileTest {
    /*
    1.如何创建File类的对象
          public File(String filePath)
          public File(String parentPath, String childPath)
          public File(File parentFile, String childPath)

    2.相对路径：
      绝对路径：
     */
    @Test
    public void test(){
        //构造器1
        File file1 = new File("hello.txt");//相对路径：当前module下的文件(即在Ch6-IOStream文件夹)
        File file1_1 = new File("D:\\myWorkSpace\\workspace_idea\\JavaSenior\\hello.txt");

        System.out.println(file1);

        //构造器2:parent文件目录下的child文件
        File file2 = new File("D:\\myWorkSpace\\workspace_idea", "JavaSenior");
        System.out.println(file2);
    }

    /*
• public String getAbsolutePath()：获取绝对路径
• public String getPath() ：获取路径
• public String getName() ：获取名称
• public String getParent()：获取上层文件目录路径。若无，返回null
• public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
• public long lastModified() ：获取最后一次的修改时间，毫秒值

如下的两个方法适用于文件目录：
• public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test2(){
        File file = new File("D:\\myWorkSpace\\workspace_idea\\JavaSenior\\Ch6-IOStream");
//        System.out.println(file);
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.length());

        String[] list = file.list();
        for(String s:list){
            System.out.println(s);
        }
    }

    /*
 • public boolean renameTo(File dest):把文件重命名为指定的文件路径
注意：file1.renameTo(file2)为例：要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     */
}
