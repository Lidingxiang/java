package com.dingxiang;

public class Example {
    String str = new String("hello");
    char[] ch = {'a', 'b'};

    public static void main(String[] args) {
        Example example = new Example();
        example.change(example.str, example.ch);

        System.out.println(example.str + " and ");
        System.out.println(example.ch);
    }


    public void change(String str, char[] ch) {
        str = str + "hello world";
        ch[0] = 'c';
    }

}
