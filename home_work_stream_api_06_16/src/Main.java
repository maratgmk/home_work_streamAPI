/*
Домашнее задание по Stream API:
1 Дан текст. Подсчитайте количество уникальных слов в этом тексте.
2 Создайте класс Фильм с полями title, genre и rating. Создайте список фильмов в main.
Создайте метод, группирующий фильмы по жанрам. Создайте метод, группирующий фильмы по рейтингу.
Создайте метод, который получает топ 10 фильмов по рейтингу в заданной категории.
3 Дан список дат. Преобразуйте его в список дней недели.
4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.
5 Дан список адресов с полями street, city и zipCode. Создайте список уникальных городов.
6 Дана мапа, где ключ – id задачи, а значение – список записей о работе.
 Запись о работе содержит id сотрудника и время, затраченное на задачу.
 Подсчитайте общее время выполнения каждой задачи. Подсчитайте суммарное время выполнения всех задач.
 */


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> text = Arrays.asList(("/*\n" +
                "Домашнее задание по Stream API:\n" +
                "1 Дан текст. Подсчитайте количество уникальных слов в этом тексте.\n" +
                "2 Создайте класс Фильм с полями title, genre и rating. Создайте список фильмов в main.\n" +
                "Создайте метод, группирующий фильмы по жанрам. Создайте метод, группирующий фильмы по рейтингу.\n" +
                "Создайте метод, который получает топ 10 фильмов по рейтингу в заданной категории.\n" +
                "3 Дан список дат. Преобразуйте его в список дней недели.\n" +
                "4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.\n" +
                "5 Дан список адресов с полями street, city и zipCode. Создайте список уникальных городов.\n" +
                "6 Дана мапа, где ключ – id задачи, а значение – список записей о работе.\n" +
                " Запись о работе содержит id сотрудника и время, затраченное на задачу.\n" +
                " Подсчитайте общее время выполнения каждой задачи. Подсчитайте суммарное время выполнения всех задач.\n" +
                " */").split("\n"));
        System.out.println(text);
        // System.out.println(text.stream().map(s -> Arrays.stream(s.split(","))).toList());
        System.out.println(getUnique(text));
        System.out.println(getUniqueI(text));
        System.out.println();

        List<String> sentences = List.of(
                "An apple is pineapple but not apple",
                "apple is fresh apple",
                "pineaaple is sweet pineapple"
        );
        System.out.println(getUnique(sentences));
        System.out.println(getUniqueI(sentences));


    }


    public static int getUnique(List<String> text) {
        return text.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toSet()).size();
    }
    public static int getUniqueI(List<String> text) {
        return text.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().toList().size();
    }
}