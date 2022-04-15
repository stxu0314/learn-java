package com.grmz.exer;

public class MyDate implements Comparable<MyDate>{

    //年
    private int year;
    //月
    private int mon;
    //ri
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int mon, int day) {
        this.year = year;
        this.mon = mon;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", mon=" + mon +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        // 比较年
        int minusYear = this.getYear() - o.getYear();
        if (minusYear !=0) {
            return minusYear;
        }
        int minusMon = this.getMon() - o.getMon();
        if (minusMon != 0) {
            return minusMon;

        }
        return this.getDay() - o.getDay();
    }
}
