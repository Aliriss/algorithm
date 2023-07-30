package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author all
 * @date 2023/1/15 16:49
 */

public class MathUtils {
    /**
     * Object 转 BigDecimal
     * @param value value
     * @return BigDecimal
     */
    public static BigDecimal toBigDecimal(Object value) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (value != null) {
            if (value instanceof BigDecimal) {
                bigDecimal = (BigDecimal) value;
            } else if (value instanceof String) {
                bigDecimal = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                bigDecimal = BigDecimal.valueOf(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
                        + " into a BigDecimal.");
            }
        }
        return bigDecimal;
    }


    /**
     * 加法
     * @param numberArray 数字
     * @return BigDecimal
     */
    public static BigDecimal add(Object... numberArray) {
        BigDecimal res = BigDecimal.ZERO;
        if (numberArray!=null && numberArray.length > 0) {
            for (Object value : numberArray) {
                res = res.add(toBigDecimal((value))).setScale(2, RoundingMode.HALF_UP);
            }
        }
        return res;
    }

}
