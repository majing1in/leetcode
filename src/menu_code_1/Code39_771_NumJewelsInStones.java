package menu_code_1;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 23:21
 * @Email 1468835254@qq.com
 */
public class Code39_771_NumJewelsInStones {

    /**
     * 给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        if (jewels.length() == 0 || stones.length() == 0) {
            return result;
        }
        char[] chars = stones.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (jewels.contains(String.valueOf(chars[i]))) {
                result++;
            }
        }
        return result;
    }
}
