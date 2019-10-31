package medium.leetcode388;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件的最长绝对路径:
 * 假设我们以下述方式将我们的文件系统抽象成一个字符串:
 *
 * 字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 * 目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。
 *
 * 字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示:
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *             file2.ext
 * 目录 dir 包含两个子目录 subdir1 和 subdir2。 subdir1 包含一个文件 file1.ext 和一个空的二级子目录 subsubdir1。subdir2 包含一个二级子目录 subsubdir2 ，其中包含一个文件 file2.ext。
 *
 * 我们致力于寻找我们文件系统中文件的最长 (按字符的数量统计) 绝对路径。例如，在上述的第二个例子中，最长路径为 "dir/subdir2/subsubdir2/file2.ext"，其长度为 32 (不包含双引号)。
 * 给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
 *
 * 说明:
 * 文件名至少存在一个 . 和一个扩展名。
 * 目录或者子目录的名字不能包含 .。
 * 要求时间复杂度为 O(n) ，其中 n 是输入字符串的大小。
 *
 * 请注意，如果存在路径 aaaaaaaaaaaaaaaaaaaaa/sth.png 的话，那么  a/aa/aaa/file1.txt 就不是一个最长的路径。
 */
public class Solution {

    private List<String> output = new ArrayList<>();

    public int lengthLongestPath(String input) {
        if(input.length() == 0) return 0;
        input = input.replace("\n    ","\n\t");
        lengthLongestPath(input, new LinkedList<>(), "",  0, 0);
        return output.size() + (output.size() - 1);
    }

    private int lengthLongestPath(String input, LinkedList<String> tempList, String fileName, int start, int lever){
        if(start >= input.length()){
            return input.length() - 1;
        }
        if(tempList.size() != 0){
            if(lever <= tempList.size()){
                if (fileName.contains(".")) {//是文件
                    if (tempList.size() > output.size()) {
                        output = new ArrayList<>(tempList);
                    }
                }
                return fileName.length() + lever * 2;
            }
            //当层数 大于 目前最大层数，表示属于子目录
        }
        int i = start;
        int nextLever = 0;
        int preStart = start;
        while (i <= input.length()){
            if(i == input.length() || input.charAt(i) == '\\') {
                String curFile = input.substring(start, i);//取出子目录
                tempList.add(curFile);//添加到文件路径
                nextLever = lever(input, i);//计算下一层的层数
                int nextSkip = nextLever * 2;
                int skip = lengthLongestPath(input, tempList,  curFile, i + nextSkip, nextLever);
                tempList.removeLast();
                int tempLever = (skip - curFile.length()) / 2;
                if(tempLever == lever){//同级目录
                    start = i + nextSkip;
                    i += (skip + nextSkip);
                    continue;
                }else{//不是同级目录，回溯到上一层，并返回需要跳过的字符数
                    return i - preStart + skip - curFile.length();
                }

            }
            i++;
        }
        return i + nextLever * 2;
    }


    private int lever(String input, int start){
        if(start >= input.length()){
            return 0;
        }
        int count = 0;
        while (
                start < input.length() &&
                (input.charAt(start) == '\\' || input.charAt(start) == 'n' || input.charAt(start) == 't')){
            start++;
            count++;
        }
        return count / 2;
    }

}
