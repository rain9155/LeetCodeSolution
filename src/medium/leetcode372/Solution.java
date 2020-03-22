package medium.leetcode372;

/**
 * 超级次方:
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1:
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 */
public class Solution {

    /**
     * 超时
     * 因为输入的b是大数，所以不可以直接把b所有的十进制数相加得出幂，所以可以使用分解：
     * (a ^ b) % m = ((a % m) ^ b) % m
     * 例如输入a = 3，b = [1,2,3], 计算(3^123)%1337
     * 因为3^123 = 3^(100 + 20 + 3) = 3^100 * 3^20 * 3^3
     * 所以(3^123)%1337 = (((3^100) % 1337) * ((3^20)%1337) * ((3^3)%1337)) % 1337
     * 而分解出来的每一部分都可以使用快速幂取模算法，最后把每一部分相乘起来即可
     */
    public int superPow(int a, int[] b) {
        int mod = 1337;
        int len = b.length;
        int ret = 1;
        for(int i = len - 1, factor = 1; i >= 0; i--, factor *= 10){
            int pow = b[i] * factor;
            ret *= quickPow(a, pow, mod);
        }
        return ret % 1337;
    }

    /**
     * 参考：https://blog.csdn.net/ltyqljhwcm/article/details/53043646
     * 快速幂取模算法： 把a的幂取模运算转换为乘法乘法运算
     * (a * b) % m = (a % m * b % m) % m
     * 例如计算(3^3)%2
     * 因为^3 = 3^(0*2^2 + 1*2^1 + 1*2^0) = 3^(0*2^2) * 3^(1*2^1) * 3^(1*2^0),
     * 则(3^3)%2 = ((3^(0*2^2)%2) * (3^(1*2^1)%2) * (3^(1*2^0)%2) % 2，
     * 这样，b的二进制位为0的地方就可以跳过不计算，
     * 所以(3^3)%2 最终等于 ((3^(1*2^1)%2) * (3^(1*2^0)%2) % 2，减少很多计算量
     */
    private int quickPow(int a, int b, int m){
        int ret = 1;
        a = a % m;//防止a比mod大，减少计算量
        while(b != 0){
            if((b & 1) == 1){//跳过二进制位为0的位，因为为0时，a^0 = 1, 没有必要计算
                ret = (ret * a) % m;
            }
            b >>= 1;//b的二进制位不断的右移
            a = (a * a) % m;//a不断的加倍
        }
        return ret;
    }

    /**
     * 参考：https://www.cnblogs.com/wenzhixin/p/9854509.html
     * 欧拉-费马降幂：
     * 根据欧拉-费马降幂，a^b % c = a^(b % phi(c)) % c（c是素数）
     * phi(c)是欧拉函数，表示小于c的和c互质的数的个数。
     * 这道题给定c是1137，所以可以提前求出phi(c) = 1140。
     * 求出phi(c)之后，就把输入的b大数降幂，最后使用快速幂取模算法，把降幂后的结果求出来
     */
    public int superPow2(int a, int[] b) {
        int mod = 1337;
        int len = b.length;
        int modPhi = phi(mod);
        int pow = 0;
        //同余，降幂
        for(int i = 0; i < len; i++){
            pow = (pow * 10 + b[i]) % modPhi;
        }
        return quickPow(a, pow, mod);
    }

    /**
     * 欧拉函数：
     * 求小于或等于n并且与n互质的数的个数，两个数互质就是这个两个数的公因数有且仅为1，公因数就是两个数的公约数有且仅为1
     * 例如phi(1) = 1
     */
    private int phi(int n){
        int ret = n;
        for(int i = 2; i * i < n; i++){
            if(n % i == 0){//n的质因数
                ret = ret / n * (n - 1); //欧拉函数公式
                while(n % i == 0){//去掉质因数i
                    n /= i;
                }
            }
        }
        if(n > 1){//n本来就是质数 f(n) = n-1;
            ret = ret / n * (n - 1);
        }
        return ret;
    }

}
