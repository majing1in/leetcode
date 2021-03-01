package simple;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 22:29
 * @Email 1468835254@qq.com
 */
public class Code1_896_IsMonotonic {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,1,2}));
    }

    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     * 当给定的数组 A是单调数组时返回 true，否则返回 false。
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {
        boolean flag = false;
        if (A.length == 0) {
            return !flag;
        }
        int type = 0;
        // 递增递减初始化判断
        for (int i = 0; i < A.length; i++) {
            if (A[0] != A[i]) {
                type = A[0] < A[i] ? 0 : 1;
            }
        }
        int cur = 0;
        if (type == 0) {
            // 递增
            while (cur < A.length - 1) {
                if (!(A[cur] <= A[cur + 1])) {
                    flag = true;
                    break;
                }
                cur++;
            }
        } else {
            // 递减
            while (cur < A.length - 1) {
                if (!(A[cur] >= A[cur + 1])) {
                    flag = true;
                    break;
                }
                cur++;
            }
        }
        return !flag;
    }
}
