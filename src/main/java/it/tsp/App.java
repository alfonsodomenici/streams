package it.tsp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        List<String> words = Files.readAllLines(Paths.get("C:\\Users\\DocentePC\\Documents\\words.txt"));

        words.forEach(v -> System.out.println(v));

        System.out.println("numero elementi dello stream");
        System.out.println(words.stream().count());

        System.out.println("numero di parole con lungh. > 5");
        System.out.println(words.stream().filter(v -> v.length() > 5).count());

        System.out.println("elementi ordinati");
        words.stream().sorted().forEach(v -> System.out.println(v));

        System.out.println("parola lunghezza max, min, avg");
        System.out.println(words.stream().mapToInt(v -> v.length()).max().getAsInt());
        System.out.println(words.stream().mapToInt(v -> v.length()).min().getAsInt());
        System.out.println(words.stream().mapToInt(v -> v.length()).average().getAsDouble());

        System.out.println("stampa senza duplicati");
        words.stream().distinct().forEach(v -> System.out.println(v));

        System.out.println("cerca parola pane e ritorna vero o falso");
        System.out.println(words.stream().anyMatch(v -> v.contains("pane")));

        System.out.println("tutte le parole hanno lunghezza >= 4");
        System.out.println(words.stream().allMatch(v -> v.length() >= 4));

        System.out.println("cerca parola pane ");
        words.stream().filter(v -> v.contains("pane")).forEach(v -> System.out.println(v));

        List<String> collect = words.stream().filter(v -> v.length() < 5)
                .map(v -> v.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("parole < di 5 unite col ;");
        String collect1 = words.stream().filter(v -> v.length() < 5)
                .map(v -> v.toUpperCase())
                .distinct()
                .collect(Collectors.joining(";"));
        System.out.println(collect1);

        System.out.println("parole raggruppate per lunghezza");
        Map<Integer, List<String>> collect2 = words.stream().collect(Collectors.groupingBy(v -> v.length()));
        System.out.println(collect2);

        System.out.println("numero di parole x lunghezza");
        System.out.println(words.stream().collect(Collectors.groupingBy(v -> v.length(), Collectors.counting())));
    }
}
