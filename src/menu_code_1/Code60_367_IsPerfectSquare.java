package menu_code_1;

/**
 * @Author Xiaoma
 * @Date 2021/3/2 0002 0:14
 * @Email 1468835254@qq.com
 */
public class Code60_367_IsPerfectSquare {

    /**
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * 说明：不要使用任何内置的库函数，如 sqrt。
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        // 直接开方
        double sqrt = Math.sqrt(num);
        String[] split = String.valueOf(sqrt).split("\\.");
        char[] chars = split[1].toCharArray();
        char c = '0';
        // 若小数后面不为0的数则不是完全平方
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != c) {
                return false;
            }
        }
        return true;
    }
}
