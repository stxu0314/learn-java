package vip.grmz.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 一. 流的分类:
 * 1.操作数据单位:字节流,字符流
 * 2.数据的流向:输入流,输出流
 * 3.流的角色:字节流,处理流
 *
 * 二. 流的体系结构
 *            抽象基类             节点流(或文件流)                                    缓冲流(处理流的一种)
 * 字节流     InputStream          FileInputStream (read(byte[] buffer))            BufferedInputStream (read(byte[] buffer))
 * 字节流     OutputStream         FileOutputStream (write(byte[] buffer,0,len))    BufferedOutputStream (write(byte[] buffer,0,len)) / flush()
 * 字符流     Reader               FileReader (read(char[] cbuf))                   BufferedReader (read(char[] cbuf) / readLine())
 * 字符流     Writer               FileWriter (write(char[] cbuf,0,len))            BufferedWriter (write(char[] cbuf,0,len)) / flush()
 *
 *
 *
 * @Author STXU
 * @Date 2022/4/13 9:56
 * @Version 1.0
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        // 相较于当前工程
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());

        File file1 = new File("IO流\\hello.txt");
        System.out.println(file1.getAbsolutePath());

    }

    /**
     * 将 hello.txt文件内容读入程序中,并输出到控制台
     *
     * 说明点:
     * 1. read()的理解:返回读入的一个字符,如果达到文件末尾,返回-1
     * 2. 异常的处理:为了保证流资源一定可以执行关闭操作. 需要使用try-catch-finally处理
     * 3. 读入的文件,一定要存在,否则会报FileNotFoundException
     *
     */
    @Test
    public void testFileReader() {
        // 相较于当前Module
        File file = new File("hello.txt");
        //提供具体的流
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);

        //数据的读入
        //read():返回读入的一个字符,如果达到文件末尾,返回-1
        //方式一
//        int read = fileReader.read();
//        while (read !=-1 ) {
//            System.out.print((char)read);
//            read = fileReader.read();
//        }

        //方式二
        int read;
        while ((read = fileReader.read())!=-1) {
            System.out.print((char)read);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭操作
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 对read()操作升级: 使用read的重载方法
     */
    @Test
    public void testFileReader1() {
        FileReader fileReader = null;
        try {
            //1. File类的实例化
            File file = new File("hello.txt");

            //2. FileReader流的实例化
            fileReader = new FileReader(file);

            //3.读入的操作
            //read(char[] chars):返回每次读入chars数组中的字符个数. 如果达到文件末尾,返回-1
            char[] chars = new char[5];
            int len;
            while((len = fileReader.read(chars)) != -1){
                //方式一
                //错误的写法
//                for (int i = 0; i < chars.length; i++) {
//                    System.out.print(chars[i]);
//                }
                //正确的写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }
                //方式二:
                //错误的写法
//                String str = new String(chars);
//                System.out.println(str);
                //正确的写法
                String str = new String(chars,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.资源的关闭
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  从内存中写出数据到硬盘的文件里
     *
     *  说明:
     *  1. 输出操作,对应的File可以不存在,并不会报异常
     *  2. File对应的硬盘中的文件如果不存在,在输出的过程中,会自动创建此文件
     *     File对应的硬盘中的文件如果存在:
     *          如果流使用的构造器是:FileWriter(file,false)/FileWriter(file):对原有文件的覆盖
     *          如果流使用的构造器是:FileWriter(file,true):不会对原有文件的覆盖,而是在原有文件追加
     *
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象,指明写出到的文件
            File file = new File("hello1.txt");

            //2. 提供FileWriter的对象,用于数据的写出
            fw = new FileWriter(file,true);

            //3. 写出的操作
            fw.write("I have a dream!\n");
            fw.write("You need to have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.资源的关闭
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  复制文件:不能使用字符流处理图片
     *
     */
    @Test
    public void testFileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象,指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //2.创建输入流和输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] chars = new char[5];
            int len;//记录每次读入到chars数组中的字符个数
            while ((len=fr.read(chars)) != -1) {
                //每次写出len个字符
                fw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //4.关闭流资源
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
