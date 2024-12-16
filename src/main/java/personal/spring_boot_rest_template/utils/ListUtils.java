package personal.spring_boot_rest_template.utils;

public class ListUtils {
    public int findSum(int[] list) {
        int result = 0;
        for (Integer i : list) {
            result += i;
        }
        return result;
    }
}
