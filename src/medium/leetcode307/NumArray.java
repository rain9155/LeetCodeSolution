package medium.leetcode307;

/**
 * 区域和检索 - 数组可修改:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * 说明:
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

/**
 * 使用线段树
 */
public class NumArray {

    int[] tree;
    int len;

    /**
     * 构建线段树
     * 使用数组通过nums构建出线段树tree，线段树的长度为2 * len, len为nums的长度
     * 1、首先把叶子节点nums从索引len开始放置，放在tree的最后边
     * 2、然后构造其他节点，从len - 1索引处往前开始构造，那对于索引为 i 的节点值，其左子节点和右子节点分别存储在索引为 2i 和 2i+1 的元素处
     * 例如nums = [2,4,5,7,8,9]，其构造出来的tree = [35,29,6,12,17,2,4,5,7,8,9]
     */
    public NumArray(int[] nums) {
        if(nums.length > 0){
            len = nums.length;
            tree = new int[len * 2];
            for(int i = len, j = 0; i < len * 2; i++, j++){
                tree[i] = nums[j];
            }
            for(int i = len - 1; i > 0; i--){
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }
    }

    /**
     * 更新线段树
     * 1、首先更新更新nums[i]处对应的tree的叶子节点位置的值，即tree[i + len] = val
     * 2、然后从叶子节点开始，一路向上，直到根节点，并用其子节点值的总和来更新每个父节点的值
     */
    public void update(int i, int val) {
        int pos = i + len;
        //更新nums[i]处对应的tree[pos]处的叶子节点
        tree[pos] = val;
        //然后从该节点开始更新其父节点的值
        while (pos > 0){
            //pos的父节点的左右子树
            int left = pos;
            int right = pos;
            //如果pos是偶数，则当前pos为左节点，则右节点在pos + 1
            if(pos % 2 == 0){
                right = pos + 1;
            }else { //如果pos是奇数，则当前pos为右节点，则左节点在pos - 1
                left = pos - 1;
            }
            //根据pos父节点的值
            tree[pos / 2] = tree[left] + tree[right];
            //pos移动到父节点位置
            pos /= 2;
        }
    }

    /**
     * 在线段树中进行区域求和：
     * 1、首先把[i...j]在nums中的范围映射到tree中[l...r]的范围
     * 2、在tree中进行[l...r]的范围检索，不断的缩小左右边界，在缩小的同时累加，直到左右边界相遇时，得出结果
     */
    public int sumRange(int i, int j) {
        int l = i + len;
        int r = j + len;
        int sum = 0;
        //根据左右边界找到这个范围的总和
        //即[i...j] = [i + len…l] + [r…j + len]
        //算法的每次迭代中，会向上移动一层，要么移动到当前节点的父节点，要么移动到父节点的左侧或者右侧的兄弟节点，直到两个边界相交为止
        while (l <= r){
            //如果l是右子节点，累加到sum后加1，使得l变成左子节点
            //表示已经算出[i…l]的总和
            if((l % 2) == 1){
                sum += tree[l];
                l++;
            }
            //如果r是左子节点，累加到sum后减1，使得r变成右子节点
            //表示已经算出[r…j]的总和
            if((r % 2) == 0){
                sum += tree[r];
                r--;
            }
            l /= 2;//移动到l的父节点位置
            r /= 2;//移动到r的父节点位置
        }
        return sum;
    }

}
