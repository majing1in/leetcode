package sliding_window;

/**
 * 978. 最长湍流子数组
 * 执行用时: 4 ms
 * 内存消耗: 41.5 MB
 */
public class Code10_978_MaxTurbulenceSize {

    // 9,4,2,10,7,8,8,1,9
    public static void main(String[] args) {
        int maxTurbulenceSize = maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        System.out.println(maxTurbulenceSize);
    }

    /**
     * 解题思路
     * 0 代表下次为 >
     * 1 代理下次为 <
     * 其他的没有了
     * @param arr
     * @return
     */
    public static int maxTurbulenceSize(int[] arr) {
        int target = 0;
        if (arr.length == 0) {
            return target;
        }
        int len = -1;
        int sum = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (len == -1) {
                if (arr[i] > arr[i + 1]) {
                    len = 1;
                    sum++;
                } else if (arr[i] < arr[i + 1]){
                    len = 0;
                    sum++;
                }
            } else {
                if (len != 1) {
                    if (arr[i] > arr[i + 1]) {
                        len = 1;
                        sum++;
                        continue;
                    }
                    target = target < sum ? sum : target;
                    i = i - 1;
                    sum = 1;
                    len = -1;
                } else {
                    if (arr[i] < arr[i + 1]) {
                        len = 0;
                        sum++;
                        continue;
                    }
                    target = target < sum ? sum : target;
                    i = i - 1;
                    sum = 1;
                    len = -1;
                }
            }
        }
        return target < sum ? sum : target;
    }
}
