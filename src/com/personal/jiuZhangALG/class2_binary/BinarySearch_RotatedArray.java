package personal.jiuZhangALG.class2_binary;

/**
 * Rotated Array （螺旋数组的问题）
 * */
public class BinarySearch_RotatedArray {

    /**
     * An element in a sorted array can be found in O(log n) time via binary search.
     * But suppose we rotate an ascending order sorted array at some pivot unknown to
     * you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way
     * to find an element in the rotated array in O(log n) time.
     * 当源数组被变成了 “Rotated Array （分段？ 在分段上具有单调性？）”，将原来具有单调上升的
     * 函数，从中间某个位置这段然后头尾相接变成两段具有单调性的
     *
     * 类似于： arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
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
            } else {
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
     * 在螺旋数组（Rotated Array）找找到最小的数
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

    /**
     * 补充：
     *      如果在螺旋数组中出现了重复的数，那么以上方法就失效了，它最坏的情况时间复杂度变成了O(n)，
     *      这个时候使用的二分法也是fake的。
     *
     *  例题：
     *      假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。

            你需要找到其中最小的元素。

            数组中可能存在重复的元素。

            给出[4,4,5,6,7,0,1,2]  返回 0
     *
     *
     * */
    public int findMin2(int[] num) {
        //这道题目在面试中不会让写完整程序
        //只需要知道最坏情况下,时间复杂度为O(n)
        //因此这一个for循环就可以了
        //如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就可以写一个二分法
        //面试这道题的目的是为了考你能不能想到最坏情况

        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min)
                min = num[i];
        }
        return min;
    }

    //version 2：use  *fake* binary-search
    public int findMin2_2(int[] num) {
        if (num == null || num.length == 0){
            return -1;
        }

        int start = 0, end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == num[end]) {
                //if mid equals to end, that means it's fine to remove end
                //to smallest element won't be removed
                end--;
            } else if (num[mid] < num[end]){
                //of course you can merge == & <
                end = mid;
            } else {
                start = mid;
                // or start = mid + 1
            }
        }

        if (num[start] <= num[end]) {
            return num[start];
        }

        return num[end];
    }
}
