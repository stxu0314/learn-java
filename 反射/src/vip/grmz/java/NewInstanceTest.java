package vip.grmz.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 * @Author STXU
 * @Date 2022/4/18 20:48
 * @Version 1.0
 */
public class NewInstanceTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class clazz = Class.forName("vip.grmz.java.Person");

        /*
        newInstance():调用此方法,创建对应的运行时类的对象. 内部调用了运行时类的空参构造器.
        要想此方法正常的创建运行时类的对象,要求:
        1. 运行时类必须提供空参构造器
        2. 空参构造器的访问权限得够. 通常,设置为public

        在javabean中要求提供一个public的空参构造器.原因:
        1. 便于通过反射,创建运行时类的对象
        2. 便于子类继承此运行时类时,默认super()时,保证父类有此构造器

         */
        Object obj = clazz.newInstance();
        System.out.println(obj);

    }


    /**
     * 体会反射的动态性
     * @Author STXU
     * @Description //TODO
     * @Date 21:55 2022/4/18
     * @Param null
     */
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0 :
                classPath = "java.util.Date";
                break;
            case 1 :
                classPath = "java.lang.Object";
                break;
            case 2 :
                classPath = "vip.grmz.java.Person";
                break;
            default:
                System.out.println("please exit");
        }
    Object obj = getInstance(classPath);
    System.out.println(obj);

    }

 /**
  * 创建一个指定类的对象
  * classPath: 指定类的全类名
  * @Author STXU
  * @Description //TODO
  * @Date 21:52 2022/4/18
  * @Param String classPath
  * @return Object
  */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
