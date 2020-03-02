package medium.leetcode284;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 顶端迭代器:
 * 给定一个迭代器类的接口，接口包含两个方法: next() 和 hasNext()。
 * 设计并实现一个支持 peek() 操作的顶端迭代器
 * 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 *
 * 示例:
 * 假设迭代器被初始化为列表 [1,2,3]。
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 *
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 */

/**
 * 数组 + 双指针:
 */
public class PeekingIterator implements Iterator<Integer> {

    int len = 10;
    Integer[] datas = new Integer[len];
    int cur = 0;
    int size = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        while (iterator.hasNext()){
            if(size == len){
                grow();
            }
            datas[size++] = iterator.next();
        }
    }

    private void grow() {
        int newLen = len > Integer.MAX_VALUE >> 1 ? Integer.MAX_VALUE : len << 1;
        datas = Arrays.copyOf(datas, newLen);
        len = newLen;
    }

    public Integer peek() {
        return datas[cur];
    }

    @Override
    public Integer next() {
        return datas[cur++];
    }

    @Override
    public boolean hasNext() {
        return cur != size;
    }

}
