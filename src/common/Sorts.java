package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 各种排序算法
 */
public class Sorts {


    /**
     * O(n^2)
     * 冒泡排序
     */
    public static void bubbleSort(int[] nums){
        bubbleSort(nums, 0);
    }


    /**
     * 冒泡排序
     * @param start 要排序的起始位置
     */
    public static void bubbleSort(int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            boolean isSort = true;//冒泡排序优化，添加一个标志位，在每一趟交换中判断数组是否有序了，如果已经有序了就直接跳出循环，不用再进行后面交换判断
            for(int j = start; j < nums.length - 1 - i + start; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }

    /**
     * O(n^2)
     * 选择排序
     */
    public static void selectSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(nums, min, i);
            }
        }
    }


    /**
     * O(n^2)
     * 插入排序
     */
    public static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0 && nums[j] > temp){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    /**
     * < O(n^2)
     * 希尔排序:
     */
    public static void hillSort(int[] nums){
        int d = nums.length;
        while (d > 0){
            for(int x = 0; x < d; x++){
                for(int i = x + d; i < nums.length; i += d){
                    int j = i - d;
                    int temp = nums[i];
                    while (j >= 0 && nums[j] > temp){
                        nums[j + d] = nums[j];
                        j -= d;
                    }
                    nums[j + d] = temp;
                }
            }
            //希尔增量，每次折半
            d /= 2;
        }

    }

    /**
     * O（longn）
     * 快速排序
     */
    public static void quickSort(int[] nums){
        if(nums.length < 2) return;
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序的处理过程
     * @param nums 待排序的数组
     * @param left 子数组在数组中的左边界
     * @param right 数组在数组中的右边界
     */
    private static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;

        //快速排序优化1：不使用lomuto划分算法，改用两路划分算法又称Hoare划分算法
        //避免当重复元素很多时，导致重复元素都会被划分到一边
        int pivot = hoarePartition(nums, left, right);

        //递归排序[left, pivot - 1]
        quickSort(nums, left, pivot - 1);

        //从递归排序[pivot + 1, right]
        quickSort(nums, pivot + 1, right);
    }

    /**
     * hoare划分算法：用第一个元素(key)为中轴从子数组的两端开始划分
     * 优点：改进lomuto划分算法，当(元素=key时)也会进行交换，使得划分更加均匀
     * @param nums 要进行划分的数组
     * @param left 子数组在数组中的左边界
     * @param right 子数组在数组中的右边界
     * @return 子数组的中值的位置
     */
    private static int hoarePartition(int[] nums, int left, int right){
        //快速排序优化2：不每次选取最左边的值作为pivot，改为随机选取一个
        //避免当最左边选取的pivot很大或很小时导致划分不平衡, 时间复杂度退化为O(n^2)
        //swap(nums, (int) (Math.random() * (right - left ) + 1), left);
        int pivot = nums[left];
        int i = left; //i指向 <=pivot 的数
        int j = right;//j指向 >pivot 的数
        while (i < j){
            //从右边边开始找，找到第一个 <=pivot 的元素下标j，跳出循环
            while (i < j && nums[j] > pivot){
                j--;
            }
            //从左边开始找，找到第一个 >pivot 的元素下标i，跳出循环
            while (i < j && nums[i] <= pivot){
                i++;
            }
            if(i < j){
                //交换这两个
                swap(nums, i, j);
            }
        }
        //交换i和pivot位置的元素， 此时nums[i]是 <=pivot 的值
        swap(nums, left, i);
        return i;
    }


    /**
     * lomuto划分算法：用第一个元素作为中轴对子数组从左到右进行划分
     * 缺点： 当数组中的重复元素很多时（>= pivot），会导致划分不均匀，重复元素都会被划分到一边
     * @param nums 要进行划分的数组
     * @param left 子数组在数组中的左边界
     * @param right 子数组在数组中的右边界
     * @return 子数组的中值的位置
     */
    private static int lomutoPartition(int[] nums, int left, int right){
        int pivot = nums[left];
        int j = left;//j指向 <= pivot的数
        for(int i = left + 1; i <= right; i++){
            if(nums[i] < pivot){//从左边开始找，只要比pivot小，就交换
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    /**
     * O(nlogn)
     * 归并排序
     */
    public static void mergeSort(int[] nums){
        if(nums.length < 2) return;
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序的处理过程
     * @param nums 待排序的数组
     * @param left 子数组在数组中的左边界
     * @param right 数组在数组中的右边界
     */
    private static void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;

        //取中点
        int mid = left + (right - left) / 2;

        //分治[left, mid]
        mergeSort(nums, left, mid);

        //分治[mid + 1, right]
        mergeSort(nums, mid + 1, right);

        //合并
        merge(nums, left, mid, right);
    }

    /**
     * 归并
     * @param nums 排序数组
     * @param left 归并的起始位置
     * @param mid 归并的中间位置
     * @param right 归并的结束位置
     */
    private static void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[nums.length];
        //把待排序的子数组复制到另外一个数组
        for(int i = left; i <= right; i++){
            temp[i] = nums[i];
        }
        //确定边界
        int start1 = left, start2 = mid + 1;
        int end1 = mid, end2 = right;

        //i的起始为left
        int i = left;
        //开始归并
        while (start1 <= end1 && start2 <= end2){
            if(temp[start1] < temp[start2]){
                nums[i++] = temp[start1++];
            }else{
                nums[i++] = temp[start2++];
            }
        }
        //把剩余的子数组复制到nums中
        while (start1 <= end1){
            nums[i++] = temp[start1++];
        }
        while (start2 <= end2){
            nums[i++] = temp[start2++];
        }
    }


    /**
     * O(n)
     * 计数排序
     */
    public static void countSort(int[] nums){
        if(nums.length == 0) return;
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int d = max - min;//处理极端情况，防止nums中大部分元素都大时创建计数数组会浪费空间，所以使用每个元素与最小值的偏移量来代表该元素统计该元素在nums中的出现次数
        int[] counts = new int[d + 1];
        //counts数组中的值代表下标值在nums中出现的次数
        for(int i = 0; i < nums.length; i++){
            counts[nums[i] - min]++;
        }
        //按照每个元素的出现次数输出，出现多少次就输出多少次
        int index = 0;
        for(int i = 0; i < counts.length; i++){
            while (counts[i]-- > 0){
                nums[index++] = i;
            }
        }
    }

    /**
     * O(n)
     * 稳定的计数排序
     */
    public static void countSort2(int[] nums){
        if(nums.length == 0) return;
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int d = max - min;
        int[] counts = new int[d + 1];
        for(int i = 0; i < nums.length; i++){
            counts[nums[i] - min]++;
        }
        //从第二位开始，每一位累加前一位的数值，这时counts数组中的值代表下标值在排序数组中的位置
        for(int i = 1; i < counts.length; i++){
            counts[i] += counts[i - 1];
        }
        //新建一个存放排序后元素的数组
        int[] sorts = new int[nums.length];
        //从后往前遍历nums，把nums的每个元素依此放入相应的位置
        for(int i = nums.length - 1; i >= 0; i--){
            sorts[counts[nums[i] - min] - 1] = nums[i];
            counts[nums[i] - min]--;
        }
        for(int i = 0; i < sorts.length; i++){
            nums[i] = sorts[i];
        }
    }

    /**
     * O(n)(在桶数量为n的前提下)
     * 桶排序
     */
    public static void bucketSort(int[] nums){
        if(nums.length == 0) return;
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int d = max - min;
        //确定桶的长度为数组的长度
        int bucketNum = nums.length;
        List<ArrayList<Integer>> buckets = new ArrayList<>(bucketNum);
        //初始化每个桶
        for(int i = 0; i < bucketNum; i++){
            buckets.add(new ArrayList<>());
        }
        //遍历原始数组，将每个元素放入相应的桶中
        for(int i = 0; i < nums.length; i++){
            int bucketIndex = ((nums[i] - min) / d) * (bucketNum - 1);
            buckets.get(bucketIndex).add(nums[i]);
        }
        //遍历每个桶，分别对桶中的元素进行排序
        for(int i = 0; i < bucketNum; i++){
            Collections.sort(buckets.get(i));
        }
        int index = 0;
        //把每个桶中的元素依此输出到数组中
        for(List<Integer> bucket : buckets){
            for(Integer num : bucket){
                nums[index++] = num;
            }
        }
    }


    /**
     * 交换数组中的两个元素
     * @param nums 原数组
     * @param i 待交换的下标i
     * @param j 待交换的下标j
     */
    public static void swap(int[] nums, int i, int j) {
        if(i < 0 || j > nums.length - 1) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
