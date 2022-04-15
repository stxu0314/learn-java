package com.test;

public class test {
    public static void main(String[] args) {
        int a = 8;
        int b = 9;
        for (int i = 0; i < a % b ; i++) {
            System.out.println("i = " + i);
        }
        if (a%b==-1){
            System.out.println(a);
        }
    }
}