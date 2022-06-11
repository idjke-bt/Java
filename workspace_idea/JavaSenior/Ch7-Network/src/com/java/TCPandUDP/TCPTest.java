package com.java.TCPandUDP;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**实现TCP网络编程
 * 例1：客户端发送信息给服务端，服务都将数据显示在控制台上
 *
 * @author YangFeng
 * @create 2021-02-19 18:17
 */
public class TCPTest {

    /**
     * 注意都要用try-catch-final来处理异常
     * @throws IOException
     */

    //客户端
    @Test
    public void client() throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        //1.创建Socket对象，指明服务器的ip和端口号
        Socket socket = new Socket(inetAddress.getHostAddress(), 6524);

        //2.获取一个输出流，用于输出数据
        OutputStream ops = socket.getOutputStream();

        //3.写出数据操作
        ops.write("Hello ,this is a client！".getBytes());
        ops.write("\n原神辣鸡".getBytes());

        //4.资源关闭
        ops.close();
        socket.close();

    }

    //服务端
    @Test
    public void server() throws IOException {

        //1.创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(6524);

        //2.调用accept()表示接收来自于客户端的socket
        Socket accept = ss.accept();

        //3.获取输入流
        InputStream is = accept.getInputStream();

        //4.读取输入流中的数据
        //方式一
//        int len;
//        byte[] buffer = new byte[1024];
//        while((len=is.read(buffer)) != -1){
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }

        //方式二: 将字节保存到baos中，最后再输出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer)) != -1){
            baos.write(buffer, 0, len);
        }
        System.out.println(baos);

        //5.资源的关闭
        is.close();
        accept.close();

    }

}
