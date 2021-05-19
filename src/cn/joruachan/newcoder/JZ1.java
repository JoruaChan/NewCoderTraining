package cn.joruachan.newcoder;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * <p>
 * 给定 target = 3，返回 false。
 * <p>
 * <p>
 * 示例1
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值  true
 * <p>
 * 示例2
 * 3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值  false
 *
 * @author JoruaChan
 */
public class JZ1 {
    // 有序数组，查找元素就应该第一时间想到二分法查找！！！
    // 二维有序数组，就应该注意到左下角和右上角！！！

    public boolean Find(int target, int[][] array) {
        // 从左下角为基准，它上面的肯定比它小，右边的比它大
        // 所以：比它大指针则右移，比它小指针则上移
        if (array.length == 0) return false;
        if (array[0].length == 0) return false;

        int x = 0;
        int y = array.length - 1;
        if (array[y][x] == target) return true;

        while (x >= 0 && x < array[0].length && y >= 0 && y < array.length) {
            if (array[y][x] == target) return true;
            else if (array[y][x] > target) {
                y--;
            } else {
                x++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new JZ1().Find(2, new int[][]{new int[]{1, 1}}));


//        false
//        true
//        false
//        true
//        true
//        true
//        true
//        true
//        true
//        tru


//        java.lang.ArrayIndexOutOfBoundsException: 0
    }
}
