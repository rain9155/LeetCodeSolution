package medium.leetcode464;

import java.util.HashMap;
import java.util.Map;

/**
 * 我能赢吗:
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
 * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
 * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
 *
 * 示例：
 * 输入：
 * maxChoosableInteger = 10
 * desiredTotal = 11
 * 输出：
 * false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 */
public class Solution {

    /**
     * 动态规划：
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //如果可选的数字范围大于累加和，一定能赢，如maxChoosableInteger = 10， desiredTotal = 1
        if(maxChoosableInteger >= desiredTotal){
            return true;
        }
        //如果可选的数字加起来都没有累加和大，一定不能赢，如maxChoosableInteger = 1， desiredTotal = 10
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
            return false;
        }
        //下面的情况都是desiredTotal > maxChoosableInteger, 如maxChoosableInteger = 10， desiredTotal = 11
        Map<Integer, Boolean> cache = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, 0, cache);
    }

    //因为maxChoosableInteger最大为20，用一个int的二进制位used表示某位是否使用过，如果该位为1，表示该位对应的数字使用过
    //used也可以唯一的标识某位数字，
    private boolean canIWin(int maxChoose, int curTotal, int used, Map<Integer, Boolean> cache){
        if(cache.containsKey(used)){
            return cache.get(used);
        }
        for(int i = 1; i <= maxChoose; i++){
            int cur = 1 << (i - 1);//把当前选择的这个数字i对应的二进制位标为1
            if((used & cur) == 0){//这位数字没有被使用过
                if(i  >= curTotal ||//如果当前选择的数字 >= curTotal, 表示当前玩家一定能赢，即当前累加值加上i，一定 >= desiredTotal
                        !canIWin(maxChoose, curTotal - i, used | cur, cache))//如果当前选择的数字不会使得累加值 >= desiredTotal, 就看对方能否会赢，如果对方不能赢，就是我方赢
                {
                    cache.put(used, true);
                    return true;
                }
            }
        }
        //所有可以选择的数字都比curTotal小或选择任何一个数字对方都能赢
        //那么我方一定不能赢
        cache.put(used, false);
        return false;
    }

}
