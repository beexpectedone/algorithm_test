package personal.jiuZhangALG.class2_binary;


public class BinarySearch_2DMatrix {

    /**
     * 在二维数组中查询
     * @param matrix 源二维数组
     * @param target 目标元素
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length ==0) { //先做合法性校验
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length; //行的长度
        int column = matrix[0].length; //列的长度

        //find the row index, the last number <= target(先找行，看在第几行)
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {   //这里判断出在哪一行
            row = end;
        } else if (matrix[start][0] <= target){
            row = start;
        } else {
            return false;
        }

        //find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[0][mid] == target) {
                return true;
            } else if (matrix[0][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[row][start] == target){
            return true;
        } else if(matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}
