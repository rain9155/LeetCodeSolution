package medium.leetcode210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表 II:
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1;
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 说明:
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class Solution {

    /**
     * BFS: 参考leetcode207
     * 1、初始化一个队列 Q来记录图中0入度的所有结点。
     * 2、遍历输入中的所有边，存储每个结点的入度。
     * 3、遍历邻接表，将所有入度为0的边加入 Q.
     * 4、执行以下操作直到 Q为空。
     *  4.1、从 Q中弹出一个元素。不妨称为 N。
     *  4.2、对 N的所有邻接节点, 将其入度减去1。若任意结点的入度变为0，将其加入Q。
     *  4.3、将节点N加入到存储拓扑排序的列表中。
     *  回到4.1。图中的每个结点都处理了一次
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0 ) return new int[0];
        if(prerequisites.length == 0) return new int[]{0};

        //保存输出的拓扑排序
        int[] ret = new int[numCourses];

        //保存所有结点的入度inDegree
        int[] inDegree = new int[numCourses];
        for(int[] courses : prerequisites){
            inDegree[courses[0]]++;
        }

        //暂存入度为零的结点的队列
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }
        int i = 0;
        //不断弹出入度为零的结点，然后把该结点和该结点的出度从图中删除
        while (!queue.isEmpty() && i < numCourses){
            int course = queue.poll();
            ret[i++] = course;
            //BFS,找出所有与入度为零结点相连的结点
            for(int[] courses : prerequisites){
                if(course == courses[1]){
                    //并把与入度为零结点相连的的结点的入度减一
                    inDegree[courses[0]]--;
                    //如果结点的入度为0，就加入队列
                    if(inDegree[courses[0]] == 0)
                        queue.add(courses[0]);
                }
            }
        }

        return numCourses != i ? new int[0] : ret;
    }


    /**
     * DFS:参考207
     * 1、初始化栈 S，它将存储图中课程的拓扑排序。
     * 2、使用输入中提供的边构建邻接表。注意输入中如 [a, b] 的边代表课程 b是课程 a的先修课程。这代表边 b ➔ a。在实现算法时，请记住这一点。
     * 3、对于图中的每个结点，都运行一次深度优先搜索，以防该结点没有在其他结点的深度优先搜索中被访问到过。
     * 4、假设我们正在执行结点 N的深度优先搜索。我们将递归地遍历结点 N 所有未被处理过的邻接结点。
     * 5、处理完了所有邻接结点后，将结点N入栈。我们利用栈来模拟所需要的顺序。当结点 N入栈时，所有以N 为先修的课程结点均已经入栈。
     * 6、在所有的结点被处理过后，从栈顶到栈底顺序依次返回结点元素。
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0) return new int[0];

        //保存输出的拓扑排序
        ArrayList<Integer> temp = new ArrayList<>(numCourses);

        //逆向邻接表
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>(2);
        }
        //根据prerequisites构建逆向邻接表
        for(int[] courses : prerequisites){
            int from = courses[1];
            int to = courses[0];
            graph[from].add(to);

        }

        //访问数组
        int[] visited = new int[numCourses];//0表示没有访问过，1表示已经访问过，-1表示重复访问，有环
        boolean isOrder = true;
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, graph, visited, temp)){
                isOrder = false;
                break;
            }
        }
        int[] ret;
        if(isOrder){
            ret = new int[numCourses];
            for(int i = 0; i < temp.size(); i++) ret[i] = temp.get(numCourses - i - 1);
        }else {
            ret = new int[0];
        }
        return ret;
    }

    private boolean dfs(int from, ArrayList<Integer>[] graph, int[] visited, List<Integer> temp){
        if(visited[from] == 1) return true;//该位置已经访问过，不用重复访问，返回true
        if(visited[from] == -1) return false;//该位置在递归时曾经访问过，表示遇到环，返回false

        //走到这里表示该结点第一次访问，visited = 0

        visited[from] = -1;//先设置-1，如果递归的访问结点的过程中有环，则会再次访问到该位置

        //递归访问邻接结点
        for(int to : graph[from]){
            if(!dfs(to, graph, visited, temp))
                return false;
        }
        temp.add(from);
        visited[from] = 1;//设置1，所有邻接结点都访问完毕，跳出循环，当前结点设置为已经访问过，下次不会重复访问
        return true;
    }

}
