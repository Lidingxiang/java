package com.dingxiang.refconfig;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {

        //通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));//"cn.fanshe.Student"
        //2获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));//show
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());
    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {

        Properties pro = new Properties();//获取配置文件的对象

//        String path=Student.class.getClassLoader().getResource("");;
//        String path = this.getClass().getResource("pro.txt");
//        System.out.println(path);
        FileReader in = new FileReader("/home/ldx/code2/java/my-verifyproject/reflect-demo/src/main/java/com/dingxiang/refconfig/pro.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
