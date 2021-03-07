package demo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Xiaoma
 * @Date 2021/3/6 0006 17:35
 * @Email 1468835254@qq.com
 */
public class Demo2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.next();
        if (target.length() == 0 || !target.contains(",")) {
            System.out.println(target);
            return;
        }
        char[] chars = target.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ',') {
                if (characters.size() == 0) {
                    characters.add('/');
                    continue;
                }
                if (characters.get(characters.size() - 1) == '/' && i + 1 < chars.length && chars[i + 1] == '/') {
                    characters.remove(characters.size() - 1);
                } else if (characters.get(characters.size() - 1) != '/' && i + 1 < chars.length && chars[i + 1] != '/') {
                    characters.add('/');
                }
                continue;
            }
            characters.add(chars[i]);
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : characters) {
            builder.append(character);
        }
        System.out.println(builder.toString());
    }
}
