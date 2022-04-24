package vip.grmz.java2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @Author STXU
 * @Date 2022/4/20 9:15
 * @Version 1.0
 */
public class FieldTest {
    @Test
    public void test() throws ClassNotFoundException {
//        Class clazz = Person.class;
        Class clazz = Class.forName("vip.grmz.java1.Person");
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //getDeclaredFields(): 获取当前运行时类自己定义的所有属性(不包含父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    /**
     * 权限修饰符   数据类型   变量名
     * @Author STXU
     * @Description //TODO
     * @Date 9:22 2022/4/20
     * @Param
     * @return null
     */
    @Test
    public void test1() throws ClassNotFoundException {
        Class clazz = Class.forName("vip.grmz.java1.Person");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //1. 权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2. 数据类型
            Class<?> type = field.getType();
            System.out.print(type.getName() + "\t");

            //3. 变量名
            String name = field.getName();
            System.out.print(name);
            System.out.println();
        }


    }
}
