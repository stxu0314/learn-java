package vip.grmz.stram;

import org.junit.Test;
import vip.grmz.lambda2.Employee;
import vip.grmz.lambda2.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 */
public class StreamAPITest1 {
    // 1. 筛选与切片
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //filter(Predicate p) 接收Lambda , 从流中排除某些元素。
        Stream<Employee> stream = employees.stream();
        //查询员工表中工资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
        //limit(n) 截断流， 使其元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //skip(n) 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流，与limit互补
        employees.stream().skip(3).forEach(System.out::println);

        System.out.println();
        // distinct() 筛选，通过流所生成的hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));

        employees.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2() {
        //map（Function f)  接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);


        System.out.println();
        //练习: 获取员工姓名长度大于3的员工姓名 。
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);

        // 练习二;
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
                });

        System.out.println();
        // flatMap(Function f) 接受一个函数作为参数，将流中的每个值都换成另一个流，ran hou ba 所you的流连成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringStream);
        characterStream.forEach(System.out::println);

    }
    // 将zi fu chuan zhong de duo ge zi fu gou cheng de ji he zhuan huan wei dui ying de Stream shi li
    public static Stream<Character> fromStringStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c:
             str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        //list.add(list2);
        list.addAll(list2);
        System.out.println(list2);
    }

    //3. 排序
    @Test
    public void test4(){
        //sorted()  zi ran 排序
        List<Integer> list = Arrays.asList(12, 23, 434, 545, 33, 23, 21);
        list.stream().sorted().forEach(System.out::println);

        // pao yi chang，yuan yin:Employee mei you shi xian Comparable jie kou
        // List<Employee> employees = EmployeeData.getEmployees();
       // employees.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> {
            int ageVal = Integer.compare(e1.getAge(),e2.getAge());
            if (ageVal != 0){
                return ageVal;
            }
            else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }

}