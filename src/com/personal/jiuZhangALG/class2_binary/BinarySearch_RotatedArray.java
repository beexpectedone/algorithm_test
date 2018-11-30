package personal.jiuZhangALG.class2_binary;

/**
 * Rotated Array （螺旋数组的问题）
 * */
public class BinarySearch_RotatedArray {

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     * 当源数组被变成了 “Rotated Array （分段？ 在分段上具有单调性？）”，将原来具有单调上升的
     * 函数，从中间某个位置这段然后头尾相接变成两段具有单调性的
     *
     * 类似于： For [4, 5, 1, 2, 3] and target=1, return 2.
     *          For [4, 5, 1, 2, 3] and target=0, return -1.
     *          Challenge
     *          O(logN) time
     *
     * 感悟：
     *         1.这里给了target值
     *         2.这里的核心是定位target位置，先将去单调区间确定下来。
     *         3.即先把二分查找的区间定位到一个区间上
     */
    public static int search(int[] A, int target) {
        if (A == null || A.length == 0){ //每一种解法都必要的判断问题成立性的条件
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;/** 把 mid 的赋值情况写成这样的样式 */
            if (A[mid] == target) {  //每个函数中还是需要包含的需要处理的特殊情况，当 mid == target的时候
                return mid;
            }
            if (A[start] <= A[mid]){  // 比较 mid 和 start 两者的大小，看选择的mid是在那个分段还是上
                if (A[start] <= target && target <= A[mid]) {
                    /** 如果满足这个条件说明target落在前一段具有单调性的部分 */
                    end = mid;
                } else {
                    start = mid;
                }
            } else { //如果 A[mid] > A[start] ,此时两个分支上都有取到的数
                if (target <= A[end] && A[mid] <= target) {
                    /** 如果满足该条件说明target落在后一段具有单调性的部分 */
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }


    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     *
     * 在螺旋数组（Rotated Array）找到最小的数
     *
     * */
    public int findMin(int[] nums) {
       if (nums == null || nums.length == 0){ //每一种解法都必要的判断问题成立性的条件
           return -1;
       }

       int start = 0, end = nums.length - 1;
       int target = nums[nums.length - 1];/** 这里注意不能写成nums[end] ,因为 end 是一直在变的*/

       //find the first element <= target
        while (start + 1 < end) { /** 这种写法会保证循环到最后会剩下两个元素 */
            int mid = end + (end - start) / 2;
            if (nums[mid] <= target) { //如果mid的值小于target，那么说明是在target这一分段上
                end = mid;
            } else { //如果mid的值大于end，则说明是另外一个分段上
                start = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start]; //说明此时是在target的分段上
        } else {
            return nums[end]; //说明此时end是落在target分段上，而start还是在另外一个分段上
        }
    }
}
