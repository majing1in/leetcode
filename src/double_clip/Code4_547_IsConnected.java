package double_clip;

import java.util.ArrayList;
import java.util.List;

public class Code4_547_IsConnected {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr = {{1,0,0},{0,1,0},{0,0,1}};
        int circleNum = findCircleNum(arr);
        System.out.println(circleNum);
    }

    public static int findCircleNum(int[][] isConnected) {
        int target = 0;
        if (isConnected.length == 0) {
            return target;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    dfs(i, j, isConnected);
                    target++;
                    for (int k = 0; k < list.size() - 1; k += 2) {
                        isConnected[list.get(k)][list.get(k + 1)] = 0;
                    }
                    isConnected[i][j] = 0;
                    list = new ArrayList<>();
                }
            }
        }
        return target;
    }

    public static void dfs(int x, int y, int[][] arrs) {
        if (x == arrs.length || y == arrs[0].length) {
            return;
        }
        if (arrs[x][y] == 0) {
            return;
        }
        list.add(x);
        list.add(y);
        int i = x;
        int j = y;
        dfs(++i, j, arrs);
        dfs(x, ++y, arrs);
    }

}
