package com.grmz.test1;

import org.junit.Test;

import java.util.List;

/**
 * @author STXU
 */
public class DAOTest {

    @Test
    public void test(){
        CutomerDAO dao = new CutomerDAO();
        dao.add(new Cutomer());
        List<Cutomer> list = dao.getForList(10);

        StudentDAO dao1 = new StudentDAO();
        Student student = dao1.getIndex(1);
    }
}
