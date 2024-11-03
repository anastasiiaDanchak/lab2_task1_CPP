package lab2_CPP;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HolidayManager {
    private Set<LocalDate> holidays = new HashSet<>();

    // Додавання святкового дня
    public void addHoliday(LocalDate holiday) {
        holidays.add(holiday);
    }

    // Перевірка, чи є день святковим
    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }

    // Отримання списку святкових днів (для перевірки)
    public Set<LocalDate> getHolidays() {
        return holidays;
    }
}

