package com.mycompany.example.myapplication;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class ExampleUnitTest {
    /*
    Asserts from the core library are not really readable in many cases
     */
    @Test
    public void testWithAsserts() {
        List<String> list = someListProducingMethod();
        assertTrue(list.contains("dog"));
        assertTrue(list.contains("fox"));
        assertTrue(list.size() > 3);
        assertTrue(list.size() < 12);
    }

    /*
    testWithAsserts() can be replaced by a single call below
     */
    @Test
    public void testWithBigAssert() {
        List<String> list = someListProducingMethod();
        assertTrue(list.contains("dog") && list.contains("fox") && list.size() > 3 && list.size() < 12);
    }

    /*
    This test method testFailureWithAsserts() does not provide much information on failure but the
    same thing done with hamcrest test provides a better information on failure.
    See testFailureWithHamcrest() below.
    Note: THIS TEST WILL FAIL
     */
    @Test
    public void testFailureWithAsserts() {
        List<String> list = someListProducingMethod();
        assertTrue(list.contains("dog"));
        assertTrue(list.contains("panda"));
        assertTrue(list.size() > 3);
        assertTrue(list.size() < 12);
    }

    /*
    The following tests are done using the Hamcrest Library which are much readable
     */
    @Test
    public void testWithHamcrest() {
        List<String> list = someListProducingMethod();
        assertThat(list, (hasItems("dog", "fox")));
        assertThat(list, allOf(hasSize(greaterThan(3)), hasSize(lessThan(12))));
    }

    /*
    This method provides much insight on failure
     Note: THIS TEST WILL FAIL
     */
    @Test
    public void testFailureWithHamcrest() {
        List<String> list = someListProducingMethod();
        assertThat(list, (hasItems("dog", "panda")));
        assertThat(list, allOf(hasSize(greaterThan(3)), hasSize(lessThan(12))));
    }

    /*
    The IDE will detect errors in this method
     */
    @Test
    public void testTypeSafety() {
//        assertThat("123", equalTo(123));
//        assertThat(123, equalTo("123"));
    }


    /*
    This is not a test. This is merely a method to populate our list with strings.
     */
    private List<String> someListProducingMethod() {
        String[] sentence = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        return Arrays.asList(sentence);
    }
}
