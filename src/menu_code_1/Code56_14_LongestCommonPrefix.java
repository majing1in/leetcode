package menu_code_1;

/**
 * @Author Xiaoma
 * @Date 2021/3/1 0001 23:09
 * @Email 1468835254@qq.com
 */
public class Code56_14_LongestCommonPrefix {

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 0) {
            return result.toString();
        }
        // 使用第一个元素初始化长度
        int len = strs[0].length();
        // 最短长度
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }
        // 以最短长度检测
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            char c = strs[0].charAt(i);
            // 各个字符串各个字符对照
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.append(String.valueOf(c));
            } else {
                break;
            }
        }
        return result.toString();
    }
}
