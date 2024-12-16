package personal.spring_boot_rest_template.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListUtilsTest {
    private final ListUtils f = new ListUtils();
    @Test
    void test(){
        int[] testCase = {1,2,3};
        int expected = 6;
        assertEquals(f.findSum(testCase), expected);
    }

    @Test
    void test2(){
        int[] testCase = {};
        int expected = 0;
        assertEquals(f.findSum(testCase), expected);
    }
}
