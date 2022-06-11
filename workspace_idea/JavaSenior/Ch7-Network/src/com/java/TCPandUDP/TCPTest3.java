package com.java.TCPandUDP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**TCP网络编程
 * 例题3：客户端发送信息给服务器，服务器将文件保存在本地
 *       并返回“发送成功”给客户端。
 *       并关闭相应的连接
 * @author YangFeng
 * @create 2021-02-20 17:19
 */
public class TCPTest3 {

    //客户端:文件->内存->Socket
    @Test
    public void client() throws IOException {

        //客户端相关准备
        InetAddress inet = InetAddress.getLocalHost();
        Socket socket = new Socket(inet, 2333);

        //将文件读入内存，再读入Socket
        File file = new File("test.png");
        FileInputStream fis = new FileInputStream(file);
        OutputStream os = socket.getOutputStream();

        int len;
        byte[] buffer = new byte[1024];
        while((len=fis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        //接收来自服务器的消息
        InputStream is = socket.getInputStream();
        int mesLen;
        byte[] mesArr = new byte[1024];
        while((len=is.read(mesArr)) != -1){
            String mes = new String(mesArr, 0, len);
            System.out.println(mes);
        }

        //关闭资源
        is.close();
        os.close();
        fis.close();
        socket.close();

    }

    //服务器:Socket->内存->文件
    @Test
    public void server() throws IOException {

        //服务器相关准备
        ServerSocket ss = new ServerSocket(2333);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();

        //写入文件的准备
        File destFile = new File("destFile2.png");
        FileOutputStream fos = new FileOutputStream(destFile);

        //接收文件
        int len;
        byte[] buffer = new byte[1024];
        while((len=is.read(buffer)) != -1){
            fos.write(buffer);
        }

        //回复消息:内存--->Socket
        OutputStream os = accept.getOutputStream();
        os.write("已收到！".getBytes());

        //关闭资源
        os.close();
        fos.close();
        is.close();
        accept.close();
    }
}
