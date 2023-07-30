package utils.generator;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Random;

/**
 * @author all
 * @date 2023/3/3 9:44
 */

public class GeneratorUtils {
    public static final Random RANDOM = new Random();

    /**
     * 获取汉字
     * <pre>
     * GB2312 中对所收汉字进行了“分区”处理，每区含有 94 个汉字/符号。这种表示方式也称为区位码。
     *  01 - 09 区为特殊符号。
     *  16 - 55 区为一级汉字，按拼音排序。
     *  56 - 87 区为二级汉字，按部首/笔画排序。
     *  10 - 15 区及 88 - 94 区则未有编码。
     * 例如：'啊': 1601
     * </pre>
     *
     * @param bit 长度
     * @return String
     */
    public static String generateCN(int... bit) {
        int time = bit.length > 0 ? bit[0] : Math.abs(RANDOM.nextInt(10)) + 1;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < time; i++) {
            byte[] b = new byte[2];
            // 高位，B0 + 0~39(16~55) 一级汉字所占区
            b[0] = (Integer.valueOf(176 + Math.abs(RANDOM.nextInt(39)))).byteValue();
            // 地位，A1 + 0~93 每区有94个汉字
            b[1] = (Integer.valueOf(161 + Math.abs(RANDOM.nextInt(93)))).byteValue();
            try {
                res.append(new String(b, "GBK"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return res.toString();
    }

    public static <T> T generateNumber(Class<T> c, int... bit) {
        Object num = null;
        if (c == Long.class || c == long.class) {
            num = RANDOM.nextLong();
        } else if (c == Integer.class || c == int.class) {
            num = RANDOM.nextInt();
        } else if (c == Double.class || c == double.class) {
            num = RANDOM.nextDouble();
        } else if (c == Float.class || c == float.class) {
            num = RANDOM.nextFloat();
        } else if (c == BigDecimal.class) {
            num = BigDecimal.ZERO;
        }
        return (T)num;
    }
}
