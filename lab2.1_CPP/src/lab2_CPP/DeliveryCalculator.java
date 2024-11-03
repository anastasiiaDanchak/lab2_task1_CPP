package lab2_CPP;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.DayOfWeek;



public class DeliveryCalculator {

    // Обчислення найближчого робочого дня для продавця
    public static LocalDate calculateNextWorkingDay(LocalDate orderDate, Seller seller, HolidayManager holidayManager, LocalTime orderTime) {
        LocalDate nextWorkingDay = orderDate;

        // Перевірка на робочий день, свято і робочі години
        while (true) {
            if (isWorkingDay(nextWorkingDay, seller.getWorkingDays()) && !holidayManager.isHoliday(nextWorkingDay)) {
                if (isWithinWorkingHours(nextWorkingDay, seller.getOpeningTime(), seller.getClosingTime(), orderTime)) {
                    break; // Знайдено наступний робочий день
                }
            }
            nextWorkingDay = nextWorkingDay.plusDays(1); // Перехід на наступний день
        }

        return nextWorkingDay;
    }

    // Перевірка, чи є день робочим
    private static boolean isWorkingDay(LocalDate date, DayOfWeek[] workingDays) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        for (DayOfWeek workingDay : workingDays) {
            if (dayOfWeek == workingDay) {
                return true;
            }
        }
        return false;
    }

    // Перевірка, чи знаходиться час замовлення в робочих годинах
    private static boolean isWithinWorkingHours(LocalDate date, LocalTime openingTime, LocalTime closingTime, LocalTime orderTime) {
        return !orderTime.isBefore(openingTime) && !orderTime.isAfter(closingTime);
    }

    // Обчислення дати доставки з урахуванням типу доставки
    public static LocalDate calculateFinalDeliveryDate(
            LocalDate nextWorkingDay, Seller seller, String deliveryMethod, String location, String deliveryType, ZoneId buyerTimeZone) {

        int additionalDays = deliveryMethod.equalsIgnoreCase("Express") ? 1 : seller.getAverageDeliveryDays();
        int distance = DistanceData.getDistanceToLocation(location);

        if (distance == -1) {
            throw new IllegalArgumentException("Unknown location: " + location);
        }

        // Продавець завжди в українській часовій зоні (Europe/Kyiv)
        ZoneId sellerZone = ZoneId.of("Europe/Kyiv");
        ZonedDateTime sellerZonedDateTime = ZonedDateTime.of(nextWorkingDay, seller.getOpeningTime(), sellerZone);

        ZonedDateTime finalDeliveryDateTime;

        // Якщо доставка міжнародна, враховуємо часову зону покупця
        if (deliveryType.equalsIgnoreCase("International")) {
            ZonedDateTime buyerZonedDateTime = sellerZonedDateTime.withZoneSameInstant(buyerTimeZone);
            finalDeliveryDateTime = buyerZonedDateTime.plusDays(additionalDays + (distance / 200));
        } else {
            // Якщо доставка по Україні — використовуємо лише київський час
            finalDeliveryDateTime = sellerZonedDateTime.plusDays(additionalDays + (distance / 200));
        }

        return finalDeliveryDateTime.toLocalDate();
    }
}
