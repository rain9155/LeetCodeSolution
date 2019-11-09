package medium.leetcode399;

import javafx.util.Pair;

import java.util.*;

/**
 * 除法求值:
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 
 * 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 */
public class Solution {

    //图，key为结点，value为Pair，Pair中String为Key的邻接点，Double为Key到邻接点的边的权值
    Map<String, List<Pair<Double, String>>> graph = new HashMap<>();

    /**
     * DFS:
     * 把问题抽象成图，把equations中的字母当作图的结点
     * 如：a/b = 2， 看作a -> b, 边的权值为2，和b -> a, 边的权值为1/2
     * b / c = 3 , 看作 b -> c, 边的权值为3，和c -> b，边的权值为1/3
     * 当要求a/c时，因为a -> b, b -> c, 则a / c == a -> c == 2 * 3 = 6
     * 所以根据equations构建一个图，求解queries，就变成了看这个图中是否有一条路径到这个结点，如果有，就把路径上的权值相乘起来，就是queries的某个表达式的解
     * 当queries中的点不在图中时，可以直接忽略
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String form = equation.get(0);
            String to = equation.get(1);
            Double value = values[i];
            //建立从from到to的映射
            graph.putIfAbsent(form, new ArrayList<>());
            graph.get(form).add(new Pair<>(value, to));
            //建立从to到from的映射
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(to).add(new Pair<>(1 / value, form));
        }
        double[] ret = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            ret[i] = -1;
            if(graph.containsKey(from)){
                //查找是否有from到to的路径
                double value = dfs(from, to, new HashSet<>());
                ret[i] = value;
            }
        }
        return ret;
    }

    /**
     * 从from开始，查找是否有到to的路径
     * 如果有，就把路径上的值相乘返回
     */
    private double dfs(String from, String to, Set<String> visit){
        if(from.equals(to)){
            return 1;
        }
        if(visit.contains(from)){
            return -1;
        }
        visit.add(from);
        for(Pair<Double, String> pair : graph.get(from)){
            double value = pair.getKey();
            String next = pair.getValue();
            double d = dfs(next, to, visit);
            if(d > 0){
                return value * d;
            }
        }
        visit.remove(from);
        return -1;
    }

}
