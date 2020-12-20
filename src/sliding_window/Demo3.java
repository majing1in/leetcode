package sliding_window;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: 马同学
 * @Date: 2020/12/20 0020 22:35
 * 1004. 最大连续1的个数 III
 */
public class Demo3 {

    public static void main(String[] args) {
        int longestOnes = longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0);
        System.out.println(longestOnes);
    }


    public static int longestOnes(int[] A, int K) {
        int target = 0;
        if (A.length == 0) {
            return target;
        }
        int index = 0;
        int loc = index;
        int val = 0;
        int fre = K;
        while (index < A.length) {
            if (A[index] == 1) {
                val++;
            } else {
                if (fre > 0) {
                    val++;
                    fre--;
                    if (target < val) {
                        target = val;
                    }
                } else {
                    index = ++loc;
                    val = 0;
                    fre = K;
                    continue;
                }
            }
            if (target < val) {
                target = val;
            }
            index++;
        }
        return target;
    }

    /**
     * 超出时间限制
     *
     * @param A
     * @param K
     * @return
     */
    public static int longestOnesFailed(int[] A, int K) {
        int target = 0;
        if (A.length == 0) {
            return target;
        }
        int index = 0;
        while (index < A.length) {
            int temp = index;
            int val = 0;
            int isOver = K;
            while (temp < A.length) {
                if (A[temp] == 1) {
                    val++;
                } else {
                    if (isOver > 0) {
                        val++;
                        isOver--;
                    } else {
                        break;
                    }
                }
                temp++;
            }
            if (val > target) {
                target = val;
            }
            index++;
        }
        return target;
    }

}
