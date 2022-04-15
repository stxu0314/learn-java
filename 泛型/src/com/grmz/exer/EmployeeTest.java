package com.grmz.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {

    @Test
    public void test(){
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("tom", 44, new MyDate(1974, 12, 3));
        Employee e2 = new Employee("mary", 34, new MyDate(1984, 5, 8));
        Employee e3 = new Employee("jack", 23, new MyDate(1997, 8, 5));
        Employee e4= new Employee("jory", 32, new MyDate(1989, 8, 5));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        //使用定制排序,用生日排序
        TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
            //使用泛型的写法
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                return b1.compareTo(b2);
            }
        });
        Employee e1 = new Employee("tom", 44, new MyDate(1974, 12, 3));
        Employee e2 = new Employee("mary", 34, new MyDate(1984, 5, 8));
        Employee e3 = new Employee("jack", 23, new MyDate(1997, 8, 5));
        Employee e4 = new Employee("jory", 32, new MyDate(1989, 8, 5));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
