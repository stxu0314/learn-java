package vip.grmz.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的四大核心函数式接口
 *
 * 消费型接口  Consumer<T>    void accept(T t)
 * 供给型接口  Supplier<T>    T get()
 * 函数型接口  Function<T,R>  R apply(T t)
 * 断定型接口  Predicate<T>   boolean test(T t)
 *
 * @Author STXU
 * @Date 2022/4/23 17:23
 * @Version 1.0
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("价格="+aDouble);
            }
        });

    happyTime(400,money -> System.out.println("价格为"+money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","上海","杭州","兰州");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        List<String> list2 = filterString(list,s -> s.contains("京"));
        System.out.println(list2);
    }

    /**
     * 根据给定的规则,过滤集合中的字符串. 此规则由Predicate的方法决定
     * @Author STXU
     * @Description //TODO
     * @Date 17:37 2022/4/23
     * @Param
     * @return null
     */
    public List<String> filterString(List<String> list, Predicate<String> pre){

        List<String> filterList = new ArrayList<String>();
        for (String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
