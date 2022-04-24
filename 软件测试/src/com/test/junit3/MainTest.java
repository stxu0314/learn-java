package com.test.junit3;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testGrades(){
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(18);
        stu.setId(1005);
        stu.setScore(80);
        Method m = new Method();
        Assert.assertEquals('B', m.grades(stu.getScore()));
    }
    @Test
    public void testIsAdult(){
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(18);
        stu.setId(1005);
        stu.setScore(80);
        Method m = new Method();
        Assert.assertEquals(true, m.isAdult(stu.getAge()));
    }
    @Test
    public void testIsLength(){
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(18);
        stu.setId(1005);
        stu.setScore(80);
        Method m = new Method();
        Assert.assertEquals(true, m.isLength(stu.getId()));
    }
    @Test
    public void testScoreResult(){
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(18);
        stu.setId(1005);
        stu.setScore(80);
        Student stu1 = new Student();
        stu1.setName("李四");
        stu1.setAge(22);
        stu1.setId(1001);
        stu1.setScore(100);
        Student stu2 = new Student();
        stu2.setName("王五");
        stu2.setAge(17);
        stu2.setId(1003);
        stu2.setScore(100);
        Student stu3 = new Student();
        stu3.setName("赵六");
        stu3.setAge(21);
        stu3.setId(1002);
        stu3.setScore(80);
        Method m = new Method();
        Assert.assertEquals(360, m.scoreResult(stu,stu1,stu2,stu3));
    }

    @Test
    public void testIsQualified(){
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(18);
        stu.setId(1005);
        stu.setScore(80);
        Method m = new Method();
        Assert.assertEquals(true, m.isQualified(stu.getScore()));
    }
}
