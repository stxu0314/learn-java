package vip.grmz.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 * @Author STXU
 * @Date 2022/4/18 20:26
 * @Version 1.0
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类,使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent(): 获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent(): 无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库,无法加载自定义类的.
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

    }
    /**
     * Properties: 用来读取配置文件
     * @Author STXU
     * @Description //TODO
     * @Date 20:34 2022/4/18
     * @Param
     * @return
     */
    @Test
    public void test2() throws IOException {
        Properties props = new Properties();
        //此时的文件默认在当前的Module下
        //读取配置文件的方式一:
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        props.load(fis);

        //读取配置文件的方式二:使用ClassLoader
        //配置文件默认识别为: 当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        System.out.println("user="+user+","+ "password="+password);
    }

}
