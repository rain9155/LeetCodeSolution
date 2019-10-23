package medium.leetcode376;

/**
 * 摆动序列:
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。
 * 少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 * 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
 * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 *
 * 进阶:
 * 你能否用 O(n) 时间复杂度完成此题?
 */
public class Solution {

    /**
     * O(n^2)
     * 动态规划:
     * 用0和1表示nums遍历过程中的两个状态：0代表当前数大于前一个数（上升），1代表当前数小于前一个数(下降)
     * 所以dp[0][i]表示到i为止上升序列的最大长度，dp[1][i]表示到i为止下降序列的最大长度
     * 当前状态为上升的dp[0][i]大小取决前一个状态为下降的dp[1][j]，同理当前状态为下降的dp[1][i]大小取决前一个状态为上升的dp[0][j]
     * 由此得出状态转移方程：
     *                  dp[0][i] = max(dp[0][i], dp[1][j] + 1); (nums[i] > nums[j])
     *                  dp[1][i] = max(dp[1][i], dp[0][j] + 1); (nums[i] < nums[j])
     * 初始条件：当nums只有一个元素时，  dp[0][0] = dp[1][0] = 1
     */
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 1;
        dp[1][0] = 1;
        int max1 = dp[0][0];
        int max2 = dp[1][0];
        for(int i = 1; i < nums.length; i++){
            dp[0][i] = 1;
            dp[1][i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[0][i] = Math.max(dp[0][i], dp[1][j] + 1);
                }else if(nums[i] < nums[j]){
                    dp[1][i] = Math.max(dp[1][i], dp[0][j] + 1);
                }
            }
            max1 = Math.max(max1, dp[0][i]);
            max2 = Math.max(max2, dp[1][i]);
        }
        return Math.max(max1, max2);
    }

    /**
     * O(n):
     * 优化后的动态规划：
     * 不使用二维数组，只使用两个状态maxUp和maxDown来维护在i之前的最大上升序列长度和最大下降序列长度
     * 当前maxUp取决于前一个maxDown，同理当前maxDown取决于前一个maxUo
     * 由此得出状态转移方程：
     *                  maxUp = Math.max(maxUp, maxDown + 1); （nums[i] > nums[i - 1]）
     *                  maxDown = Math.max(maxDown, maxUp + 1); （nums[i] < nums[i - 1]）
     * 初始条件：当nums只有一个元素时，  maxUp = maxDown = 1
     */
    public int wiggleMaxLength2(int[] nums) {
        if(nums.length == 0) return 0;
        int maxUp = 1;
        int maxDown = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                maxUp = Math.max(maxUp, maxDown + 1);
            }else if(nums[i] < nums[i - 1]){
                maxDown = Math.max(maxDown, maxUp + 1);
            }
        }
        return Math.max(maxUp, maxDown);
    }

}
