package vip.grmz.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2:客户端发送文件给服务器, 服务器将文件保存在本地
 *
 * @Author STXU
 * @Date 2022/4/16 8:52
 * @Version 1.0
 */
public class TCPTest2 {
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
        fis.close();
        out.close();
        socket.close();

    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);

        Socket socket = ss.accept();

        InputStream in = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("myPic.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer))!=-1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        in.close();
        socket.close();
        ss.close();
    }

}
