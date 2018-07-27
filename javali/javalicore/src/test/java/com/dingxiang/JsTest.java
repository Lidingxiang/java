package com.dingxiang;


import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsTest {
    @Test
    public void getRandomTmp() {

        /*String test = "123Java456Java789Java";
        Pattern pattern = Pattern.compile("Java");

        String[] result1 = pattern.split(test);
        System.out.println(Arrays.toString(result1));


        String[] result = pattern.split(test,3);
        System.out.println(Arrays.toString(result));*/


        /*Pattern pattern = Pattern.compile("^Java.*");
        String test1 = "Java";
        String test3 = "Java1234";
        String test2 = "1234Java";

        Matcher matcher1 = pattern.matcher(test1);
        boolean matcherRet1 = matcher1.matches();
        System.out.println(matcherRet1);//返回true
        System.out.println(matcher1.groupCount());


        Matcher matcher3 = pattern.matcher(test3);
        boolean matcherRet3 = matcher3.matches();
        System.out.println(matcherRet3);//返回true
        System.out.println(matcher3.groupCount());

        Matcher matcher2 = pattern.matcher(test2);
        boolean matcherRet2 = matcher2.matches();
        System.out.println(matcherRet2);//返回true*/

        /*Pattern pattern = Pattern.compile("(Java)(Python)");
        String test = "123Java333Python456Java444";
        Matcher matcher = pattern.matcher(test);
        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());//返回2*/

        String text = "Cicada.Rpc.Client.Endpoints.2.Contract";

        String regEx = "^Cicada.Rpc.Client.Endpoints.(\\w+).([\\w.]+)$";
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        /*Cicada.Rpc.Client.Endpoints.2.ServiceCentre.RespositoryServer
        Cicada.Rpc.Client.Endpoints.2.ServiceFinderType
        Cicada.Rpc.Client.Endpoints.2.Contract
        Cicada.Rpc.Client.Endpoints.2.ServiceCentre.Name*/

        System.out.println(matcher.matches());
        System.out.println(matcher.groupCount());

        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));


    }
}
