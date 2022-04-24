package vip.grmz.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式使用举例
 *
 * @Author STXU
 * @Date 2022/4/22 8:31
 * @Version 1.0
 */
public class LambdaTest {
    @Test
    public void test(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("你好,世界");
            }
        };
        r1.run();

        System.out.println("*******************");

        Runnable r2 = () -> System.out.println("你好,Lambda");
        r2.run();

    }
    @Test
    public void test1(){
        Comparator<Integer> com1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = com1.compare(31,45);
        System.out.println(compare);

        System.out.println("********************");

        //lambda表达式
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(31,45);
        System.out.println(compare);
        System.out.println("**********************");

        //方法引用
        Comparator<Integer> com3 = Integer::compare;

        int compare3 = com2.compare(31,45);
        System.out.println(compare);


    }
}
