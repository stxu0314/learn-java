package vip.grmz.java.io;

import java.io.Serializable;

/**
 * Person需要满足如下的要求方可序列化
 * 1. 需要实现接口: Serializable
 * 2. 当前类提供一个全局常量: serialVersionUID
 * 3. 除了当前Person类需要实现Serializable接口之外,还必须保证其内部所有属性也必须是可序列化的.(默认情况下,基本数据类型可序列化)
 *
 *
 * @Author STXU
 * @Date 2022/4/15 8:14
 * @Version 1.0
 */
public class Person implements Serializable {
    /**
     * 序列版本号
     */
    public static final long serialVersionUID = 4287685656557L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }





}
