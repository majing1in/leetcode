package hot;

import java.util.ArrayList;
import java.util.List;

public class Code15_279_NumSquares {

    public static void main(String[] args) {
        int i = numSquares(13);
        System.out.println(i);
    }

    static List<Integer> list = new ArrayList<>();

    public static int numSquares(int n) {
        int result = 0;
        if (n <= 0) {
            return result;
        }
        dfs(n, n, list);
        return list.size();
    }

    public static void dfs(int n,int m, List<Integer> list){

    }

}
