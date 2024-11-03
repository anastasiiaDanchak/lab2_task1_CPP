package lab2_CPP;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  

        try {
            // Введення даних про замовлення
            System.out.println("Enter the order date (yyyy-MM-dd): ");
            LocalDate orderDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            System.out.println("Enter the order time (HH:mm): ");
            LocalTime orderTime = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));

            // Введення даних про продавця
            System.out.println("Choose a seller (e.g., Orest, Natalia, Oleksandr, Halyna): ");
            String sellerName = scanner.nextLine();
            Seller seller = SellerData.getSellerData(sellerName);

            if (seller == null) {
                throw new IllegalArgumentException("Invalid seller name");
            }

            // Вибір типу доставки
            System.out.println("Choose delivery type: 1 - Domestic, 2 - International: ");
            int deliveryChoice = scanner.nextInt();
            scanner.nextLine(); 
            String deliveryType;
            if (deliveryChoice == 1) {
                deliveryType = "Domestic"; // Доставка по Україні
            } else if (deliveryChoice == 2) {
                deliveryType = "International"; // Міжнародна доставка
            } else {
                throw new IllegalArgumentException("Invalid delivery type");
            }

            // Введення локації для доставки
            System.out.println("Enter your city (for delivery): ");
            String city = scanner.nextLine();
            String timeZoneString = CityZoneMapper.getZoneForCity(city); // Виклик статичного методу
            if (timeZoneString.equals("Unknown")) {
                throw new IllegalArgumentException("Unknown city: " + city);
            }
            ZoneId buyerTimeZone = ZoneId.of(timeZoneString);

            // Вибір методу доставки
            System.out.println("Choose delivery method: 1 - Express, 2 - Standard: ");
            int methodChoice = scanner.nextInt();
            scanner.nextLine(); 

            String deliveryMethod;
            if (methodChoice == 1) {
                deliveryMethod = "Express";
            } else if (methodChoice == 2) {
                deliveryMethod = "Standard";
            } else {
                throw new IllegalArgumentException("Invalid delivery method");
            }

            // Створення об'єкта HolidayManager
            HolidayManager holidayManager = new HolidayManager();
            holidayManager.addHoliday(LocalDate.of(2024, 1, 1)); 
            holidayManager.addHoliday(LocalDate.of(2024, 12, 25));
            holidayManager.addHoliday(LocalDate.of(2024, 4, 21));
            
            // Обчислення найближчого робочого дня продавця
            LocalDate nextWorkingDay = DeliveryCalculator.calculateNextWorkingDay(orderDate, seller, holidayManager, orderTime);

            // Обчислення кінцевої дати доставки
            LocalDate finalDeliveryDate = DeliveryCalculator.calculateFinalDeliveryDate(
                nextWorkingDay, seller, deliveryMethod, city, deliveryType, buyerTimeZone);

            // Виведення дати доставки
            System.out.println("Expected delivery date: " + finalDeliveryDate);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); 
        }
    }
}
