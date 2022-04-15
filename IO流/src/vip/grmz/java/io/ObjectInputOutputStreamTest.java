package vip.grmz.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 1. 对象流的使用
 *  1.1 ObjectInputStream 和 ObjectOutputStream
 *  1.2 作用:用于存储和读取基本数据类型或对象的处理流 .它的强大之处就是可以把java中的对象写入到数据源中,也能把对象从数据源还原回来
 *  1.3 要想一个java对象是可序列化的,需要满足相应的要求
 * @Author STXU
 * @Date 2022/4/15 7:55
 * @Version 1.0
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程:将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("hello world!"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("张三",23));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 反序列化:将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInputStream实现
     * @Author STXU
     * @Description //TODO
     * @Date 9:07 2022/4/15
     * @Param []
     * @return void
     **/
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
