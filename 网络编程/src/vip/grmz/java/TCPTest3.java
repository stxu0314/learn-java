package vip.grmz.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3:客户端发送文件给服务器, 服务器将文件保存在本地,并返回"发送成功"给客户端
 * 并关闭相应的连接
 * @Author STXU
 * @Date 2022/4/16 9:03
 * @Version 1.0
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);

        OutputStream out = socket.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("2022虎运当头新年4k高清壁纸_彼岸图网.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //接收来自于服务端的数据,并显示到控制台
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len1 = is.read(buffer1))!=-1) {
            baos.write(buffer1, 0, len1);
        }
        System.out.println(baos.toString());

        is.close();
        baos.close();
        fis.close();
        out.close();
        socket.close();

    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);

        Socket socket = ss.accept();

        InputStream in = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("myPic2.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer))!=-1) {
            fos.write(buffer, 0, len);
        }
        System.out.println("图片传输完成");

        //服务器端给客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好,已收到".getBytes());

        os.close();
        fos.close();
        in.close();
        socket.close();
        ss.close();
    }
}
