package vip.grmz.java2;

import org.junit.Test;
import vip.grmz.java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author STXU
 * @Date 2022/4/20 10:06
 * @Version 1.0
 */
public class OtherTest {
    /*
    获取构造器结构
     */

    @Test
    public void test(){
        Class clazz = Person.class;

        //当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor:
             constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        //获取当前运行时类中所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
    }
    /**
     * 获取运行时类的父类
     * @Author STXU
     * @Description //TODO
     * @Date 10:11 2022/4/20
     */
    @Test
    public void test1(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

    }
    /**
     * 获取运行时类的带泛型的父类
     * @Author STXU
     * @Description //TODO
     * @Date 10:11 2022/4/20
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }
    /**
     * 获取运行时类的带泛型的父类的泛型
     * @Author STXU
     * @Description //TODO
     * @Date 10:11 2022/4/20
     */
    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        System.out.println(actualTypeArguments[0].getTypeName());

    }
    /**
     * 获取运行时类实现的接口
     * @Author STXU
     * @Description //TODO
     * @Date 17:09 2022/4/20
     */
    @Test
    public void test4(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }
    /**
     * 获取运行时类所在的包
     * @Author STXU
     * @Description //TODO
     * @Date 17:12 2022/4/20
     * @Param
     * @return void
     */
    @Test
    public void test5(){
        Class clazz = Person.class;

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    /**
     * 获取运行时类的注解
     * @Author STXU
     * @Description //TODO
     * @Date 17:13 2022/4/20
     * @Param
     * @return null
     */
    @Test
    public void test6(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
