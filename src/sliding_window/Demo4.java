package sliding_window;

/**
 * 1052. 爱生气的书店老板
 *
 * @Author: 马同学
 * @Date: 2020/12/20 0020 23:20
 */
public class Demo4 {

    public static void main(String[] args) {
        int maxSatisfied = maxSatisfied(new int[]{4,10,10},
                new int[]{1,1,0}, 2);
        System.out.println(maxSatisfied);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int target = 0;
        if (customers.length == 0 || grumpy.length == 0) {
            return target;
        }
        int index = 0;
        int val = 0;
        int tem = 0;
        int vtx = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                val = val + customers[i];
            }
        }
        while (index + X <= grumpy.length) {
            for (int i = index; i < index + X; i++) {
                if (grumpy[i] == 1) {
                    tem = tem + customers[i];
                }
            }
            if (tem > vtx) {
                vtx = tem;
            }
            tem = 0;
            index++;
        }
        target = vtx + val;
        return target;
    }

    /**
     * 超出时间限制
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static int maxSatisfied02(int[] customers, int[] grumpy, int X) {
        int target = 0;
        if (customers.length == 0 || grumpy.length == 0) {
            return target;
        }
        int index = 0;
        int val = 0;
        int temp = 0;
        while (index + X <= grumpy.length) {
            for (int i = index; i < grumpy.length; i++) {
                if (i >= index + X) {
                    if (grumpy[i] == 0) {
                        val = val + customers[i];
                    }
                    continue;
                }
                val = val + customers[i];
            }
            if (target < val + temp) {
                target = val + temp;
            }
            if (grumpy[index] == 0) {
                temp = customers[index] + temp;
            }
            val = 0;
            index++;
        }
        return target;
    }

    /**
     * 超出时间限制
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static int maxSatisfied01(int[] customers, int[] grumpy, int X) {
        int target = 0;
        if (customers.length == 0 || grumpy.length == 0) {
            return target;
        }
        int index = 0;
        int val = 0;
        while (index + X <= grumpy.length) {
            for (int i = 0; i < grumpy.length; i++) {
                if (i < index || i >= index + X) {
                    if (grumpy[i] == 0) {
                        val = val + customers[i];
                    }
                    continue;
                }
                val = val + customers[i];
            }
            if (target < val) {
                target = val;
            }
            val = 0;
            index++;
        }
        return target;
    }
}