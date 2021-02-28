package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Code7_剑指Offer48_LengthOfLongestSubstring {

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("pwwke");
        System.out.println(length);
    }

    /**
     * 解题思路
     * map长度就是窗口长度，当 map 中已经有该元素时，将游标设置到 key + 1 位置，清空 map
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int target = 0;
        if (s.length() == 0) {
            return target;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == null) {
                map.put(chars[i], i);
            } else {
                i = map.get(chars[i]);
                map.put(chars[i], i);
            }
            if (map.keySet().size() > target) {
                target = map.keySet().size();
            }
        }
        return target;
    }
}
