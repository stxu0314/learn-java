package com.grmz.exer1;

import java.util.*;

/**
 * @author STXU
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<>();
    /**
     * 保存T类型的对象到Map 成员变量中
     */
    public void save(String id, T entity){
        map.put(id, entity);
    }
    /**
     * 从map中获取id对应的对象
     */
    public T get(String id) {
        return map.get(id);
    }
    /**
     * 替换map中key为id的内容,改为entity对象
     */
    public void update(String id,T entity){
        //是否有id这个key
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }
    /**
     * 返回map中存放的所有T 对象
     */
    public List<T> list() {
        //错误的
//        Collection<T> values = map.values();
//        return (List<T>) values;
        //正确的
        List<T> list = new ArrayList<T>();
        Collection<T> values = map.values();
        for (T entity : values) {
            list.add(entity);
        }
        return list;
    }
    /**
     * 删除指定id对象
     */
    public void delete(String id){
        map.remove(id);
    }
}
