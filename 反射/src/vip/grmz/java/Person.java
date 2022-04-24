package vip.grmz.java;

/**
 * @Author STXU
 * @Date 2022/4/18 8:01
 * @Version 1.0
 */
public class Person {
    /**
     * name
     */
    private String name;
    /**
     * age
     */
    public int age;

    public Person() {
    }


    private Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
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
    }public  void show(){
        System.out.println("你好,我是一个人");

    }
    private  String showNation(String nation){
        System.out.println("我的国籍是:"+nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
