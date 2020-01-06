package common;

/**
 * 一个工具类
 */
public class Utils {

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
      for(int num : nums){
          System.out.print(num + "  ");
      }
      System.out.println();
    }


}
