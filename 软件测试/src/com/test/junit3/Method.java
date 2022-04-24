package com.test.junit3;


public class Method {
    //判断学生成绩等级
    public char grades(int score){
        if (0 <= score && score < 60) {
            return 'E';
        }else if (score >= 60 && score < 70) {
            return 'D';
        }else if (score >= 70 && score < 80) {
            return 'C';
        }else if (score >= 80 && score < 90) {
            return 'B';
        }else if (score >= 90 && score <= 100) {
            return 'A';
        }else {
            return ' ';
        }
    }

    //判断学生是否成年
    public boolean isAdult(int age){
        if (age < 18) {
            return false;
        }else{
            return true;
        }
    }
    //判断学生学号是否合规(1001-9999)
    public boolean isLength(int id){
        if (id > 1000 && id < 9999) {
            return true;
        }
        else {
            return false;
        }
    }

    //计算多个学生总成绩
    public int scoreResult(Student... stu){
        int result = 0;
        for (int i = 0; i < stu.length; i++) {
            result += stu[i].getScore();
        }
        return result;
    }
    //判断成绩是否合格
    public boolean isQualified(int score){
        if (score >= 60 ) {
            return true;
        }else {
            return false;
        }
    }
}
