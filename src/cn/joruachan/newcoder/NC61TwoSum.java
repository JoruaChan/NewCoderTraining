package cn.joruachan.newcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * <strong>题目描述</strong>
 * <p>
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 * <p>
 * <strong>示例1</strong>
 * 输入
 * [3,2,4],6
 * <p>
 * 返回值
 * [2,3]
 *
 * @author JoruaChan
 * @grade 简单
 */
public class NC61TwoSum {
    // 我的思路：一遍遍排序
    // 官方：通过一个数找另外一个数，可以利用哈希表。

    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (map.containsKey(target - number)) {
                int index = map.get(target - number);
                return index < i ? new int[]{index, i} : new int[]{i, index};
            }
            map.put(number, i);
        }
        return new int[0];
    }
}
