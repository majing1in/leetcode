package menu_code_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 */
public class Code1_1297_MaxFreq {

    /**
     * 给你一个字符串s ，请你返回满足以下条件且出现次数最大的任意子串的出现次数：
     * 子串中不同字母的数目必须小于等于 maxLetters 。
     * 子串的长度必须大于等于minSize 且小于等于maxSize 。
     * @param s
     * @param maxLetters
     * @param minSize
     * @param maxSize
     * @return
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int result = 0;
        char[] chars = s.toCharArray();
        // key 为符合条件的字符串，value 为当前字符串所出现的次数
        Map<String, Integer> map = new HashMap<>();
        // 固定长度滑动窗口，当字符串满足minSize时maxSize一定满足
        for (int i = 0; i <= chars.length - minSize; i++) {
            if (count(chars, i, i + minSize - 1) <= maxLetters) {
                String key = String.valueOf(chars, i, minSize);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        // 获取最大的值
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result = Math.max(result, entry.getValue());
        }
        return result;
    }

    // 对窗口中的元素进行统计
    public int count(char[] chars, int start, int minSize) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= minSize; i++) {
            set.add(chars[i]);
        }
        return set.size();
    }
}
