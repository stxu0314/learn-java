package com.grmz;

import org.junit.Test;

import java.util.*;

/**
 * 面试题:Collection和Collections的区别?
 * Collection是个接口
 * Collections是工具类
 *
 *
 * reverse(List):反转List 中元素的顺序
 * shuffle(llst):对 List集合元素进行随机排序
 * sort(List):根据元素的自然顺序对指定List集合元素按升序排序
 * sort(List，Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
 *
 * swap(List,int,int):将指定list 集合中的i处元素和j处元素进行交换
 * object max(collection):根据元素的自然顺序，返回给定集合中的最大元素
 * object max(collection，Comparator):根据Comparator指定的顺序，返回给定集合中的最大object min(colLection)
 * object min(collection，Comparator)
 * int frequency(collection，object):返回指定集合中指定元素的出现次数void copy(List dest,List src):将src中的内容复制到dest中
 * boolean replaceALL(List list，object oldval，object newVaL):使用新值替换List对象
 */
public class CollectionsTest {

    //Copy()方法
    @Test
    public void test2()
    {
        List list = new ArrayList();
        list.add(123);
        list.add(23);
        list.add(1223);
        list.add(324);
        list.add(234);

        //报异常:IndexOutOfBoundsException
//        List dest=new ArrayList();
//        Collections.copy(dest,list);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

        /*
        Collections类中提供了多个synchronizedXxx()方法，
        该方法可使将指定集合包装成线程同步的集合，
        从而可以解决多线程并发访问集合时的线程安全问题
        */
        //返回的List1即为线程安全的List
        List list1 = Collections.synchronizedList(list);

    }
    @Test
    public void test()
    {
        List list = new ArrayList();
        list.add(123);
        list.add(23);
        list.add(1223);
        list.add(324);
        list.add(234);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.swap(list,1,2);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                 Integer i1 = (Integer)o1;
                 Integer i2 = (Integer)o2;
                return Integer.compare(i2,i1);
            }
        });
        System.out.println(list);

    }
}
