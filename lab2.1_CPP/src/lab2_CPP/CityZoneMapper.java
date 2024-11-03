package lab2_CPP;

import java.util.HashMap;
import java.util.Map;

public class CityZoneMapper {
    private static final Map<String, String> cityZoneMap = new HashMap<>();

    static {
        // Міста з їхніми часовими зонами
        cityZoneMap.put("Lviv", "Europe/Kyiv");
        cityZoneMap.put("Kyiv", "Europe/Kyiv");
        cityZoneMap.put("Odessa", "Europe/Kyiv");
        cityZoneMap.put("Kharkiv", "Europe/Kyiv");
        cityZoneMap.put("Dnipro", "Europe/Kyiv");
        cityZoneMap.put("Ternopil", "Europe/Kyiv");

        // Міжнародні міста
        cityZoneMap.put("Barcelona", "Europe/Madrid");
        cityZoneMap.put("Madrid", "Europe/Madrid");
        cityZoneMap.put("Rome", "Europe/Rome");
        cityZoneMap.put("Paris", "Europe/Paris");
        cityZoneMap.put("Berlin", "Europe/Berlin");
        cityZoneMap.put("New York", "America/New_York");
    }

    public static String getZoneForCity(String city) {
        return cityZoneMap.getOrDefault(city, "Unknown"); // Повертає "Unknown", якщо місто не знайдено
    }
}
