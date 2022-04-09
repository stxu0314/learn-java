package com.grmz.map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    //properties:常用来处理配置文件;key和value都是String类型
    @Test
    public void test() {
        FileInputStream files=null;
        try {
            Properties pros = new Properties();
            files = new FileInputStream("jdbc.properties");
            pros.load(files);
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name:"+name+"---"+password);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if (files!=null){
               try {
                   files.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

    }

}
