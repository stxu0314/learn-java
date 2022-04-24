package vip.grmz.lambda2;

import org.junit.Test;

import java.util.Comparator;

/**
 * 类 :: 实例方法(有难度)
 *
 * @Author STXU
 * @Date 2022/4/23 20:04
 * @Version 1.0
 */
public class MyMethodTest {
    /**
     * Comparator中的int compare(T t1, T t2)
     * String中的int t1.compareTo(t2)
     * @Author STXU
     * @Description //TODO
     * @Date 20:05 2022/4/23
     */
    @Test
    public void test1(){
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));

        System.out.println("********************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "acd"));




    }
}
