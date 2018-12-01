package personal.jiuZhangALG.class2_binary;

/**
 *
 */
public class BinarySearch_BigDataArray {

    /**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public static int searchBigSortedArray(int[] A, int target) {
        int index = 1;
        if (A == null || A.length == 0){
            return -1;
        }
        while (A[index - 1] < target) { /** 这里是为了将大数组的范围确定下来，将无限的问题变成有限的问题 */
            index = index * 2;
        }
        /** 写到这里就将它转化为一个有限的数组中的二分法查找问题 */
        int start = 0, end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        }

        if (A[end] == target){
            return end;
        }
        return -1;
    }
}
