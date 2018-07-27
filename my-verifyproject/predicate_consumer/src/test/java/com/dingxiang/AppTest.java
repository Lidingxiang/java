package com.dingxiang;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.CharArrayReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        UserT userT = new UserT("zm");
        //接受一个参数
        Consumer<UserT> userTConsumer = userT1 -> userT1.setName("zmChange");
        userTConsumer.accept(userT);

        System.out.println(userT.getName());

    }


    class UserT {
        public UserT(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @Test
    public void tmpTest() {

    /*    Add.init("ldx", strings -> {

            for (String tmpS : strings) {
                System.out.println("tmpTest--->addbefore--->init--->" + tmpS);
            }

            strings.add("1");
            strings.add("2");
            strings.add("3");

            for (String tmpS : strings) {
                System.out.println("tmpTest--->addafter--->init--->" + tmpS);
            }
        });*/


        Add.init("", new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {
                for (String tmpS : strings) {
                    System.out.println("tmpTest--->addbefore--->init--->" + tmpS);
                }
                strings.add("1");
                strings.add("2");
                strings.add("3");

                for (String tmpS : strings) {
                    System.out.println("tmpTest--->addafter--->init--->" + tmpS);
                }
            }
        });
    }

    static class Add {
        public static void init(String tmpKey, Consumer<List<String>> serviceListAction) {

            List<String> tmpList = new ArrayList<>();
            tmpList.add("A");
            tmpList.add("B");
            tmpList.add("C");
            serviceListAction.accept(tmpList);

            System.out.println("Add--->init--->" + Arrays.toString(tmpList.toArray()));
        }
    }

}
