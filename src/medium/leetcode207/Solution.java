package medium.leetcode207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 课程表:
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 说明:
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 */
public class Solution {

    /**
     * BFS:
     * 不断的做这样的一件事：在余下的图中找一个源，该源是一个没有入度的顶点，
     * 然后把该顶点和该顶点的出度从图中删除，该源被删除的次序就是拓扑排序。
     * 1、首先根据prerequisites生成所有结点的入度列表inDegree
     * 2、把入度为零的结点放入队列queue，表示先学习的课程
     * 4、不断从队列弹出入度为零的结点，并把numCourses减一，表示学完一门课程
     * 5、然后BFS所有与入度为零结点相连的结点，并把与入度为零结点相连的的结点的入度减一(这样做就表示把入度为零的结点从图中删除掉)，如果减完后有入度为零的结点，就加入队列
     * 最后判断numCourses是否为零就行。
     * 它的原理就是：
     * 减一法，每次把入度为零的结点从图中删除，直到所有入度为零的结点都删除完，那么inDegree数组所有结点的入度都为零，如果还剩下结点入度不为零，则不满足拓扑排序
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;
        if(prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        //通过邻接表生成所有结点的入度inDegree
        for(int[] courses : prerequisites){
            for(int i = 1; i < courses.length; i++){
                inDegree[courses[0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        //把入度为零的结点放入队列
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }
        //不断弹出入度为零的结点，然后把该结点和该结点的出度从图中删除
        while (!queue.isEmpty()){
            int course = queue.poll();
            numCourses--;
            //BFS,找出所有与入度为零结点相连的结点
            for(int[] courses : prerequisites){
                if(course == courses[courses.length - 1]){
                    //并把与入度为零结点相连的的结点的入度减一
                    for(int i = courses.length - 2; i >= 0; i--){
                        inDegree[courses[i]]--;
                        //如果结点的入度为0，就加入队列
                        if(inDegree[courses[i]] == 0)
                            queue.add(courses[i]);
                    }
                }
            }
        }



        return numCourses == 0;
    }


    /**
     * dfs：
     * 执行一遍DFS遍历，并记住顶点的出栈顺序，把顶点的出栈顺序反过来就是拓扑排序，
     * 当然，在入栈时，不能遇到回边，否则该图就不是无环有向图，就无解。
     * 1、首先根据prerequisites构建逆向邻接表graph
     * 2、创建一个访问数组访问数组，0表示没有访问过，1表示已经访问过，-1表示重复访问，有环，初始都为0
     * 3、对每一个结点（课程）进行dfs，如果在某个结点的dfs中存在环，则这个结点一定会被再次访问，此时visited = -1，返回false，否则把visited置为1，下次不用重复访问
     * 它的原理就是：
     * 如果在某个结点的dfs中存在环，则这个结点一定会被再次访问，则有环，
     * 递归就是一个入栈的过程，如果在入栈的过程中出现重复入栈的元素，则有环，否则，把入栈的元素依此弹出就是拓扑排序
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;
        if(prerequisites.length == 0) return true;
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>(2);
        }
        //根据prerequisites构建逆向邻接表
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][prerequisites[i].length - 1];
            for(int j = prerequisites[i].length - 2; j >= 0; j--){
                int to = prerequisites[i][j];
                graph[from].add(to);
            }

        }
        //访问数组
        int[] visited = new int[numCourses];//0表示没有访问过，1表示已经访问过，-1表示重复访问，有环
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, graph, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int from, ArrayList<Integer>[] graph, int[] visited){
        if(visited[from] == 1) return true;//该位置已经访问过，不用重复访问，返回true
        if(visited[from] == -1) return false;//该位置在递归时曾经访问过，表示遇到环，返回false

        //走到这里表示该结点第一次访问，visited = 0

        visited[from] = -1;//先设置-1，如果递归的访问结点的过程中有环，则会再次访问到该位置

        //递归访问邻接结点
        for(int to : graph[from]){
            if(!dfs(to, graph, visited)){
                return false;
            }
        }

        visited[from] = 1;//设置1，所以邻接结点都访问完毕，跳出循环，当前结点设置为已经访问过，下次不会重复访问
        return true;
    }

}
