/*
6 Дана мапа, где ключ – id задачи, а значение – список записей о работе.
 Запись о работе содержит id сотрудника и время, затраченное на задачу.
 Подсчитайте общее время выполнения каждой задачи. Подсчитайте суммарное время выполнения всех задач.
 */

package problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        List<Problem> problems = List.of(
                new Problem(21,37),
                new Problem(32,19),
                new Problem(43,41),
                new Problem(14,11),
                new Problem(52,6),
                new Problem(16,175),
                new Problem(71,371)
        );
        Map<Integer,List<Problem>> numToProblem = new HashMap<>();
        numToProblem.put(1,List.of(problems.getFirst(),problems.get(2)));
        numToProblem.put(2,List.of(problems.getFirst(),problems.get(5)));
        numToProblem.put(3,List.of(problems.getFirst(),problems.get(6),problems.get(3)));
        numToProblem.put(4,List.of(problems.getFirst(),problems.get(2),problems.get(4),problems.get(5)));
        numToProblem.put(5,List.of(problems.getFirst(),problems.get(1),problems.get(6)));
        numToProblem.put(6,List.of(problems.getFirst(),problems.get(1),problems.getLast()));
        numToProblem.put(7,List.of(problems.getFirst(),problems.get(2),problems.get(3),problems.get(5),problems.get(6)));
        numToProblem.put(8,List.of(problems.getFirst(),problems.get(4),problems.getLast()));
        numToProblem.put(9,List.of(problems.getFirst(),problems.get(1),problems.get(2),problems.get(3)));
        numToProblem.put(10,List.of(problems.getFirst(),problems.get(2),problems.get(5),problems.get(6),problems.get(3)));
        numToProblem.put(11,List.of(problems.getFirst(),problems.get(1),problems.get(4),problems.get(5),problems.get(6)));
        numToProblem.put(12,List.of(problems.getFirst(),problems.get(2),problems.get(1),problems.get(3),problems.get(5),problems.get(6),problems.getLast()));

        System.out.println(getTimeOfTask(numToProblem));
        System.out.println(getTotalTime(numToProblem));
        System.out.println(getTotalTimeI(numToProblem));

    }
    public static List<Integer> getTimeOfTask(Map<Integer,List<Problem>> numToProblem){
        return numToProblem.entrySet().stream()
                .map(entry -> entry.getValue().stream().map(Problem::hours).mapToInt(hour -> hour.intValue()).sum()).toList();
    }
    public static int getTotalTime(Map<Integer,List<Problem>> numToProblem) {
        return getTimeOfTask(numToProblem).stream().reduce(0, Integer::sum);
    }

    public static int getTotalTimeI(Map<Integer,List<Problem>> numToProblem) {
        return getTimeOfTask(numToProblem).stream().mapToInt(Integer::intValue).sum();

    }
}
