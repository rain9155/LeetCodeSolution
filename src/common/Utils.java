package common;

/**
 * 一个工具类
 */
public class Utils {

    /**
     * 直接插入排序
     * @param nums 待排序的数组
     */
    public static void sort(int[] nums){
        if(nums == null || nums.length  == 0) return;
        for(int i = 1; i < nums.length; i++){
            int j = i - 1;
            int v = nums[i];
            while (j >= 0 && nums[j] > v){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = v;
        }
    }

    /**
     * 二分查找法
     * @param nums 有序数组
     * @param target 要查找的值
     * @return 如果找到返回target在nums中的索引，否则返回-1
     */
    public static int binarySearch(int[] nums, int target){
        if(nums == null) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int middle = (start + end) / 2;
            if(target == nums[middle]){
                return middle;
            }else if(target < nums[middle]){
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }
        return -1;
    }

}
