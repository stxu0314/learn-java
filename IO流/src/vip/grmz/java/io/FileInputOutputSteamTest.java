package vip.grmz.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论:
 * 1. 对于文本文件(.txt,.java,.cpp),使用字符流进行处理
 * 2.对于非文本文件(.jpg,.mp4,.mp3,.doc),使用字节流处理
 * @Author STXU
 * @Date 2022/4/13 11:32
 * @Version 1.0
 */
public class FileInputOutputSteamTest {

    /**
     * 使用字节流处理文本文件可能出现乱码
     */
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2. 造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 实现对图片的复制操作
     */
    @Test
    public void testInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File("8540677.jpg");
            File destFile = new File("壁纸.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                if (fos != null) {
                    //
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
               }
        }
    }

  /**
   * @Author STXU
   * @Description //TODO
   * @Date 8:58 2022/4/15
   * @Param [srcPath, destPath]
   * @return void
   * 指定路径下文件的复制
   */
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\STXU\\Desktop\\QQ录屏20220410115953.mp4";
        String destPath = "e:\\搏击.mp4";
        copyFile(destPath,srcPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为: "+(end - start));
    }
}
