package medium.leetcode427;

/**
 * 建立四叉树:
 * 给你一个 n * n 矩阵 grid, 矩阵由若干 0 和 1 组成, 请你用四叉树表示该矩阵 grid, 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
 * 
 * 四叉树数据结构中，每个内部节点只有四个子节点, 此外，每个节点都有两个属性：
 * val：储存叶子结点所代表的区域的值, 1 对应 True，0 对应 False, 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制接受 。
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * 
 * 我们可以按以下步骤为二维区域构建四叉树：
 * 1、如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
 * 2、如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
 * 3、使用适当的子网格递归每个子节点。
 * 
 * 示例 1：
 *          0   1
 *          1   0
 * 输入：grid = [[0,1],[1,0]]
 * 输出：[[0,1],[1,0],[1,1],[1,1],[1,0]]
 * 解释：此示例的解释如下，请注意，在下面四叉树的图示中，0 表示 false，1 表示 True 
 *                 isLeft:0
 *                    val:1
 *         /      |      |         \
 *  topleft  topRight  bottomLeft  bottomRight
 * isLeft:1  isLeft:1    isLeft:1     isLeft:1
 *    val:0     val:1       val:1        val:0
 */
public class Solution {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
    
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
    }

    /**
     * 递归：O(n^2 * logn)
     * 使用递归函数dfs(i, j, row, col)处理给定矩阵的从i行到row-1行，从j列到col-1列的部分
     * 首先判断这一部分是否全为0或1，如果是，构造出叶子节点返回并结束递归，如果不是，这一部分对应非叶子节点，我们将其分为四部分继续分别递归
     * 四部分划分的分界线为：行的分界线为(i + row / 2), 列的分界线为(j + col / 2), 再将四部分递归返回的结果作为非叶子节点的四个子节点
     */
    public Node construct(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return null;
        }
        return dfs(grid, 0, 0, grid.length, grid[0].length);
    }

    private Node dfs(int[][] grid, int i, int j, int row, int col) {
        if(isSame(grid, i, j, row, col)) {
            return new Node(
                grid[i][j] == 1 ? true : false,
                 true
            );
        }
        int midRow = (i + row) / 2;
        int midCol = (j + col) / 2;
        Node node = new Node(true, false);
        node.topLeft = dfs(grid, i, j, midRow, midCol);
        node.topRight = dfs(grid, i, midCol, midRow, col);
        node.bottomLeft = dfs(grid, midRow, j, row, midCol);
        node.bottomRight = dfs(grid, midRow, midCol, row, col);
        return node;
    }

    private boolean isSame(int[][] grid, int i, int j, int row, int col) {
        int val = grid[i][j];
        for(int i0 = i; i0 < row; i0++) {
            for(int j0 = j; j0 < col; j0++) {
                if(grid[i0][j0] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}
