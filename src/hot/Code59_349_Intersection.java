package hot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author Xiaoma
 * @Date 2021/3/2 0002 0:02
 * @Email 1468835254@qq.com
 */
public class Code59_349_Intersection {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // set 去除重复元素
        Set<Integer> set = new HashSet<>();
        // 相同元素装入集合
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }
        int[] ints = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int cur = 0;
        while (iterator.hasNext()) {
            ints[cur] = iterator.next();
            cur++;
        }
        return ints;
    }
}
