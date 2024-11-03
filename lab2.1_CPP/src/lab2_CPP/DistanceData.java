package lab2_CPP;

import java.util.HashMap;
import java.util.Map;

public class DistanceData {
    private static final Map<String, Integer> distanceMap = new HashMap<>();

    static {
        // Додавання відстаней (у кілометрах) від Львова до різних поштових відділень
        distanceMap.put("Lviv", 0);        // Львів - магазин
        distanceMap.put("Kyiv", 540);      // 540 км від Львова до Києва
        distanceMap.put("Odessa", 790);    // 790 км від Львова до Одеси
        distanceMap.put("Kharkiv", 1000);  // 1000 км від Львова до Харкова
        distanceMap.put("Dnipro", 900);    // 900 км від Львова до Дніпра
        distanceMap.put("Ternopil", 130);  // 130 км від Львова до Тернополя

        // Додавання міжнародних відстаней
        distanceMap.put("Barcelona", 2000);  // 2000 км від Львова до Барселони
        distanceMap.put("Madrid", 2500);      // 2500 км від Львова до Мадрида
        distanceMap.put("Rome", 1500);        // 1500 км від Львова до Риму
        distanceMap.put("Paris", 1700);       // 1700 км від Львова до Парижа
        distanceMap.put("Berlin", 1200);      // 1200 км від Львова до Берліна
        distanceMap.put("New York", 6000);
    }

    public static int getDistanceToLocation(String location) {
        return distanceMap.getOrDefault(location, -1);  // Якщо місце не знайдене, повертаємо -1
    }
}
