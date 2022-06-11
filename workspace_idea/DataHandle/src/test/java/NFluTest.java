import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2022-05-24 14:13
 */
public class NFluTest {
    NFluctuation nf = new NFluctuation();

    @Test
    public void mainTest() throws Exception{
        String alloy_name = "Cu50Zr50_N10000_";
        String[] file_temp_arr = new String[]{"950K","1000K","1050K","1100K","1150K","1200K","1250K","1300K"};
        String cluster;
        File clu_file = new File(".\\file\\cluster2.txt");
        FileReader fr = new FileReader(clu_file);
        BufferedReader br = new BufferedReader(fr);

        String data,src,dest;
        while ((data=br.readLine()) != null){ //遍历所有团簇
            System.out.println("====="+data+"=====");
            String[] split = data.split("\\s+");
//            cluster = split[0]+"_ "+split[1]+"_"+split[2]+"_ "+split[3]+"_";//0 0 12 0 --有两位数
            cluster = split[0]+"_ "+split[1]+"_ "+split[2]+"_ "+split[3]+"_";//0 2 8 2---全是个位数
            for(int i=0; i< file_temp_arr.length; i++){ //遍历所有温度
                System.out.println(file_temp_arr[i]);
                src = alloy_name+file_temp_arr[i]+" "+cluster+"atom_with_its_k.dat";
                dest = alloy_name+file_temp_arr[i]+" "+cluster+"n_flu.csv";
                nf.nFlu(src,dest);
            }
        }

    }

    @Test
    public void clu_txt_test() throws Exception{
        File clu_file = new File(".\\file\\cluster.txt");
        FileReader fr = new FileReader(clu_file);
        BufferedReader br = new BufferedReader(fr);
        String data = br.readLine();
        String[] split = data.split("\\s+");
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void test01() throws Exception{
        String src = "src.txt";
        String dest = "dest.txt";
        nf.nFlu(src,dest);
    }
}
