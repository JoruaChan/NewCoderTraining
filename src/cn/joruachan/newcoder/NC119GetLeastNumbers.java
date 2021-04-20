package cn.joruachan.newcoder;

import java.util.ArrayList;

/**
 * 题目描述：
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * <p>
 * 示例1：
 * 输入
 * [4,5,1,6,2,7,3,8],4
 * 返回值
 * [1,2,3,4]
 *
 * @author JoruaChan
 * @grade 中等
 */
public class NC119GetLeastNumbers {
    // 我的思路：第一反应使用分治法，每次都分一半得到最小的四个元素，但是每次分一半都得重新比较，效率不高；
    // 第二反应使用快速排序，但是数量级大点的时候才适用；
    // 第三反应使用选择排序，选择K次能结束；

    // TODO: 堆排序， 使用优先级队列实现；
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length) return new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int minIndex;
            if (i + 1 == input.length) {
                minIndex = i;
            } else {
                // 选出最小的数
                minIndex = i;

                for (int j = i + 1; j < input.length; j++) {
                    if (input[j] <= input[minIndex]) {
                        minIndex = j;
                    }
                }
            }

            // 交换下位置
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;

            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new NC119GetLeastNumbers().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }

//    private void fastSort(int [] input, int left, int right) {
//        while (left != right) {
//            // 交换下
//            int temp = input[right];
//            input[right] = input[left];
//            input[left] = temp;
//
//            if (input[left] > input[right]) {
//
//                --right;
//            } else {
//                ++left;
//            }
//        }
//    }
}
