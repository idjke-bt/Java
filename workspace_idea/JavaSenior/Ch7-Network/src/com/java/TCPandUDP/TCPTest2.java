package com.java.TCPandUDP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**TCP网络编程
 * 例题2：客户端发送信息给服务器，服务器将文件保存在本地
 *
 * @author YangFeng
 * @create 2021-02-20 16:48
 */
public class TCPTest2 {

    //客户端:文件->内存->Socket
    @Test
    public void client(){
        FileInputStream fis = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.将文件输入到内存中
            File file = new File("test.png");
            fis = new FileInputStream(file);

            //2.创建Socket的对象
            InetAddress inet = InetAddress.getLocalHost();
            socket = new Socket(inet, 2333);

            os = socket.getOutputStream();

            //3.具体操作
            int len;
            byte[] buffer = new byte[1024];
            while((len=fis.read(buffer)) != -1){
                os.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (os != null) {
                    os.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    //服务器:Socket->内存->文件
    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(2333);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();

        File destFile = new File("destFile.png");
        FileOutputStream fos = new FileOutputStream(destFile);

        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }

        fos.close();
        is.close();
        accept.close();
    }
}
