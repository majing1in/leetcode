package menu_code_2;

public class Code4_SearchMatrix_SearchMatrix {

    /**
     * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            // 判断目标值所属哪一行
            if (matrix[0][i] > target) {
                continue;
            }
            // 搜索当前行对应的列
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
