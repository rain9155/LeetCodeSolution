package medium.leetcode71;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */
public class Solution {

    /**
     * 首先用正则表达式把path用“/”分隔成一个String[]
     * 然后从左到右遍历这个String[], 遇到“..”就把它压入栈Stack中
     * 遇到单词时，先检查Stack中有没有“..”，如果有忽略这个单词，如果没有就把这个单词加一个“/”压入另外一个栈Stack2中
     * 最后Stack2中的出栈顺序就是要求的正确路径
     */
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        String[] strPath = path.split("/");
        for(int i = strPath.length - 1; i >= 0; i--){
            String s = strPath[i];
            if("..".equals(s)){//遇到“..”就压栈
                stack.push(s);
            }else if(!".".equals(s) && !"/".equals(s) && !"".equals(s)){
                if(stack.isEmpty()){
                    stack2.push(s);
                    stack2.push("/");
                }else {
                    stack.pop();
                }
            }
        }
        if(stack2.isEmpty()){
            builder.append("/");
        }else {
            while (!stack2.isEmpty()){
                builder.append(stack2.pop());
            }
        }
        return builder.toString();
    }

}
