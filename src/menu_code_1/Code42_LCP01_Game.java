package menu_code_1;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 23:49
 * @Email 1468835254@qq.com
 */
public class Code42_LCP01_Game {

    /**
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int result = 0;
        if (guess.length == 0 || answer.length == 0) {
            return result;
        }
        int len = Math.max(guess.length, answer.length);
        for (int i = 0; i < len; i++) {
            if (guess[i] == answer[i]) {
                result++;
            }
        }
        return result;
    }
}
