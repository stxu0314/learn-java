package com.test.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PracticeTest {


    @Test
    @TestDescription("sum(1, 2) -> 3")
    public void test1() {
        Practice a = new Practice();
        Assert.assertEquals(3, a.sum(1, 2));
    }

    @Test
    @TestDescription("sum(1, 3) -> 4")
    public void test2() {
        Practice a = new Practice();
        Assert.assertEquals(4, a.sum(1, 3));
    }

    @Test
    @TestDescription("sum(2, 2) -> 4")
    public void test3() {
        Practice a = new Practice();
        Assert.assertEquals(4, a.sum(2, 2));
    }

    @Test
    @TestDescription("sum(2, 3) -> 4")
    public void test4() {
        Practice a = new Practice();
        Assert.assertEquals(4, a.sum(2, 3));
    }


}