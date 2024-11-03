package lab2_CPP;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SellerData {

    public static Seller getSellerData(String sellerName) {
        Seller seller = new Seller();
        
        switch (sellerName) {
            case "Orest":
                seller.setWorkingDays(new DayOfWeek[]{DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY});
                seller.setOpeningTime(LocalTime.of(10, 0)); // 10:00
                seller.setClosingTime(LocalTime.of(21, 0));  // 21:00
                seller.setAverageDeliveryDays(3);  // встановлення середнього часу доставки
                break;
            case "Natalia":
                seller.setWorkingDays(new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY});
                seller.setOpeningTime(LocalTime.of(9, 0));  // 09:00
                seller.setClosingTime(LocalTime.of(20, 0)); // 20:00
                seller.setAverageDeliveryDays(2);  // встановлення середнього часу доставки
                break;
            case "Oleksandr":
                seller.setWorkingDays(new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY});
                seller.setOpeningTime(LocalTime.of(10, 0)); // 10:00
                seller.setClosingTime(LocalTime.of(20, 0)); // 20:00
                seller.setAverageDeliveryDays(4);  // встановлення середнього часу доставки
                break;
            case "Halyna":
                seller.setWorkingDays(new DayOfWeek[]{DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.SATURDAY});
                seller.setOpeningTime(LocalTime.of(8, 0));  // 08:00
                seller.setClosingTime(LocalTime.of(18, 0)); // 18:00
                seller.setAverageDeliveryDays(5);  // встановлення середнього часу доставки
                break;
            default:
                throw new IllegalArgumentException("Unknown seller");
        }
        
        return seller;
    }
}
