package personal.jiuZhangALG.class2_binary;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.====这里保证的是没有重复的数在这个数组中
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class BinarySearch_InsertPosition {

    public static int insertPosition(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        if (arr == null || arr.length == 0) {  //先把问题成立性的判断写上
            return -1;
        }

        while (start + 1 < end) { //极限情况保证最后循环完成后还能生下来两个数
            int mid = start + (end - start) / 2; //视频里说的，这样写获得mid逼格高一些
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[start] >= target){ /** 如果target值小于数组最小值，就满足 arr[start] > target*/
            target = start;
        } else if (arr[end] >= target){ /**如果target值大于数组最大值，就满足 arr[end] < target*/
            target = end;
        } else {
            target = end + 1;
        }
        return target;
    }
}
