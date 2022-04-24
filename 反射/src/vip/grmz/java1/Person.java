package vip.grmz.java1;

/**
 * @Author STXU
 * @Date 2022/4/18 21:57
 * @Version 1.0
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;
    public Person() {

    }
    @MyAnnotation
    private Person(String name){
        this.name = name;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation("ABC")
    private String show(String nation){
        System.out.println("我的国籍是:"+nation);
        return nation;
    }
    public String display(String interests,int age) throws RuntimeException,ClassNotFoundException{
        return interests + age;

    }
    private static void showDesc(){
        System.out.println("我是静态人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
