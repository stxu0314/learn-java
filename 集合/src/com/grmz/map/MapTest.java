package com.grmz.map;

import org.junit.Test;

import java.util.*;

/**
 * 一.Map实现类结构:
 * |----Map:双列数据, 存储key-value对数据  ---类似于高中的函数: y=f(x)
 *      |---HashMap:作为Map的主要实现类; 线程不安全的,效率高; 存储null的key和value
 *          |---LinkedHashMap:保证在遍历map元素时,可以按照添加的顺序实现遍历.
 *              原因:在原有的HashMap底层结构基础上,添加了一堆指针,指向前一个和后一个元素.
 *              对于频繁的遍历操作,此类执行效率高于HashMap
 *      |---TreeMap:保证按照添加的key-value对进行排序,实现排序遍历/此时考虑key的自然排序或者定制排序
 *                  底层使用红黑树
 *      |---Hashtable:作为古老的实现类;线程安全的,效率低;不能存储null的key和value
 *          |---properties:常用来处理配置文件;key和value都是String类型
 *
 *
 *      HashMap的底层:数组+链表 (jdk7之前)
 *                  数组+链表+红黑树(jdk8)
 * 面试题:
 * 1.HashMap的底层实现原理?
 * 2.HashMap 和 Hashtable的异同?
 * 3.CurrentHashMap 与 Hashtable的异同?
 *
 * 二.Map结构的理解:
 * Map中的key:无序的,不可重复的,使用Set存储所有的key  --->key所在的类重写equals()和hashCode()  (以HashMap为例)
 * Map中的value:无序的,可重复的,使用Collection存储所有的value --->value11所在的类要重写equals()
 * 一个键值对:key-value构成了一个Entry对象
 * Map中的entry:无序的,不可重复的,使用Set存储所有的entry
 *
 *
 * 三.HashMap的底层实现原理?  以jdk7为例说明:
 *          HashMap map =  new HashMap();
 *          在实例化以后,底层创建了长度是16的一维数组Entry[] table.
 *          ...可能已经执行过多次put...
 *          map.put(key1,value1);
 *          首先,调用key1所在类的hashCode()计算key1 哈希值,此哈希值经过某种算法计算以后,得到在Entry数组中的存放位置
 *          如果此位置上的数据为空,此时的key1-value1添加成功. ---情况一
 *          如果此位置上的数据不为空,(意味着此位置上存在着一个或多个数据(以链表的形式存在)),比较key1和已经存在的一个或多个数据的哈希值:
 *              如果key1的哈希值与已经存在的数据的哈希值都不相同,此时key1-value添加成功. ---情况二
 *              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同,继续比较:调用key1所在类的equals()方法,比较:
 *                      如果equals()返回false:此时key1-value1添加成功. ---情况三
 *                      如果equals()返回true:使用value1替换value2值.
 *
 *           补充:关于情况二和情况三:此时key1-value1和原来的数据以链表的方式存储.
 *
 *           在不断的添加过程中,会涉及到扩容问题,当超出临界值(且要存放的位置非空)时, 扩容. 默认的扩容方式, 扩容为原来容量的2倍,并将原有的数据复制过来.
 *
 *           jdk8相较于jdk7在底层实现的不同:
 *           1. new HashMap():底层没有创建一个长度为16的数组
 *           2. jdk8 底层的数组是: Node[], 而非Entry[]
 *           3. 首次调用put方法时,底层创建长度为16的数组
 *           4. jdk7底层结构只有:数组+链表 . jdk8底层结构:数组+链表+红黑树
 *              当数组的某一个索引位置上的元素以链表的形式存在的数据个数 > 8 且当前数组的长度 > 16 时,
 *              此时索引位置上的所有数据改为红黑树存储.
 *
 *  四. LinkedHashMap的底层实现原理(了解)
 *
 *  五. Map常用方法:
 *     Object put(Object key,Object value) 添加(修改)元素
 *     void putAll(Map m) :添加m所有元素
 *     Object remove(Object key): 删除指定key的key-value对,并返回value
 *     void clear():清空所有数据
 *  元素查询的操作:test3()
 *      Object get(Object key):获取指定key对应的value
 *      boolean containsKey(Object key):是否包含指定的key
 *      boolean containsValue(Object Value):是否包含指定的Value
 *      int size(): 返回map中key-value的个数
 *      boolean isEmpty():判断当前map是否为空
 *      boolean equals(Object obj):判断当前map和参数对象obj是否相等
 *  原视图操作的方法: test4()
 *      Set keySet():返回所有Key构成的Set集合
 *      Collection values():返回所有value构成的Collection集合
 *      Set entrySet():返回所有key-value对构成的Set集合
 *
 * 总结:常用方法:
 * 添加:put(k,v)
 * 删除:remove(k)
 * 修改:put(k,v)
 * 查询:get(k)
 * 长度:size()
 * 遍历:keySet()  / values() /entrySet()
 *
 * @author STXU
 */
 public class MapTest implements Comparable{

    @Test
    public void test4(){
        Map map = new HashMap();
        map.put(123,"AA");
        map.put(23,"BB");
        map.put(565,"CC");

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println();

        Collection values = map.values();
       iterator = values.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println();
        //方式一:
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext())
        {
            Object obj = iterator1.next();
//            entrySet集合中的所有元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

        System.out.println();
        //方式二:
        Set set2 = map.keySet();
        iterator = set2.iterator();
        while (iterator.hasNext())
        {
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println(key+"===>"+value);
        }

    }

    @Test
    public void test3(){
        Map<Integer,String> map1 = new LinkedHashMap();
        map1.put(123,"AA");
        map1.put(23,"BB");
        map1.put(565,"CC");

        Map map = new HashMap();
        map.put(123,"AA");
        map.put(23,"BB");
        map.put(565,"CC");

        System.out.println(map.get(23));
        System.out.println(map.containsKey(123));
        System.out.println(map.isEmpty());
        System.out.println(map.equals(map1));
    }


    @Test
    public void test2(){
        Map map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(23,"BB");
        map.put(565,"CC");
        System.out.println(map);
        map.clear();
        System.out.println(map.size());
    }
    @Test
    public void test1(){
        Map map = new HashMap();
//        map = new Hashtable();
        map.put(null,123);
        map.put(32,"aa");
        map.put(342,"bb");
        map.put(123,"cc");
        map.put(234,"dd");
        System.out.println(map);

    }

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("MapTest.main");
    }
    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序:自然排序,定制排序
    @Test
    public void test5(){
        TreeMap treeMap = new TreeMap(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1= (User)o1;
                    User u2= (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });


        //线程安全的
        Map map = Collections.synchronizedMap(treeMap);
        User u1 = new User(12,"Tom");
        User u2 = new User(46,"liming");
        User u3 = new User(34,"jery");
        User u4 = new User(33,"jack");

        //map.null
        if (map == null) {

        }
        //map.nn
        if (map != null) {

        }

        treeMap.put(u1,1);
        treeMap.put(u2,2);
        treeMap.put(u3,3);
        treeMap.put(u4,4);

        Set set2 = treeMap.keySet();
        Iterator iterator = set2.iterator();
        while (iterator.hasNext())
        {
            Object key = iterator.next();
            Object value = treeMap.get(key);
            System.out.println(key+"===>"+value);
        }
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


class User{


    private int age;
public void test1(){

}

   User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    
}
