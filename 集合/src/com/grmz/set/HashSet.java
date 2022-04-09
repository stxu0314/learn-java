package com.grmz.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * Set: 存储无序的,不可重复的数据
 * 以hashset为例:
 *  无序性:不等于随机性. 存储的数据在底层数组中并非按照数组索引的顺序添加,而是根据数据的哈希值
 *
 *  不可重复性:保证添加的元素按照equals()判断时,不能返回true,即:相同的元素只能添加一个
 *
 * 添加元素的过程: 以HashSet为例:
 *      我们向HashSet中添加元素a, 首先调用元素a所在类的HashCode()方法,计算元素的哈希值.
 *      此哈希值接着通过某种算法计算出在HashSet底层数组的存放位置,(即:索引位置),判断
 *      数组此位置上是否已经有其他元素.
 *          如果此位置没有其他元素.则元素a添加成功.
 *          如果此位置有其他元素b(或以链表的形式存放多个元素),则比较a与b的hash值;
 *              如果hash值不相同:则元素a添加成功.
 *              如果hash值相同,进而需要调用元素a所在类的equals()方法:
 *                  equals()返回true,元素a添加失败;
 *                  equals()返回false,则元素a添加成功.
 * 要求:使用HashSet必须重写hashCode方法和equals方法
 *
 *
 * 向TreeSet添加数据,只能是相同类的对象;
 * 两种排序方式: 自然排序  和  定制排序
 *
 */

public class HashSet {

    public static void main(String[] args) {
        test1();

    }

    public static void test1(){
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(343);
        set.add(34);
        set.add(454);
        set.add(35);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
