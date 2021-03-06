package medium.leetcode319;

/**
 * 灯泡开关:
 * 初始时有 n 个灯泡关闭。
 * 第 1 轮，你打开所有的灯泡。
 * 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * 第 i 轮，每 i 个灯泡切换一次开关。
 * 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 *
 * 示例:
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * 你应该返回 1，因为只有一个灯泡还亮着。
 */
public class Solution {

    /**
     * 找规律：
     * 假设有7个灯泡，关闭状态用0表示，开启状态用1表示，即这个7个灯泡的初始状态是：0 0 0 0 0 0 0
     * 第1轮：1 1 1 1 1 1 1
     * 第2轮：1 0 1 0 1 0 1
     * 第3轮：1 0 0 0 1 1 1
     * 第4轮：1 0 0 1 1 1 1
     * 第5轮：1 0 0 1 0 1 1
     * 第6轮：1 0 0 1 0 0 1
     * 第7轮：1 0 0 1 0 0 0
     * 我们发现每个灯泡的开关状态改变的轮次是：
     * 第1个：第1轮
     * 第2个：第1、2轮
     * 第3个：第1、3轮
     * 第4个：第1、2、4轮
     * 第5个：第1、5轮
     * 第6个：第1、2、3、6轮
     * 第7个：第1、7轮
     * 其中最终结果即第7轮只有第1个和第4个灯泡亮着，所以如果灯泡改变奇数次，最终状态是亮着，如果灯泡改变偶数次，最终状态是关闭
     * 所以我们只要找出1到7个灯泡之间的改变次数是奇数的灯泡，即找出因子个数是奇数的第i个灯泡
     * 例如1和4，因为1 = 1* 1，它的因子是1，4 = 1 * 4 或 2 * 2，它的因子是1、2、4，都为奇数，所以1和4灯泡最终亮着
     * 而6 = 1 * 6 或 2 * 3，它的因子是1、2、3、6，是偶数，所以第6个灯泡最终关闭，不符合条件
     * 而只有完全平方数的因子个数才是奇数，例如1和4都是完全平方数，6不是完全平方数
     * 所以最终答案只有求n以内（包括n和1）的完全平方数数量，只要计算sqrt(n)即可，n的平方根 = n以内的完全平方数数量
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

}
