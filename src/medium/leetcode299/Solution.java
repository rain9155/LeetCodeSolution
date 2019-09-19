package medium.leetcode299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 猜数字游戏:
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
 * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 你的朋友将会根据提示继续猜，直到猜出秘密数字。请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * 示例 1:
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 */
public class Solution {

    /**
     * 哈希表：
     * 第一次遍历时，如果secret和guess某一位数字相同，那么公牛数加1，否则用哈希表记录secret中的这位数与这位数重复的次数，并用一个List保存guess中的这位数
     * 第二次遍历时，遍历List，查看List中的数字在哈希表中出现的次数，如果有出现，那么奶牛数加1，并且哈希表中该位数的数量减一
     */
    public String getHint(String secret, String guess) {
        Map<Character, Integer> secretMap = new HashMap<>();
        List<Character> guessList = new ArrayList<>();
        int bullsCount = 0, cowsCount = 0;
        for(int i = 0; i < secret.length(); ++i){
            char secretNum = secret.charAt(i);
            char guessNum = guess.charAt(i);
            if(secretNum == guessNum){
                ++bullsCount;
            }else {
                secretMap.put(secretNum, secretMap.getOrDefault(secretNum, 0) + 1);
                guessList.add(guessNum);
            }
        }
        for(int i = 0; i < guessList.size(); i++){
            char num = guessList.get(i);
            if(secretMap.getOrDefault(num, 0) > 0){
                ++cowsCount;
                secretMap.put(num, secretMap.get(num) - 1);
            }
        }
        return bullsCount + "A" + cowsCount + "B";
    }

}
