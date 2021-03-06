package medium.leetcode486;

/**
 * 预测赢家：
 * 给定一个表示分数的非负整数数组。
 * 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
 * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 示例 1:
 * 输入: [1, 5, 2]
 * 输出: False
 * 解释: 一开始，玩家1可以从1和2中进行选择。
 * 如果他选择2（或者1），那么玩家2可以从1（或者2）和5中进行选择。如果玩家2选择了5，那么玩家1则只剩下1（或者2）可选。
 * 所以，玩家1的最终分数为 1 + 2 = 3，而玩家2为 5。
 * 因此，玩家1永远不会成为赢家，返回 False。
 * 示例 2:
 * 输入: [1, 5, 233, 7]
 * 输出: True
 * 解释: 玩家1一开始选择1。然后玩家2必须从5和7中进行选择。无论玩家2选择了哪个，玩家1都可以选择233。
 * 最终，玩家1（234分）比玩家2（12分）获得更多的分数，所以返回 True，表示玩家1可以成为赢家。
 *
 * 注意:
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于10000000。
 * 如果最终两个玩家的分数相等，那么玩家1仍为赢家。
 */
public class Solution {

    /**
     * 递归：
     * 首先算出总分sum，然后通过递归求得玩家1的最优得分，然后根据sum得出玩家2的得分，比较玩家1和玩家2的得分
     */
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int firstGrade = firstWinner(nums, 0, nums.length - 1);//玩家1在这个游戏中拿的分数
        int secondGrade = sum - firstGrade;//玩家2在这个游戏中拿的分数
        return firstGrade >= secondGrade;//只要玩家1的分数 >= 玩家2的分数就赢了
    }

    //玩家1先拿，返回玩家1所得的最大分数
    private int firstWinner(int[] nums, int start, int end){
        if(start == end){//只有一个数字可以选择，玩家1先拿
            return nums[start];
        }
        if(end - start == 1){//只有两个个数字可以选择，玩家1先拿，取最大的那个，保证分数最大
            return Math.max(nums[start], nums[end]);
        }
        //首先大家都是聪明人，
        //玩家1可以拿start或end位置的数：
        //当玩家1拿了start位置的数，轮到玩家2，这时玩家2只能拿[start + 1, end]位置的数，
        //      所以这时对于玩家2，它也可以拿start或end位置的数，如果它拿了start位置的数，玩家1只能拿[start + 2, end]位置的数, 如果它拿了end位置的数，玩家1只能拿[start + 1, end - 1]位置的数
        //      玩家2也是聪明人，它肯定会选择对自己最好的结果，玩家2的最好结果对于玩家1来说就是最坏的结果，所以取Math.min((start + 2, end), (start + 1, end - 1))
        //当玩家1拿了end位置的数，轮到玩家2，这时玩家2只能拿[start, end - 1]位置的数
        //      所以这时对于玩家2，它也可以拿start或end位置的数，如果它拿了start位置的数，玩家1只能拿[start + 1, end - 1]位置的数, 如果它拿了end位置的数，玩家1只能拿[start, end - 2]位置的数
        //       玩家2也是聪明人，它肯定会选择对自己最好的结果，玩家2的最好结果对于玩家1来说就是最坏的结果, 同理取min值
        //玩家1也是聪明人，所以玩家1会取拿了start位置的数或end位置的数后的最好的结果，即max值
        return Math.max(
                nums[start] + Math.min(firstWinner(nums, start + 2, end), firstWinner(nums, start + 1, end - 1)),
                nums[end] + Math.min(firstWinner(nums, start, end - 2), firstWinner(nums, start +1, end - 1))
        );
    }


    /**
     * 二维dp：
     * dp[i][j]表示玩家1在[i, j]位置的数字中能拿到的最大分数
     * 只有一个数字时，玩家1先拿，玩家1必胜
     * 当只有两个数字时，玩家1肯定会拿最大的那个，玩家1必胜
     * ...
     * 当有n个数字时，轮到玩家1时，玩家1可以从nums的最左边i或者最右边j取数字
     *                           当玩家1取最左边的数字nums[i]后，轮到玩家2取，玩家2也可以取最左边或者最右边的数字，玩家2会取走最大的，玩家2取走后，又轮到玩家1，这时玩家1只能取最小的
     *                           当玩家1取最右边的数字nums[j]后，轮到玩家2取，玩家2也可以取最左边或者最右边的数字，玩家2会取走最大的，玩家2取走后，又轮到玩家1，这时玩家1只能取最小的
     *                           所以本轮玩家1的得分为max(nums[i] + min(dp[i + 1][j - 1], dp[i + 2][j]), nums[j] + min(dp[i + 1][j - 1], dp[i][j - 2]))
     */
    public boolean PredictTheWinner2(int[] nums) {
        int len = nums.length;
        //偶数，玩家1一定能取得最大分数，因为玩家1可以提前计算好奇数下标的得分和偶数下标的得分，那个得分高就取哪边，所以玩家1总是会获胜
        //例如nums = [2, 3, 6, 1， 5， 7], 偶数下标的2、6得分为8，奇数下标的3、1得分为4，而8 > 4, 所以玩家1一开始选择偶数下标即最左边的数拿就一定必胜
        if((len & 1) == 0){
            return true;
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //奇数，使用动态规划
        int[][] dp = new int[len][len];
        //dp对角线：当只有一个数字时，玩家1先拿；当只有两个数字时，玩家1肯定会拿最大的那个
        for(int i = 0; i < len; i++){
            dp[i][i] = nums[i];
            if(i + 1 < len){
                dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
            }
        }
        //从下往上，从左往右遍历dp数组
        for(int i = len - 3; i >= 0; i--){
            for(int j = i + 2; j < len; j++){
                //获得玩家1在每个[i, j]范围的最大得分
                dp[i][j] = Math.max(
                        nums[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]),
                        nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2])
                );
            }
        }
        //玩家1的最终分数大于玩家2就赢了
        return dp[0][nums.length - 1] >= sum - dp[0][nums.length - 1];
    }

    /**
     * 二维dp2：参考877题
     * dp[i][j]表示在[i, j]范围的数字内玩家1多出玩家2的分数，最终只要玩家1的多出的分数大于等于0，玩家1就赢了
     */
    public boolean PredictTheWinner3(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        //dp对角线：当只有一个数字时，玩家1先拿
        for(int i = 0; i < len; i++){
            dp[i][i] = nums[i];
        }
        //从下往上，从左往右遍历dp数组
        for(int i = len - 2; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                //获得玩家1在每个[i, j]范围内大于玩家2的分数
                dp[i][j] = Math.max(
                        nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]
                );
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

}
