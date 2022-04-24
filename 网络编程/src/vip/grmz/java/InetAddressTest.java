package vip.grmz.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一. 网络编程中有两个主要的问题
 * 1.如何准确地定位到一台或多台主机,定位主机上的特定的应用
 * 2. 找到主机后如何可靠高效地进行数据传输
 *
 * 二. 网络编程中的两个要素:
 * 1. 对应问题一: IP和端口号
 * 2. 对应问题二: 提供网络通信协议:TCP/IN参考模型(应用层,传输层,网络层,物理+数据链路层)
 *
 *三. 通信要素一: IP和端口号
 *
 * 1.IP:唯一的标识Internet 上的计算机(通信实体)
 * 2. 在java中使用InetAddress类代表IP
 * 3. IP分类:IPv4和IPv6 ;万维网 和 局域网
 * 4. 域名: www.baidu.com
 * 5. 本地回路地址: 127.0.0.1对应 localhost
 * 6. 如何实例化InetAddress:两个方法: getByName(String host) / getLocalHost()
 *      两个常用方法:getHostName(),getHostAddress()
 * 7. 端口号: 标识正在计算机上运行的进程.
 * 要求:不同的进程有不同的端口号(0 ~ 65535)
 *
 * 8. 端口号与IP地址的组合得出一个网络套接字: Socket
 *
 * @Author STXU
 * @Date 2022/4/15 20:40
 * @Version 1.0
 */
public class InetAddressTest {


    public static void main(String[] args) {
        try {
            //
            InetAddress ia = InetAddress.getByName("192.168.0.1");

            System.out.println(ia);

            InetAddress ia1 = InetAddress.getByName("www.grmz.vip");
            System.out.println(ia1);

            //获取本机ip
            InetAddress ia2 = InetAddress.getLocalHost();
            System.out.println(ia2);

            //getHostNme()
            System.out.println(ia2.getHostName());
            //getHostAddress()
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();

        }
    }

}
