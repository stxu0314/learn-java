package com.grmz.exer1;

import java.util.List;

/**
 * @author STXU
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,21,"tom"));
        dao.save("1003",new User(1003,27,"jack"));

        dao.update("1003",new User(1003,30,"liming"));

        dao.delete("1002");

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out ::println);

    }
}
