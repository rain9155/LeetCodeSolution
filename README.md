# leetCode算法题解

## 题目前的数字是在leetcode中的题目序号

**推荐阅读**：

- [Leetcode题解](https://github.com/azl397985856/leetcode)
- [图解leetcode](https://github.com/ZXZxin/ZXBlog/blob/master/Algorithm/LeetCode/LeetCodeSolutionIndex.md)
- [Leetcode动画](https://github.com/MisterBooo/LeetCodeAnimation)

## 一、数据结构

### 数组

关键思想：双指针，位运算，排序预处理，二分查找

#### 简单：

1、[两数之和](https://leetcode-cn.com/problems/two-sum/)

26、[删除排序数组中的重复项](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode26/Solution.java)

27、[移除元素](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode27/Solution.java)

67、[加一](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode66/Solution.java)

88、[合并两个有序数组](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode88/Solution.java)

118、[杨辉三角](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode118/Solution.java)

119、[杨辉三角 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode119/Solution.java)

167、[两数之和 II - 输入有序数组](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode167/Solution.java)

169、[求众数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode169/Solution.java)

189、[旋转数组](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode189/Solution.java)

268、[缺失数字](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode268/Solution.java)

283、[移动零](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode283/Solution.java)

303、[区域和检索](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode303/Solution.java)

414、[第三大的数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode414/Solution.java)

448、[找到所有数组中消失的数字](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode448/Solution.java)

#### 中等：

11、[盛最多水的容器](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode11/Solution.java)

31、[下一个排列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode31/Solution.java)

48、[旋转图像](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode48/Solution.java)

54、[螺旋矩阵](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode54/Solution.java)

56、[合并区间](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode56/Solution.java)

59、[螺旋矩阵 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode59/Solution.java)

73、[矩阵置零](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode73/Solution.java)

179、[最大数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode179/Solution.java)


### 字符串

关键思想：哈希表，双指针(滑动窗口)

#### 简单：

13、[罗马数字转化为整数](https://github.com/rain9155/LeetCodeSolution/blob/b0618cc851d249e33785f490f9c689ff12d5cc00/src/easy/leetcode13/Solution.java)

14、[最长公共子串](https://github.com/rain9155/LeetCodeSolution/blob/b0618cc851d249e33785f490f9c689ff12d5cc00/src/easy/leetcode14/Solution.java)

28、[字符串匹配](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode28/Solution.java)

35、[报数](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode38/Solution.java)

58、[最后一个单词的长度](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode58/Solution.java)

68、[二进制求和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode67/Solution.java)

125、[验证回文串](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode125/Solution.java)

344、[反转字符串](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode344/Solution.java)

392、[判断子序列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode392/Solution.java)

415、[字符串相加](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode415/Solution.java)

434、[字符串中的单词数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode434/Solution.java)

#### 中等：

5、[最长回文子串](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode5/Solution.java)

6、[Z 字形变换](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode6/Solution.java)

165、[比较版本号](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode165/Solution.java)


### 哈希表

关键思想：映射（map，数组）

#### 简单：

205、[同构字符串](https://github.com/rain9155/LeetCodeSolution/blob/b0618cc851d249e33785f490f9c689ff12d5cc00/src/easy/leetcode205/Solution.java)

217、[存在重复元素](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode217/Solution.java)

219、[存在重复元素 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode219/Solution.java)

242、[有效的字母异位词](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode242/Solution.java)

290、[单词规律](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode290/Solution.java)

349、[两个数组的交集](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode349/Solution.java)

350、[两个数组的交集II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode350/Solution.java)

383、[赎金信](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode383/Solution.java)

387、[字符串中的第一个唯一字符](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode387/Solution.java)

389、[找不同](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode389/Solution.java)

409、[最长回文串](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode409/Solution.java)

#### 中等：

3、[无重复字符的最长子串](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode3/Solution.java)

17、[电话号码的字母组合](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode17/Solution.java)

36、[有效的数独](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode36/Solution.java)

49、[字母异位词分组](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode49/Solution.java)

187、[重复的DNA序列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode187/Solution.java)


### 链表

关键思想：快慢指针，双指针，递归（相当于链表的前序、后序遍历，栈的思想），哈希表

#### 简单：

21、[合并两个有序链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode21/Solution.java)

83、[删除排序链表中的重复元素](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode83/Solution.java)

141、[环形链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode141/Solution.java)

160、[相交链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode160/Solution.java)

203、[移除链表元素](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode203/Solution.java)

206、[反转链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode206/Solution.java)

234、[回文链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode234/Solution.java)

237、[删除链表中的节点](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode237/Solution.java)

#### 中等：

61、[旋转链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode61/Solution.java)

92、[反转链表 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode92/Solution.java)

138、[复制带随机指针的链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode138/Solution.java)

142、[环形链表 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode142/Solution.java)

143、[重排链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode143/Solution.java)

147、[对链表进行插入排序](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode147/Solution.java)

148、[排序链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode148/Solution.java)

### 树

关键思想：bfs，dfs，树的遍历(前序、中序、后序、层次)，递归，分治法，链表

#### 简单：

100、[相同的树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode100/Solution.java)

101、[对称二叉树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode101/Solution.java)

104、[二叉树的最大深度](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode104/Solution.java)

107、[二叉树的层次遍历 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode107/Solution.java)

108、[将有序数组转换为二叉搜索树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode108/Solution.java)

110、[平衡二叉树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode110/Solution.java)

111、[二叉树的最小深度](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode111/Solution.java)

112、[路径总和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode112/Solution.java)

226、[翻转一棵二叉树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode226/Solution.java)

235、[二叉搜索树的最近公共祖先](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode235/Solution.java)

257、[二叉树的所有路径](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode257/Solution.java)

404、[左叶子之和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode404/Solution.java)

437、[路径总和 III](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode437/Solution.java)

#### 中等：

94、[二叉树的中序遍历](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode94/Solution.java)

95、[不同的二叉搜索树 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode95/Solution.java)

98、[验证二叉搜索树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode98/Solution.java)

102、[二叉树的层次遍历](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode102/Solution.java)

103、[二叉树的锯齿形层次遍历](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode103/Solution.java)

105、[从前序与中序遍历序列构造二叉树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode105/Solution.java)

106、[从中序与后序遍历序列构造二叉树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode106/Solution.java)

109、[有序链表转换二叉搜索树](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode109/Solution.java)

114、[二叉树展开为链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode114/Solution.java)

116、[填充每个节点的下一个右侧节点指针](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode116/Solution.java)

117、[填充每个节点的下一个右侧节点指针 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode117/Solution.java)

129、[求根到叶子节点数字之和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode129/Solution.java)

144、[二叉树的前序遍历](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode144/Solution.java)

166、[二叉搜索树迭代器](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode166/BSTlterator.java)


### 栈、队列

关键思想：递归，遍历，辅助栈

#### 简单：

20、[有效的括号](https://github.com/rain9155/LeetCodeSolution/blob/b0618cc851d249e33785f490f9c689ff12d5cc00/src/easy/leetcode20/Solution.java)

155、[最小栈](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode155/MinStack.java)

225、[用队列实现栈](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode225/MyStack.java)

232、[用栈实现队列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode232/MyQueue.java)

#### 中等：

71、[简化路径](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode71/Solution.java)

150、[逆波兰表达式求值](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode150/Solution.java)


394、[字符串解码](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode394/Solution.java)

### 图

关键思想：dfs，bfs，拓扑

#### 简单:

#### 中等：

133、[克隆图](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode133/Solution.java)

207、[课程表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode207/Solution.java)

210、[课程表 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode210/Solution.java)


## 二、算法思维

### 动态规划

关键思想：递归 + 备忘录，dp数组(一维，二维)

#### 简单：

53、[最大子序和](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode53/Solution.java)

70、[爬楼梯](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode70/Solution.java)

121、[买卖股票的最佳时机](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode121/Solution.java)

122、[买卖股票的最佳时机II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode122/Solution.java)

198、[打家劫舍](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode198/Solution.java)

#### 中等：

62、[不同路径](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode62/Solution.java)

63、[不同路径 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode63/Solution.java)

64、[最小路径和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode64/Solution.java)

91、[解码方法](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode91/Solution.java)

120、[三角形最小路径和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode120/Solution.java)

139、[单词拆分](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode139/Solution.java)

152、[乘积最大子序列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode152/Solution.java)

### 贪心算法

#### 简单：

#### 中等：

55、[跳跃游戏](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode55/Solution.java)

134、[加油站](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode134/Solution.java)

### 博弈问题

关键思想：极大极小化

#### 简单：

292、[Nim 游戏](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode292/Solution.java)

#### 中等:

375、[猜数字大小 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode375/Solution.java)

464、[我能赢吗](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode464/Solution.java)

486、[预测赢家](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode486/Solution.java)

877、[石子游戏](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode877/Solution.java)

### 双指针

关键思想：双指针、三指针、快慢指针

#### 简单：

#### 中等：

15、[三数之和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode15/Solution.java)

16、[最接近的三数之和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode16/Solution.java)

18、[四数之和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode18/Solution.java)

19、[删除链表的倒数第N个节点](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode19/Solution.java)

24、[两两交换链表中的节点](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode24/Solution.java)

75、[颜色分类](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode75/Solution.java)

80、[删除排序数组中的重复项 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode80/Solution.java)

82、[删除排序链表中的重复元素 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode82/Solution.java)

86、[分隔链表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode86/Solution.java)

151、[翻转字符串里的单词](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode151/Solution.java)

### 回溯算法：

关键思想：字符串，递归

#### 简单：

#### 中等：

22、[括号生成](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode22/Solution.java)

39、[组合总和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode39/Solution.java)

40、[组合总和 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode40/Solution.java)

46、[全排列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode46/Solution.java)

47、[全排列 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode47/Solution.java)

60、[第k个排列](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode60/Solution.java)

77、[组合](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode77/Solution.java)

78、[子集](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode78/Solution.java)

90、[子集 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode90/Solution.java)

113、[路径总和 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode113/Solution.java)

131、[分割回文串](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode131/Solution.java)

### 搜索算法

关键思想：dfs，bfs，二分查找

#### 简单：

35、[搜索插入位置](https://github.com/rain9155/LeetCodeSolution/blob/76f3bf73ff16ec170b9b9aac5e40b1bdbbf57828/src/easy/leetcode35/Solution.java)

69、[x的平方根](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode69/Solution.java)

374、[猜数字大小](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode374/Solution.java)

367、[有效的完全平方数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode367/Solution.java)

#### 中等：

33、[搜索旋转排序数组](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode33/Solution.java)

34、[在排序数组中查找元素的第一个和最后一个位置](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode34/Solution.java)

74、[搜索二维矩阵](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode74/Solution.java)

79、[单词搜索](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode79/Solution.java)

81、[搜索旋转排序数组 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode81/Solution.java)

127、[单词接龙](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode127/Solution.java)

130、[被围绕的区域](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode130/Solution.java)

153、[寻找旋转排序数组中的最小值](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode153/Solution.java)

162、[寻找峰值](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode162/Solution.java)

199、[二叉树的右视图](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode199/Solution.java)

200、[岛屿数量](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode200/Solution.java)


### 数学

关键思想：找数学规律，位运算

#### 简单：

7、[整数反转](https://github.com/rain9155/LeetCodeSolution/blob/9561243dff12b3e091db788f766c6d0da1564ffc/src/easy/leetcode7/Solution.java)

9、[回文数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode9/Solution.java)

168、[Excel表列名称](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode168/Solution.java)

171、[Excel表列序号](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode171/Solution.java)

172、[阶乘后的零](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode172/Solution.java)

202、[快乐数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode202/Solution.java)

204、[计数质数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode204/Solution.java)

258、[各位相加](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode258/Solution.java)

263、[丑数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode263/Solution.java)

326、[3的幂](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode326/Solution.java)



575、[分糖果](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode575/Solution.java)

#### 中等：

8、[字符串转换整数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode8/Solution.java)

12、[整数转罗马数字](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode12/Solution.java)

29、[两数相除](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode29/Solution.java)

43、[字符串相乘](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode43/Solution.java)

50、[Pow(x, n)](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode50/Solution.java)

166、[分数到小数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode166/Solution.java)


### 位运算

关键思想：n & 1， n & (n - 1),  >> ， << ， ^ 

#### 简单：

136、[只出现一次的数字](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode136/Solution.java)

190、[颠倒二进制位](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode190/Solution.java)

191、[1的个数](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode191/Solution.java)

231、[2的幂](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode231/Solution.java)

342、[4的幂](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode342/Solution.java)

371、[两整数之和](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode371/Solution.java)

401、[二进制手表](https://github.com/rain9155/LeetCodeSolution/blob/master/src/easy/leetcode401/Solution.java)

#### 中等：

89、[格雷编码](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode89/Solution.java)

137、[只出现一次的数字 II](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode137/Solution.java)

201、[数字范围按位与](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode201/Solution.java)

## 三、其他

146、[LRU缓存机制](https://github.com/rain9155/LeetCodeSolution/blob/master/src/medium/leetcode146/LRUCache.java)



