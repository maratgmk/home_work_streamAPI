/*
5 Дан список адресов с полями street, city и zipCode. Создайте список уникальных городов.
 */

package address;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<Address> points = List.of(
                new Address("Green","New York", 12345),
                new Address("Red","New Orleans", 22345),
                new Address("Yellow","New Harlem", 33345),
                new Address("Blue","New Apple", 44345),
                new Address("Pink","New Vasyuki", 99345),
                new Address("Black","New Pumpkin", 77345),
                new Address("Gray","New York", 11345),
                new Address("White","New Orleans", 22335),
                new Address("Purple","New Apple", 44435)
        );
        System.out.println(getUniqueCity(points));
        System.out.println(getUniqueCityI(points));

    }
    public static List<String> getUniqueCity(List<Address> points) {
        return points.stream().map(Address::city).distinct().toList();
    }

    public static Set<String> getUniqueCityI(List<Address> points) {
        return points.stream().map(Address::city).collect(Collectors.toSet());
    }
}
