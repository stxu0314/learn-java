package vip.grmz.java.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author STXU
 * @Date 2022/4/11 17:35
 * @Version 1.0
 * 
 */
public class FileExercise {
    
    @Test
    public void test() throws IOException {
        File file = new File("d:\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另一个文件,文件名为haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("创建成功!");
        }
            
    }


    /**
     * 遍历指定文件目录下所有的文件,包括子文件目录中的文件
     */
    public static void printFile(File dir){
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                printFile(file);
            }else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
    @Test
    public void test1(){
        File dir = new File("d:\\java");
        printFile(dir);
    }
}
