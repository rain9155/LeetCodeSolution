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
     * 冒泡排序
     * @param nums 待排序的数组
     * @param start 要排序的起始位置
     */
    public static void bubbSorts(int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            for(int j = start; j < nums.length - 1 - i + start; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }

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
     * 快速排序
     * @param nums 待排序的数组
     */
    public static void quickSort(int[] nums){
        if(nums == null || nums.length < 2) return;
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
        //快速排序优化1：不每次选取最左边的值作为key，改为随机选取一个（避免当最左边选取的key很大或很小时导致划分不平衡）
        //swap(nums, left,left + (int)(Math.random() * (right - left + 1))); //随机选取一个pivot
        //快速排序优化2：不使用lomuto划分算法，改用两路划分算法又称Hoare划分算法（避免当重复元素很多时，导致重复元素都会被划分到一边）
        int pivot = hoarePartition(nums, left, right);
        //int pivot = lomutoPartition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /**
     * lomuto划分算法：用第一个元素作为中轴（key）对子数组从左到右进行划分
     * 缺点： 当数组中的重复元素很多时（>= key），会导致划分不均匀，重复元素都会被划分到一边
     * @param nums 要进行划分的数组
     * @param left 子数组在数组中的左边界
     * @param right 子数组在数组中的右边界
     * @return 子数组的中值的位置
     */
    private static int lomutoPartition(int[] nums, int left, int right){
        int key = nums[left];
        int pivot = left;
        for(int i = left + 1; i <= right; i++){
            if(nums[i] < key){//从左边开始找，只要比key小，就交换
                pivot++;
                swap(nums, i, pivot);
            }
        }
        swap(nums, pivot, left);
        return pivot;
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
        int key = nums[left];
        int i = left;
        int j = right + 1;
        while (i < j){
            //从左边开始找，找到第一个 >=key 的元素下标i，跳出循环
            do{
                i++;
            }while (i < right && nums[i] < key);
            //从右边边开始找，找到第一个 <=key 的元素下标j，跳出循环
            do {
                j--;
            }while ( nums[j] > key);
            //交换这两个
            swap(nums, i, j);
        }
        swap(nums, i, j);//撤销最后一次交换
        if(nums[left] > nums[j]) //防止只有两个元素时且nums[left] < nums[j],这个情况不能交换
            swap(nums, left, j);//交换j和left， 此时j就是中值
        return j;
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

    /**
     * 打印数组
     * @param nums 要打印的数组
     */
    public static void printNums(int[] nums){
      for(int num : nums)
          System.out.print(num + "  ");
        System.out.println();

    }


}
