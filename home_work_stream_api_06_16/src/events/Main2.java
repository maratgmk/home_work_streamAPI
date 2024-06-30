/*
3 Дан список дат. Преобразуйте его в список дней недели.
4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.
 */

package events;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.OptionalLong;

public class Main2 {
    public static void main(String[] args) {
        List<LocalDate> dates = List.of(
                LocalDate.of(1789, 7, 14),
                LocalDate.of(1825, 12, 5),
                LocalDate.of(1925, 10, 25),
                LocalDate.of(2025, 9, 15),
                LocalDate.of(1917, 11, 7),
                LocalDate.of(0, 1, 1)
        );
        System.out.println(getDayOfWeek(dates));

        List<Event> events = List.of(
                new Event("Взятие Бастилии", LocalDate.of(1789, 7, 14)),
                new Event("Рождение Йешуа", LocalDate.of(0, 1, 1)),
                new Event("Переворот", LocalDate.of(1917, 11, 7)),
                new Event("Бозон Хиггса", LocalDate.of(2012, 7, 4)),
                new Event("Спец_Теория Относительности", LocalDate.of(1905, 9, 1)),
                new Event("Создание языка Java", LocalDate.of(1995, 5, 23))
        );

        LocalDate startDate = LocalDate.of(2023, 11, 23);
        LocalDate endDate = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Days between: " + daysBetween);

        Period period = Period.between(startDate, endDate);


        System.out.println("Duration between " + startDate + " and " + endDate + ":");
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

        System.out.println("С открытия бозона Хиггса прошло дней " + findNearestToNow(events));
    }

    public static List<DayOfWeek> getDayOfWeek(List<LocalDate> dates) {
        return dates.stream().map(LocalDate::getDayOfWeek).toList();
    }
    public static OptionalLong findNearestToNow(List<Event> events) {
        LocalDate endDate = LocalDate.now();
        return  events.stream().map(e -> e.date()).mapToLong(d -> (ChronoUnit.DAYS.between(d,endDate))).min();
    }
}
