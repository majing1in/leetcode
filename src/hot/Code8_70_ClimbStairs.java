package hot;

public class Code8_70_ClimbStairs {

    public static void main(String[] args) {
        int i = climbStairs(46);
        System.out.println(i);
    }

    /**
     * 动态规划 懂的都懂
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 0, b = 0, c = 1;
        for (int i = 0; i < n - 2; i++) {
            int d = b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
