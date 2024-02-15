package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    private WordCount wordCountTest = new WordCount();

    Map<String, Integer> expected = new HashMap<String, Integer>();

    @Test
    public void getCount_should_return_c_1_b_1_a_1() {

        String[] testArray = new String[]{"c", "b", "a"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("c", 1);
        expected.put("b", 1);
        expected.put("a", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_ba_2_black_1_sheep_1() {

        String[] testArray = new String[]{"ba", "ba", "black", "sheep"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_a_3_b_3_c_3() {

        String[] testArray = new String[]{"a", "b", "c", "a", "b", "c", "a", "b", "c"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("a", 3);
        expected.put("b", 3);
        expected.put("c", 3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_empty_Map_when_empty_string_array_is_passed() {

        String[] testArray = new String[]{};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_emptyMap_when_null_is_passed() {

        String[] testArray = null;
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_should_return_123_1_456_2_789_3() {

        String[] testArray = new String[]{"123", "456", "456", "789", "789", "789"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("123", 1);
        expected.put("456", 2);
        expected.put("789", 3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount_special_characters() {

        String[] testArray = new String[]{"^$&", "<>?%>", "*!@#", "^$&", "*!@#", "*!@#"};
        Map<String, Integer> actual = wordCountTest.getCount(testArray);

        expected.put("*!@#", 3);
        expected.put("^$&", 2);
        expected.put("<>?%>", 1);

        Assert.assertEquals(expected, actual);
    }


}
