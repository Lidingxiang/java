package com.dingxiang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hashCodeTmp {

    public static void main(String[] args) {
        //Java中自带的数据类型
        System.out.println("先测试Java中自带的数据类型:");
        HashMap<String, Double> hashMap1 = new HashMap<>();
        hashMap1.put("zhangsan", 96.0);
        hashMap1.put("lisi", 88.6);
        hashMap1.put("wangwu", 98.6);
        hashMap1.put("wangting", 87.5);
        hashMap1.put("zhangsan", 96.0);
        hashMap1.put("lisi", 88.6);
        hashMap1.put("wangwu", 98.6);
        hashMap1.put("wangting", 87.5);

        Set<String> keySet = hashMap1.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + "\t" + hashMap1.get(key));
        }
        System.out.println("Java中自带的数据类型:相同的对象会覆盖！");
        System.out.println("\n");


        //用户自定义的数据类型：为重写之前
        System.out.println("测试用户自定义的数据类型--未重写两个方法之前:");
        HashMap<Student, String> hashMap2 = new HashMap<>();
        hashMap2.put(new Student("zhangsan", 88.8), "beijing");
        hashMap2.put(new Student("lisi", 88.8), "beijing");
        hashMap2.put(new Student("wangwu", 66.9), "beijing");
        hashMap2.put(new Student("zhangsan", 88.8), "beijing");
        hashMap2.put(new Student("lisi", 88.8), "beijing");
        hashMap2.put(new Student("wangwu", 66.9), "beijing");
        Set<Student> keySet2 = hashMap2.keySet();
        Iterator<Student> iterator2 = keySet2.iterator();
        while (iterator2.hasNext()) {
            Student key = iterator2.next();
            System.out.println(key + "\t" + hashMap2.get(key));
        }
        System.out.println("如果没有重写:导致相同的对象不会被覆盖!");


    }
}

class Student implements Comparable<Student> {
    public String name;
    public double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return this.name + "\t" + this.score;
    }

    public int compareTo(Student obj) {
        if (this.score > obj.score)
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (Double.compare(student.score, score) != 0) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}