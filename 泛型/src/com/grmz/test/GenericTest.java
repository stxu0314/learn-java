package com.grmz.test;

import org.junit.Test;

import java.util.*;

/**
 * 1. 在jdk5.0以后,使用集合都得指明泛型
 * 2.在集合中使用泛型(Employee)
 *
 * 3.如何自定义泛型结构: 泛型类, 泛型接口, 泛型方法
 *
 */

public class GenericTest {

    
    //使用泛型之前
    @Test
    public void test(){
        List list = new ArrayList();
        //存放成绩
        list.add(123);
        list.add(324);
        list.add(343);
        list.add(323);
        //类型不安全
        //list.add("tom");
        for (Object score:
             list) {
            //可能出现类型转换异常
            int stuScore = (Integer) score;
            System.out.println(stuScore);

        }
    }

    //使用泛型后
    @Test
    public void test1(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(76);
        list.add(67);
        list.add(98);
        list.add(78);

        // 报错,编译时就会进行类型检查
        //list.add("sss");
        //方式一
//        for (Integer score:
//                list) {
//            //可能出现类型转换异常
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
       
        
        //方式二
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    //map中使用泛型
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("tom",18);
        map.put("mary",22);
        map.put("liming",21);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key +"已经"+value+"岁了");

        }
    }
}
