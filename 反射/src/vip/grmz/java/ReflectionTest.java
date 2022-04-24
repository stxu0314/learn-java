package vip.grmz.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * @Author STXU
 * @Date 2022/4/18 8:01
 * @Version 1.0
 */
public class ReflectionTest {
    //反射之前对于Person的操作

    @Test
    public void test(){
        //1.创建Person类的对象
        Person p1 = new Person("Tom",13);
        p1.setAge(14);
        System.out.println(p1.toString());

        p1.show();
        //在Person类的外部,不可以通过Person类的对象调用其私有结构

    }

    /**
     * 反射之后对于Person的操作
     * @Author STXU
     * @Description //TODO
     * @Date 8:10 2022/4/18
     * @Param
     * @return
     */

    @Test
    public void test2() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Class clazz = Person.class;
        //通过反射,创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object tom = cons.newInstance("tom", 12);
        Person p = (Person) tom;
        System.out.println(p.toString());
       //通过反射,调用对象指定的属性,方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,16);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("***************************");

        //通过反射,我们可以调用Person私有的结构
        // 调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性和方法
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"st");
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //相当于String nation = p1.showNation("china");
        String nation = (String) showNation.invoke(p1, "china");
        System.out.println(nation);


    }

    //疑问?  放射机制与面向对象的封装性是否矛盾? 如何看待这两个技术?
    //不矛盾,

    //疑问? 通过直接new对象的方式或反射的方式都可以调用公共的结构,开发中到底用哪个?
    //建议: 用直接new的方式.
    //什么时候会使用反射的方式?  反射的特征: 动态性

        /*
        关于java.lang.Class类的理解
        1. 类的加载过程:
        程序在经过javac.exe命令之后, 会生成一个或多个字节码文件(.class结尾), 接着我们使用
        java.exe对某个字节码文件进行解释运行.相当于囧某个字节码文件加载到内存中. 此过程叫类的加载.
        加载到内存中的类, 我们就称为运行时类, 此运行时类, 就作为Class的一个实例.

        2.换句话说:Class的实例就对应着一个运行时类.
        3.加载到内存中的运行时类,会缓存一段时间,在此时间内,我们可以通过不同的方式获取到此运行时类.

         */
    /**
     * 获取Class的实例的方式
     * @Author STXU
     * @Description //TODO
     * @Date 9:10 2022/4/18
     * @Param
     * @return
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一:调用运行时类的属性: .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二:通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三:调用Class的静态方法:forName(String classPath)
        Class clazz3 = Class.forName("vip.grmz.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //方式四: 使用类的加载器: ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("vip.grmz.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);

    }
    //万物皆对象?对象.xxx, File,URL,反射,前端,数据库操作
    /**
     * Class实例可以是哪些结构的说明:
     * @Author STXU
     * @Description //TODO
     * @Date 20:11 2022/4/18
     * @Param
     * @return
     */
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = int.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要数组元素类型与维度一样,就是同一个Class
        System.out.println(c10 == c11);

    }
}