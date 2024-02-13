package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    private WordCount wordCountTest = new WordCount();

    Map<String, Integer> expected = new HashMap<String, Integer>();

    @Test
    public void getCount_should_return_two_ba() {

        String[] testArray = new String[]{"ba", "ba", "black", "sheep"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_two_a_and_two_b() {

        String[] testArray = new String[]{"a", "b", "a", "c", "b"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_empty_string_given_empty_string() {

        String[] testArray = new String[]{};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void count_should_return_one_for_each() {

        String[] testArray = new String[]{"c", "b", "a"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("a", 1);
        expected.put("b", 1);
        expected.put("c", 1);

        Assert.assertEquals(expected, actual);
    }

}
