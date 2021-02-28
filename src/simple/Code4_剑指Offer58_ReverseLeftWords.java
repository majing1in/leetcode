package simple;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 22:57
 * @Email 1468835254@qq.com
 */
public class Code4_剑指Offer58_ReverseLeftWords {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0 || n <= 0 || n > s.length()) {
            return s;
        }
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return s2 + s1;
    }
}
