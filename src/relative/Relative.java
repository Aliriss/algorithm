package relative;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author all
 * @date 2022/12/30 14:55
 */

public class Relative {
    /**
     * 序号从0开始算的
     */
    public static void rank(BigDecimal[] a, int[] r) {
        for (int i = 0; i < a.length; i++) {
            r[i] = 0;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j].compareTo(a[i]) >= 0) {
                    //  >= 0的时候是逆序排序
                    r[i]++;
                } else {
                    r[j]++;
                }
            }
        }
    }

    /**
     * 秩的排序
     */
    public static void rearrange(BigDecimal[] a, int[] r) {
        BigDecimal[] u = new BigDecimal[a.length];
        for (int i = 0; i < a.length; i++) {
            u[r[i]] = a[i];
        }
        a = Arrays.copyOf(u, u.length);
        System.out.println("在方法内排序后：\t" +Arrays.toString(a));
    }

    public static void main(String[] args) {
        BigDecimal[] a = {new BigDecimal(12), new BigDecimal(546), new BigDecimal(13), new BigDecimal(45),
                new BigDecimal(32), new BigDecimal(2), new BigDecimal(2), new BigDecimal(2),new BigDecimal(2), new BigDecimal(2), new BigDecimal(2)};
        BigDecimal[] a_copy = new BigDecimal[a.length];
        // 拷贝一份原数组
        System.arraycopy(a, 0, a_copy, 0, a.length);
        int[] r = new int[a.length];
        // 存放秩序
        rank(a, r);
        // rearrange(a, r);
        System.out.println("原数组 " + Arrays.toString(a_copy));
        System.out.println("数组排序后 " + Arrays.toString(a));
        System.out.println("秩序数组 " + Arrays.toString(r));
        BigDecimal[] array1 = {new BigDecimal(12), new BigDecimal(546), new BigDecimal(13), new BigDecimal(45),
                new BigDecimal(32), new BigDecimal(2), new BigDecimal(2), new BigDecimal(2),new BigDecimal(2), new BigDecimal(2), new BigDecimal(2)};
        BigDecimal[] array2 = {new BigDecimal(12), new BigDecimal(546), new BigDecimal(13), new BigDecimal(45),
                new BigDecimal(32), new BigDecimal(2), new BigDecimal(2), new BigDecimal(2),new BigDecimal(2), new BigDecimal(2), new BigDecimal(2)};
        System.out.println("相关性： " + calculateRelative(array1, array2));
        // 序号从0开始算的。从1开始算就每个元素加1。
        System.out.println("秩次：" + Arrays.toString(getRank(array1)));
        rearrange(array1, getRank(array1));
        System.out.println("方法结束后输出数组：" + Arrays.toString(array1));
    }

    /**
     * 计算两个数组的相关性
     *
     * @param array1 数组1
     * @param array2 数组2
     * @return double
     */
    public static double calculateRelative(BigDecimal[] array1, BigDecimal[] array2) {
        int[] rank1 = getRank(array1);
        int[] rank2 = getRank(array2);
        double rankSum = 0;
        for (int i = 0; i< rank1.length; i++) {
            rankSum += Math.sqrt(rank1[i]-rank2[i]);
        }
        int length = rank1.length;
        return 1-(6.0 * rankSum / (length * (length * length -1)));
    }

    /**
     * 排序并获取秩次数组
     *
     * @param array 数组
     * @return 秩次数组
     */
    public static int[] getRank(BigDecimal[] array) {
        int[] postOrder = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            postOrder[i] = 0;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[i]) >= 0) {
                    postOrder[i]++;
                } else {
                    postOrder[j]++;
                }
            }
        }
        return postOrder;
    }

    /**
     * 计算秩次差
     *
     * @param rank 秩次
     * @return int[]
     */
    public static int[] getRankDifference(int[] rank) {
        // 秩次差
        int[] rankDiff = new int[rank.length];
        for (int i = 0; i < rank.length; i ++) {
            rankDiff[i] = rank[i] - i;
        }
        return rankDiff;
    }
}
