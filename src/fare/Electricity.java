package fare;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author all
 * @date 2023/1/1 16:57
 */

public class Electricity {


    public static void main(String[] args) {
        double firstFloorLastMonth = 2756.7;
        double firstFloorThisMonth = 2999.1;
        double secondFloorLastMonth = 2196.5;
        double secondFloorThisMonth = 2340.4;
        double commonLastMonth = 2957.1;
        double commonThisMonth = 3105.7;
        double fare = 0.55;
        System.out.println("上次电量：");
        System.out.println("\t热水器：" + commonLastMonth);
        System.out.println("\t一楼：" + firstFloorLastMonth);
        System.out.println("\t二楼：" + secondFloorLastMonth);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "  电量和电费：");
        System.out.println("\t热水器：" + commonThisMonth);
        double commonFare = BigDecimal.valueOf((commonThisMonth - commonLastMonth) * fare).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println("\t热水器费用：(" + commonThisMonth + "-" + commonLastMonth +  ")x" + fare + "=" + commonFare);
        System.out.println("\t一楼：" + firstFloorThisMonth);
        BigDecimal firstFare = BigDecimal.valueOf(((firstFloorThisMonth - firstFloorLastMonth) * fare)).add(BigDecimal.valueOf(commonFare/2));
        firstFare.setScale(2, RoundingMode.HALF_UP);
        System.out.println("\t一楼电费：(" + firstFloorThisMonth + "-" + firstFloorLastMonth +  ")x" + fare + "+" + commonFare + "/2" + "=" + firstFare.setScale(2, RoundingMode.HALF_UP).doubleValue());
        System.out.println("\t二楼：" + secondFloorThisMonth);
        BigDecimal secontFare = BigDecimal.valueOf(((secondFloorThisMonth - secondFloorLastMonth) * fare)).add(BigDecimal.valueOf(commonFare/2));
        secontFare.setScale(2, RoundingMode.HALF_UP);
        System.out.println("\t二楼电费：(" + secondFloorThisMonth + "-" + secondFloorLastMonth + ")x" + fare + "+" + commonFare + "/2" + "=" + secontFare.setScale(2, RoundingMode.HALF_UP).doubleValue());

    }
}
