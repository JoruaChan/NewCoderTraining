package cn.joruachan.newcoder;

import java.util.*;

/**
 * 题目描述:
 * <p>
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * <p>
 * <p>
 * 示例1
 * 输入
 * [2,3,4,5]
 * 返回值
 * 4
 * <p>
 * 示例2
 * 输入
 * [2,2,3,4,3]
 * 返回值
 * 3
 * <p>
 * 备注:
 * 1 ≤n≤10^5
 *
 * @author JoruaChan
 */
public class NC140MaxLength {
    // 我的思路，感觉像是个动态规划问题，但是动态规划不熟悉。
    // 一次遍历即可：前一次判断能确定不存在重复，如果这次发现重复则将这个值remove掉并且len-1继续判断，
    // 如果不重复则继续循环

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        int maxLength = 0, tempLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            if (map.containsKey(i)) {
                // 包含了，则先记录长度
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }

                // 然后找到重复的下标
                Integer index = map.get(i);
                for (int j = 0; j < index; j++) {
                    map.remove(arr[j]);
                }

                tempLength = map.size();
            } else {
                map.put(value, i);
                tempLength++;
            }
        }
        if (tempLength > maxLength) {
            maxLength = tempLength;
        }
        return maxLength;
    }

}
