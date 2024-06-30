/*
2 Создайте класс Фильм с полями title, genre и rating. Создайте список фильмов в main.
Создайте метод, группирующий фильмы по жанрам. Создайте метод, группирующий фильмы по рейтингу.
Создайте метод, который получает топ 10 фильмов по рейтингу в заданной категории.
 */

package cinema;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<Cinema> films = List.of(
                new Cinema("In Fire","Action",7),
                new Cinema("In Love","Melodrama",6),
                new Cinema("In Tears","Melodrama",8),
                new Cinema("In Revenge","Action",5),
                new Cinema("In Furious","Thriller",9),
                new Cinema("In Nightmare","Horror",4),
                new Cinema("In Adventure","Action",9),
                new Cinema("In Smiles","Melodrama",10),
                new Cinema("In Desert","Action",7),
                new Cinema("In Forest","Thriller",3),
                new Cinema("In Depth","Horror",5),
                new Cinema("In Flight","Action",9),
                new Cinema("In Joy","Melodrama",10),
                new Cinema("In Fear","Thriller",7),
                new Cinema("In Ocean","Action",8),
                new Cinema("In Awful","Horror",6),
                new Cinema("In Heaven","Melodrama",10)
        );
        System.out.println(getByGenre(films));
        System.out.println();
        System.out.println(getByRating(films));
        System.out.println(getTopByGenre(films, "Action", 5));

    }
    public static Map<String,List<Cinema>> getByGenre(List<Cinema> films){
        return films.stream().collect(Collectors.groupingBy(Cinema::genre));
    }
    public static Map<Integer,List<Cinema>> getByRating(List<Cinema> films) {
        return films.stream().collect(Collectors.groupingBy(Cinema::rating));
    }
    public static List<Cinema> getTopByGenre(List<Cinema> films,String genre, int num) {
        return films.stream().filter(f -> f.genre().equals(genre)).sorted(Comparator.comparing(Cinema::rating).reversed()).limit(num).toList();
    }
}
