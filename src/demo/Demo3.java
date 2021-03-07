package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Xiaoma
 * @Date 2021/3/6 0006 18:01
 * @Email 1468835254@qq.com
 */
public class Demo3 {

    static List<List<Character>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        String source = in.next();
        char[] chars = target.toCharArray();
        boolean[] booleans = new boolean[chars.length];
        int len = target.length() - Integer.parseInt(source);
        dfs(chars, booleans, new ArrayList<>(), len, 0);
        System.out.println(lists);
        for (int i = 0; i < lists.size() - 1; i++) {
            List<Character> outter = lists.get(i);
            for (int j = i + 1; j < lists.size(); j++) {
                List<Character> inner = lists.get(j);
                for (int k = 0; k < len; k++) {
                    if (Integer.parseInt(String.valueOf(outter.get(k))) > Integer.parseInt(String.valueOf(inner.get(k)))) {
                        lists.set(i, inner);
                        lists.set(j, outter);
                        outter = lists.get(i);
                        break;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lists.get(0).size(); i++) {
            stringBuilder.append(lists.get(0).get(i));
        }
        System.out.println(stringBuilder.toString());
    }

    public static void dfs(char[] chars, boolean[] booleans, List<Character> list, int len, int cur) {
        if (list.size() == len) {
            ArrayList<Character> cls = new ArrayList<>(list);
            lists.add(cls);
            return;
        }
        for (int i = cur; i < chars.length; i++) {
            if (!booleans[i]) {
                booleans[i] = true;
                list.add(chars[i]);
                dfs(chars, booleans, list, len, cur + 1);
                booleans[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
