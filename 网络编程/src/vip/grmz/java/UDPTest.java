package vip.grmz.java;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 *
 * @Author STXU
 * @Date 2022/4/16 9:34
 * @Version 1.0
 */
public class UDPTest {
    /**
     * 发送端
     * @Author STXU
     * @Description //TODO
     * @Date 9:35 2022/4/16
     * @Param
     * @return
     */
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发射的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }
    /**
     * 接收端
     * @Author STXU
     * @Description //TODO
     * @Date 9:36 2022/4/16
     * @Param
     * @return
     */
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
