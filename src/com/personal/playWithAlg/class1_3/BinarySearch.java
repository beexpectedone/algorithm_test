package personal.playWithAlg.class1_3;


/**
 * 二分法算法
 * 前提： 被查找的数据源（数组）要是一个排好序的数组，否则无法查询
 * 方法： 一种使用递归方法，一种使用while循环方法
 *
 * 感悟：
 *
 */
public class BinarySearch {

    /**
     * 使用递归的二分法查找：
     * @param arr  被查询的数组
     * @param key  要查找的关键值
     * @param low  数组最低位的值
     * @param high 数组最高位的值
     * @return 返回值为角标
     */
    public static int binarySearchByRecursion(int[] arr, int key, int low, int high) {
        //处理特殊情况
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1; //如果所要查找的元素大于数组的最大值或者小于数组的最小值异或数组最小值大于最大值就退出
        }

        int middle = (low + high) / 2; //去数组的中间值
        if (arr[middle] > key) { /** 如果数组的中间值比key值大，就说明key可能在左侧树中 */
            return binarySearchByRecursion(arr, key, low, middle - 1);
        } else if ((arr[middle] < key)) { /** 如果数组的中间值比key值小，就说明key可能在右侧树中 */
            return binarySearchByRecursion(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }

    /**
     *
     * @param arr 传入的数据源数组
     * @param key 传入的要查询的值
     * @return 返回值为角标
     */
    public static int binarySearchWithoutRecursion(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle;
        if (key < arr[low] || key > arr[high] || arr[low] > arr[high]) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key){
                low = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 二分法的变种问题-----Last Position of Target(取角标最后出现的位置)
     * 找最后出现的位置时，就要让角标向高位移动
     *
     * @param nums an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0; int end = nums.length - 1;

        //区间范围缩小
        /** 最终保留两个角标 */
        while (start + 1 < end) {
            int mid= start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        //肉眼可结
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }

        return -1;
    }

    public int firstPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end -start);
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

}
