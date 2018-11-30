package personal.jiuZhangALG.class2_binary;


/**
 * Description
 * There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peak if:
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak
 *
 * Example
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 *
 * Return index 1 (which is number 2) or 6 (which is number 7)
 *
 * 分析思路：
 *      1.题意中的 A[0] < A[1] && A[A.length - 2] > A[A.length - 1].表名这个数组一定是先上升在下降的
 *      2.把二分所有取到的可能性找出来
 *          a. 波谷
 *          b. 波峰
 *          c. 上升区间（找右侧）
 *          d. 下降区间（找左侧）
 *      3.最终简化成两种情况
 *          a.上升区间 + 峰 （找右侧）
 *          b.下降区间 + 谷 （找左侧）
 *
 */
public class BinarySearch_findPeak {

    public static int findPeak(int[] A) {

        int start = 1, end = A.length - 2; //1.答案在之间 2.不会出界
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid - 1]) { //和左侧比较,如果小于左侧说明是在 下降区间上
                end = mid;
            } else if (A[mid] < A[mid + 1]) { // 和右侧比较 如果小于右侧说明是在上升区间上
                start = mid;
            } else {
                end = mid;  /** 这种情况出现的时候表示mid 即不小于mid - 1， 也不小于mid + 1 差不多是一个峰值了 */
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    public static int findPeak2(int[] A) {
        int start = 0, end = A.length - 2; //end位置的选择是为了保证数组不越界
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid +1]) {
                start = mid;
            } else {
                end = mid;  //
            }
        }

        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}

/**
 *  * 感悟：
 *          这里使用二分法最重要的注意点是最终
 *  *       将区间定位在一个单调性区间上，最后一直循环
 *  *       直到只剩下两个元素位置
* */
