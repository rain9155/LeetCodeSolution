package easy.leetcode292;

import java.util.HashMap;
import java.util.Map;

/**
 * Nim 游戏：
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 示例:
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */
public class Solution {

    /**
     * 带备忘录的动态规划（极大极小化）：（n太大时，会出现StackOverflowError）
     * 不管轮到对手还是我，当剩下 <= 3个石头时，那个人一定赢，不管轮到哪个人，都会选最优的拿法
     * 所以我要做的是每次尝试拿1块、2块、3块石头后，看对手是否会输，在3个拿法中，只要有一个拿法使得对手输了，那么这轮我就赢了
     */
    public boolean canWinNim(int n) {
        return canWinNim(n, new HashMap<>());
    }

    private boolean canWinNim(int n, Map<Integer, Boolean> cache) {
        if(n <= 3){
            return true;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        boolean isCanWin = !canWinNim(n - 1, cache) || !canWinNim(n - 2, cache) || !canWinNim(n - 3, cache);
        cache.put(n, isCanWin);
        return isCanWin;

    }

    /**
     * 动态规划：（超时）
     * 只需要3个状态位，通过取模运算把n映射到[0, 3]的范围，避免溢出
     * 状态转移方式：dp[i] = (!dp[i - 1] || !dp[i - 2] || !dp[i - 3]）
     */
    public boolean canWinNim2(int n) {
        boolean[] dp = new boolean[3];
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for(int i = 4; i <= n; i++){
            dp[i % 4] = !dp[(i - 1) % 4] || !dp[(i - 2) % 4] || !dp[(i - 3) % 4];
        }
        return dp[n % 4];
    }

    /**
     * 找规律:
     * 当我拿完还剩1、2、3个时，必败，故我拿前有4个时必败，
     * 所以只要在我拿前有5、6、7个时，就可以必胜（5个时拿走一个，6拿2，7拿3，使对手转入拿前4个的必败状态），
     * 所以我拿前还有8个时必败（使对手转入必胜的拿前5、6、7状态）...
     * 所以只要n不是4、8、12...等4的倍数，我就必胜
     */
    public boolean canWinNim3(int n) {
        return n % 4 != 0;
    }

}
