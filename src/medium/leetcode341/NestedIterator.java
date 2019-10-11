package medium.leetcode341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器:
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的项或者为一个整数，或者是另一个列表。
 *
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
 */

/**
 * 递归 + List
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> datas = new ArrayList<>();
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return datas.get(index++);
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return index < datas.size();
    }

    /**
     * 根据nestedList递归构造List
     */
    private void helper(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                datas.add(nestedInteger.getInteger());
            }else{
                helper(nestedInteger.getList());
            }
        }
    }

    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
