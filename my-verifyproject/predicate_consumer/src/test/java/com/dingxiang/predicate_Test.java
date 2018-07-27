package com.dingxiang;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * Unit test for simple App.
 */
public class predicate_Test {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Predicate<Integer> boolValue = x -> x > 5;
        System.out.println(boolValue.test(1));//false
        System.out.println(boolValue.test(6));//true

    }
}
