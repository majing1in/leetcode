package hot;

/**
 * @Author Xiaoma
 * @Date 2021/3/1 0001 23:27
 * @Email 1468835254@qq.com
 */
public class Code57_58_LengthOfLastWord {

    /**
     * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        // 删除两端空格
        String trim = s.trim();
        if (trim.length() == 0) {
            return 0;
        }
        String[] strings = trim.split(" ");
        // 返回最后一个单词长度
        return strings[strings.length - 1].length();
    }
}
