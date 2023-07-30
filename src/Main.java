import utils.generator.GeneratorUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author all
 */
public class Main {

    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        int times = 10;
        for (int i = 0; i < times; i++) {
            list.add(getMap());
        }
        System.out.println("str: " + list);
    }

    /**
     *
     * @return Map<String, T>
     */
    public static Map<String, Object> getMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", GeneratorUtils.generateCN(2));
        map.put("age", GeneratorUtils.generateNumber(BigDecimal.class, 2));
        map.put("hosPatInCount", GeneratorUtils.generateNumber(BigDecimal.class, 2));
        map.put("hosPatOutCount", GeneratorUtils.generateNumber(BigDecimal.class, 2));
        map.put("hosPatCount", GeneratorUtils.generateNumber(BigDecimal.class, 2));
        map.put("outPatCount", GeneratorUtils.generateNumber(BigDecimal.class, 2));
        map.put("hosAvgDays", GeneratorUtils.generateNumber(BigDecimal.class, 2));
        map.put("consultApplyTime", "9:00");
        map.put("patName", GeneratorUtils.generateCN(2));
        map.put("patWardName", GeneratorUtils.generateCN(2));
        map.put("applyStatus", GeneratorUtils.generateCN(2));
        map.put("applyPersonName", GeneratorUtils.generateCN(2));
        map.put("deptNamesInvited", "dept1:"+GeneratorUtils.generateCN(4) +
                ",dept2:" + GeneratorUtils.generateCN(5) +
                ",dept3:" + GeneratorUtils.generateCN(6) +
                ",dept4:" +GeneratorUtils.generateCN(7));
        return map;
    }

    public static List<Map<String, Object>> getMapList() {
        List<Map<String, Object>> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(getMap());
        }
        return res;
    }

    public static void test() {
        System.out.println("test");
    }
}
