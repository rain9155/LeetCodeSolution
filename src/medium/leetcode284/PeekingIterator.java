package medium.leetcode284;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 数组 + 双指针
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
