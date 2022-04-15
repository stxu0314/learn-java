package vip.grmz.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一: 缓冲流的使用
 *
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2. 作用:提高流读取写入的速度
 *      提高读写速度的原因,内部提供了一个缓冲区
 *
 * 3. 处理流,就是"套接"在已有的流的基础上
 *
 * @Author STXU
 * @Date 2022/4/13 15:08
 * @Version 1.0
 */
public class BufferTest {

    /**
     * 实现非文本文件的复制
     */
    @Test
    public void testBufferStream() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 造文件
            File srcFile = new File("8540677.jpg");
            File destFile = new File("壁纸2.jpg");

            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求:先关闭外层的流,再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明:关闭外层流的同时,内层流也会自动关闭,内层流的关闭可以省略
//        fos.close();
//        fis.close();
        }

    }

    /**
     * 实现文件复制的方法
     *
     */
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节
            byte[] buffer = new byte[4096];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求:先关闭外层的流,再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明:关闭外层流的同时,内层流也会自动关闭,内层流的关闭可以省略
//        fos.close();
//        fis.close();
        }

    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\STXU\\Desktop\\QQ录屏20220410115953.mp4";
        String destPath = "e:\\搏击.mp4";
        copyFileWithBuffered(destPath,srcPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为: "+(end - start));
    }

    /**
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     *
     */
    @Test
    public void testBufferedReaderWithWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式1
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf,0,len);
//            }
            //方式二
            String data;
            while ((data= br.readLine()) != null){
                //方法一
                // data 中不包含换行符
//                bw.write(data+"\n");
                //方法二
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
