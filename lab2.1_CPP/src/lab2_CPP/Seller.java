package lab2_CPP;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class Seller {
    private DayOfWeek[] workingDays;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private int averageDeliveryDays;


    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setAverageDeliveryDays(int averageDeliveryDays) {
        this.averageDeliveryDays = averageDeliveryDays;
    }

    public int getAverageDeliveryDays() {
        return averageDeliveryDays;
    }

    public void setWorkingDays(DayOfWeek[] workingDays) {
        this.workingDays = workingDays;
    }

    public DayOfWeek[] getWorkingDays() {
        return workingDays;
    }
}
