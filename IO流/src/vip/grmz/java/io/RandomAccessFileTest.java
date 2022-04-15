package vip.grmz.java.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1. RandomAccessFile直接继承于java.lang.Object类,实现了DataInput和DataOutput接口
 * 2. RandomAccessFile既可以作为一个输入流,又可以作为一个输出流
 * 3. 如果RandomAccessFile作为输出流时,写出到的文件如果不存在,则在执行过程中自动创建;
 *      如果文件存在则会对原有文件内容进行覆盖. (默认情况下,从头开始覆盖)
 *
 * 4. 可以通过相关的操作, 实现RandomAccessFile"插入"数据的效果
 *
 * @Author STXU
 * @Date 2022/4/15 9:13
 * @Version 1.0
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        /*
        new RandomAccessFile(new File("壁纸.jpg"),"r");
        第二个参数:
        r: 以只读的方式打开
        rw: 打开以便读取和写入
        rwd: 打开以便读取和写入; 同步文件内容的更新
        rws: 打开以便读取和写入; 同步文件的内容和元数据的更新
         */
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("壁纸.jpg"),"r");
            raf2 = new RandomAccessFile(new File("壁纸1.jpg"),"rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {

                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello3.txt","rw");

        //将指针调到角标为3的位置
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.close();

    }

    /**
     * 使用RandomAccessFile实现数据的插入效果
     * @Author STXU
     * @Description //TODO
     * @Date 17:12 2022/4/15
     * @Param []
     * @return void
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello2.txt","rw");

        raf1.seek(3);
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder( (int) (new File("hello2.txt").length()));
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) !=-1) {
            builder.append(new String(buffer,0,len));

        }
        //调回指针,写入"xyz"
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());
        raf1.close();

        //思考:将StringBuilder替换为ByteArrayOutputStream

    }
}
