package medium.leetcode638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大礼包:
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * 任意大礼包可无限次购买。
 *
 * 示例 1:
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 *
 * 示例 2:
 * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * 输出: 11
 * 解释:
 * A，B，C的价格分别为¥2，¥3，¥4.
 * 你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
 * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
 * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
 *
 * 说明:
 * 最多6种物品， 100种大礼包。
 * 每种物品，你最多只需要购买6个。
 * 你不可以购买超出待购清单的物品，即使更便宜。
 */
public class Solution {

    private List<Integer> mPrices;
    private List<List<Integer>> mSpecials;
    private Map<List<Integer>, Integer> cache;

    /**
     * dfs + 记忆化搜索
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(price.size() == 0 || special.size() == 0 || needs.size() == 0){
            return 0;
        }
        int i = 0;
        for(; i < price.size() && price.get(i) <= 0; i++);
        if(i == price.size()){
            return 0;
        }
        mPrices = price;
        mSpecials = special;
        cache = new HashMap<>();
        return helper(needs, 0);
    }

    private int helper(List<Integer> needs, int count){
        if(cache.containsKey(needs)){
            return cache.get(needs);
        }
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < mSpecials.size(); i++){
            List<Integer> special = mSpecials.get(i);
            int j = 0;
            List<Integer> cloneNeeds = new ArrayList<>(needs);
            for(; j < cloneNeeds.size(); j++){
                int specCount = special.get(j);
                int need = cloneNeeds.get(j);
                int remainder = need - specCount;
                if(remainder < 0){
                    break;
                }
                cloneNeeds.set(j, remainder);
            }
            if(j == needs.size()){
                minCount = Math.min(
                        helper(cloneNeeds, count + special.get(special.size() - 1)),
                        minCount);
            }else {
                int prices = 0;
                for(int t = 0; t < mPrices.size(); t++){
                    prices += mPrices.get(t) * needs.get(t);
                }
                prices += count;
                minCount = Math.min(minCount, prices);
            }
        }
        cache.put(needs, minCount);
        return minCount;
    }

}
