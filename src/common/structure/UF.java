package common.structure;

/**
 * 并查集
 */
public class UF {

    //连通分量的个数
    private int count;

    //记录每个节点的父节点，x节点的父节点是parent[x]
    private int[] parent;

    //记录根节点的重量, 根节点x的重量为size[x]
    private int[] size;

    public UF(int count){
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for(int i = 0; i < count; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 返回并查集的连通分量个数
     */
    public int getCount(){
        return count;
    }

    /**
     * 返回节点x所在树的树根
     */
    private int find(int x){
        while (parent[x] != x){
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 判断节点x和节点y是否在同一个连通分量下
     */
    public boolean connected(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    /**
     * 把节点x所在的树和节点y所在的树合并为一颗树
     */
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){
            return;
        }

        //小树接到大树下，较平衡
        if(size[rootX] > size[rootY]){
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        //连通量数目减一
        this.count--;
    }

}
