/*
4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.
 */

package events;

import java.time.LocalDate;

public record Event(String name, LocalDate date) {
}
