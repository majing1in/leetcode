package hot;

/**
 * @Author Xiaoma
 * @Date 2021/3/1 0001 23:32
 * @Email 1468835254@qq.com
 */
public class Code58_202_IsHappy {

    public static void main(String[] args) {
        isHappy(19);
    }

    static boolean bln = false;

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果 可以变为 1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        dfs(n, 0);
        return bln;
    }

    public static void dfs(int n, int count) {
        // count 大于 200 直接返回 false
        if (count > 200) {
            return;
        }
        String value = String.valueOf(n);
        char[] chars = value.toCharArray();
        int sum = 0;
        // 快乐数判断
        for (int i = 0; i < chars.length; i++) {
            sum = (int) (sum + Math.pow(Integer.parseInt(String.valueOf(chars[i])), 2));
        }
        if (sum == 1) {
            bln = true;
            return;
        } else {
            dfs(sum, count);
        }
    }
}
