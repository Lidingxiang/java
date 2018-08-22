package com.dingxiang;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {


        ArrayList<Student1> arr = new ArrayList<Student1>();
        arr.add(new Student1("zhangsan", 89.8));
        arr.add(new Student1("lisi", 90));
        arr.add(new Student1("wangwu", 60.6));
        arr.add(new Student1("wangting", 85.6));

        Collections.sort(arr);

        for (Student1 student : arr) {
            System.out.println(student);
            System.out.println(student.getName());

            System.out.println();
        }
    }

}

class Student1 implements Comparable<Student1> {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private String name;
    private double score;

    public Student1(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return this.name + "\t" + this.score;
    }

    public int compareTo(Student1 obj) {
        return (int) (this.score - obj.score);//比较的标准为score进行升序
    }
}
