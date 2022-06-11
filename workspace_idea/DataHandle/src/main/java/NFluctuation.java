import java.io.*;

/**
 * @author YangFeng
 * @create 2022-05-24 14:06
 */
public class NFluctuation {

    public void nFlu(String src, String dest) throws IOException {//图方便直接throws了
        //1.将file实例化
        File srcFile = new File(".\\file\\"+src);
        File destFile = new File(".\\file\\dest\\"+dest);

        //2.造流
        FileReader fr = new FileReader(srcFile);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter(destFile);
        BufferedWriter bw = new BufferedWriter(fw);

        int nCof = 500;  //总配置数
        int[][] arr = new int[nCof][10];  //arr[i][j]:第i+1个配置，度为j的原子数

        //3.读与写
        String data;
        for(int conf=0; conf<nCof; conf++){
            int num = Integer.parseInt(br.readLine().split("\\s+")[1]);  //该配置共有num个原子
            for(int j=0; j<num; j++){
                if((data=br.readLine()) != null){
                    int degree = Integer.parseInt(data.split("\\s+")[2]);
                    arr[conf][degree]++;
                }
            }
        }

        //对arr数组逐列求和
        for(int i=0;i<10;i++){
            int sum=0;
            int sum2=0;
            for(int j=0; j<nCof; j++){
                sum += arr[j][i];
                sum2 += Math.pow(arr[j][i],2);
            }
            double avg_Nk2 = (double)sum2/nCof;
            double avg_Nk_2 = Math.pow((double)sum/nCof,2);
            String s = i+", "+avg_Nk2+", "+avg_Nk_2+", "+(avg_Nk2-avg_Nk_2)+"\n";
            bw.write(s);
        }

        //4.关闭流
        bw.close();
        br.close();
    }
}
