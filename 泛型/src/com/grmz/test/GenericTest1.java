package com.grmz.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类测试
 */
public class GenericTest1 {

    @Test
    public void test(){
        //如果定义了泛型类,实例化没有指明类的泛型,则认为泛型类型为Object
        //要求:如果定义了是带泛型的,建议在实例化时指明泛型
        Order objectOrder = new Order();
        objectOrder.setOrderT(999);
        objectOrder.setOrderT("ihh");

        Order<String> order = new Order<>();
        order.setOrderT("uuu");
        //编译报错
//        order.setOrderT(99);
    }

    @Test
    public void test2(){
        SubOrder1 subOrder1 = new SubOrder1();
        subOrder1.setOrderT(999);

    }
    @Test
    public void test1(){
        SubOrder<String> subOrder = new SubOrder<>();
        subOrder.setOrderT("qqq");

    }

    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();

        // 泛型不同的引用不能相互赋值
//        list1 = list2;

    }
    
    @Test
    public void test5(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[] {1, 2, 3, 4};
        List<Integer> list2 = Order.copyFromArrayToList(arr);
        System.out.println(list2);

    }
}
