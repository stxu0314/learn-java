package vip.grmz.java2;

import org.junit.Test;
import vip.grmz.java1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构:属性, 方法, 构造器
 * @Author STXU
 * @Date 2022/4/20 17:21
 * @Version 1.0
 */
public class ReflectionTest {
    /**
     * 获取指定的属性
     * @Author STXU
     * @Description //TODO
     * @Date 17:23 2022/4/20
     * @Param
     * @return null
     */
    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        // 获取指定的属性:要求运行时类中的属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");
//        Field age = clazz.getField("age");

        //设置当前属性的值   set():参数1:指明设置哪个对象的属性  参数2:将此属性设置为多少
        id.set(p, 1001);

        //获取当前属性的值  get():指明哪个对象
        int pId = (int) id.get(p);
        System.out.println(pId);

    }
    /**
     * 如何操作运行时类指定的属性
     * @Author STXU
     * @Description //TODO
     * @Date 17:39 2022/4/20
     * @Param
     * @return null
     */
    @Test
    public void testField1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1. 获取某个属性:getDeclaredField(String Name)
        Field age = clazz.getDeclaredField("age");

        //2. 保证当前属性是可修改的
        age.setAccessible(true);
        //3. 设置指定对象的此属性值
        age.set(p,19);
        System.out.println(age.get(p));

    }
    /**
     * 如何操作运行时类指定的方法
     * @Author STXU
     * @Description //TODO
     * @Date 17:39 2022/4/20
     * @Param
     * @return null
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        /*
        1. 获取指定的方法
        getDeclaredMethod():参数1: 指明获取方法的名称,  参数2:指明获取方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2. 保证当前方法是可访问的
        show.setAccessible(true);
        /*
        3. 调用方法的invoke()
        invoke():参数1:方法的调用者   参数2: 给方法形参赋值的实参
        返回值即为对应类中调用方法的返回值
         */
        Object chn = show.invoke(p, "CHN");
        System.out.println(chn);

        System.out.println("***********staticMethod***********");

        //调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //都可以
//        Object invoke = showDesc.invoke(clazz);
        Object invoke = showDesc.invoke(null);
        System.out.println(invoke);
    }

    /**
     * 如何调用运行时类中的构造器
     * @Author STXU
     * @Description //TODO
     * @Date 17:54 2022/4/20
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;

        //1. 获取指定的构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2. 保证此构造器可访问
        constructor.setAccessible(true);

        //3.调用构造器
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);

    }
}
