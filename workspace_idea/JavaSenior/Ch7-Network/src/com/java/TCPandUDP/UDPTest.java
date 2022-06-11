package com.java.TCPandUDP;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**UDP协议的网络编程
 *
 * @author YangFeng
 * @create 2021-02-20 21:22
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "UDP message";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,2333);

        socket.send(packet);

        socket.close();
    }


    //接收端
    @Test
    public void receiver() throws SocketException {

        DatagramSocket socket = new DatagramSocket(2333);

    }

}
