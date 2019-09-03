package medium.leetcode223;

/**
 * 矩形面积:
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 * 示例:
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 */
public class Solution {

    /**
     * 找规律：
     * 判断这两个矩形有没有重叠：
     *  如果没有重叠，直接返回两个矩形的总面积
     *  如果有重叠，求出重叠部分上下左右边界从而求出重叠部分的面积，然后返回两个矩形的总面积 - 重叠部分的面积
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //求两个矩形的总面积
        int sumArea = (C - A) * (D - B) + (G - E) * (H - F);
        //没有重叠
        if(E >= C ||  G <= A || F >= D || H <= B) {
            return sumArea;
        }
        //有重叠
        //求重叠部分上下左右边界
        int CG = Math.min(C, G);//右边界，取相交的两个矩形的右边界的最小值
        int AE = Math.max(A, E);//左边界，取相交的两个矩形的右边界的最大值
        int DH = Math.min(D, H);//上边界，取相交的两个矩形的上边界的最小值
        int BF = Math.max(B, F);//下边界，取相交的两个矩形的下边界的最大值
        //求重叠部分的面积
        int area = (CG - AE) * (DH - BF);//宽 * 高
        return sumArea - area;
    }

}
