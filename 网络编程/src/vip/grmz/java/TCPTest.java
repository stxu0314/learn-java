package vip.grmz.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1: 客户端发送消息给服务端,服务端将数据显示在控制台上
 *
 * @Author STXU
 * @Date 2022/4/15 21:50
 * @Version 1.0
 */
public class TCPTest {
    /**
     * 客户端
     * @Author STXU
     * @Description //TODO
     * @Date 21:52 2022/4/15
     * @Param
     * @return
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream out = null;
        try {
            //1. 创建Socket对象,指明服务器的ip和端口号
            InetAddress inetAddress = InetAddress.getByName("192.168.13.1");
            socket = new Socket(inetAddress,8899);

            //2. 获取一个输出流,用于输出数据
            out = socket.getOutputStream();
            //3. 写出数据
            out.write("你好,我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {

                try {
                    //4. 资源的关闭
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 服务端
     * @Author STXU
     * @Description //TODO
     * @Date 21:52 2022/4/15
     * @Param
     * @return
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1. 创建服务器端的ServerSocket,指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2. 调用accept()方法,表示接收来自客户端的Socket
            accept = serverSocket.accept();
            //3. 获取输入流
            is = accept.getInputStream();

            //不建议这样写
//        byte[] buffer = new byte[20];
//        int len;
//        while ((len = is.read(buffer)) != -1) {
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }

            //4. 读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
               baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println("收到了来自:"+accept.getInetAddress().getHostAddress()+"的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
