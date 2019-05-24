package common;

/**
 * 一个工具类
 */
public class Utils {

    /**
     * 直接插入排序
     * @param nums 待排序的数组
     */
    public static void insertionSort(int[] nums){
        if(nums == null || nums.length  < 2) return;
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
     * 冒泡排序
     * @param nums 待排序的数组
     * @param start 要排序的起始位置
     */
    public static void bubbSorts(int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            for(int j = start; j < nums.length - 1 - i + start; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
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

    /**
     * 打印数组
     * @param nums 要打印的数组
     */
    public static void printNums(int[] nums){
      for(int num : nums)
          System.out.print(num + "  ");
    }

}
