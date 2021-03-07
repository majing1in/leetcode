package demo;


import java.util.Scanner;

/**
 * @Author Xiaoma
 * @Date 2021/3/6 0006 15:48
 * @Email 1468835254@qq.com
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if (str.length() == 0) {
            return;
        }
        String[] strings = str.split(",");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (Integer.parseInt(strings[i].substring(0, 1)) > Integer.parseInt(strings[j].substring(0, 1))) {
                    String t = strings[i];
                    strings[i] = strings[j];
                    strings[j] = t;
                }
                if (Integer.parseInt(strings[i].substring(0, 1)) == Integer.parseInt(strings[j].substring(0, 1))) {
                    int len = Math.min(strings[i].length(), strings[j].length());
                    for (int k = 1; k < len; k++) {
                        if (Integer.parseInt(strings[i].substring(k, k + 1)) > Integer.parseInt(strings[j].substring(k, k + 1))) {
                            String t = strings[i];
                            strings[i] = strings[j];
                            strings[j] = t;
                            break;
                        }
                    }
                    if (strings[i].length() != strings[j].length()) {
                        int i1 = Integer.parseInt(strings[i].substring(strings[i].length() - 1));
                        int i2 = Integer.parseInt(strings[j].substring(strings[j].length() - 1));
                        if (i1 > i2) {
                            String t = strings[i];
                            strings[i] = strings[j];
                            strings[j] = t;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = strings.length - 1; i >= 0; i--) {
            builder.append(strings[i]);
        }
        System.out.println(builder.toString());
    }


}
