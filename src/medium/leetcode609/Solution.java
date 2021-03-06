package medium.leetcode609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在系统中查找重复文件:
 * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。一组重复的文件至少包括二个具有完全相同内容的文件。
 * 输入列表中的单个目录信息字符串的格式如下：
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * 这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_content）在目录 root/d1/d2/.../dm 下。
 * 注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
 * 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：
 * "directory_path/file_name.txt"
 *
 * 示例 1：
 * 输入：
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * 输出：
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 *  
 * 注：
 * 最终输出不需要顺序。
 * 您可以假设目录名、文件名和文件内容只有字母和数字，并且文件内容的长度在 [1，50] 的范围内。
 * 给定的文件数量在 [1，20000] 个范围内。
 * 您可以假设在同一目录中没有任何文件或目录共享相同的名称。
 * 您可以假设每个给定的目录信息代表一个唯一的目录。目录路径和文件信息用一个空格分隔。
 *  
 *
 * 超越竞赛的后续行动：
 * 假设您有一个真正的文件系统，您将如何搜索文件？广度搜索还是宽度搜索？
 * 如果文件内容非常大（GB级别），您将如何修改您的解决方案？
 * 如果每次只能读取 1 kb 的文件，您将如何修改解决方案？
 * 修改后的解决方案的时间复杂度是多少？其中最耗时的部分和消耗内存的部分是什么？如何优化？
 * 如何确保您发现的重复文件不是误报？
 */
public class Solution {

    /**
     * 哈希表：
     * 1、遍历paths，用空格分割path，取出里面的目录和文件，然后以文件的内容为key，文件的路径为value放入哈希表中
     * 2、遍历哈希表的所有value，当有重复文件组的路径，即value的长度大于1时，才添加到结果中
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] files = path.split(" ");
            String dir = files[0];
            for(int i = 1; i < files.length; i++){
                String file = files[i];
                int index = file.indexOf("(");
                String content = file.substring(index + 1, file.length() - 1);
                String fileName = file.substring(0, index);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(dir + "/" + fileName);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for(List<String> files : map.values()){
            if(files.size() > 1){
                ret.add(files);
            }
        }
        return ret;
    }

}
