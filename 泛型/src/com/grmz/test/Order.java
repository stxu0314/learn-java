package com.grmz.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * @author STXU
 * @param <T>
 */
public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(){

    }
    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

//    泛型方法:在方法中出现了泛型的结构,泛型参数与类的泛型参数没有任何关系
    //换句话说,泛型方法所属的类是不是泛型类都没有关系.
    //泛型方法可以声明为静态的,原因:泛型参数是在调用方法时确定的,并非在实例化类时确定

    public static  <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<E>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
