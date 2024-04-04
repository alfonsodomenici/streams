package it.tsp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AppGenerics {
    public static void main(String[] args) {

        Box<Person> box = new Box<>(new Person("mario", "rossi"));
        Person p = box.getElement();
        System.out.println(p);
        System.out.println(AppGenerics.<Integer>somma(10, 20));
        System.out.println(AppGenerics.<Double>somma(10.60, 45.23));

        System.out.println(sommaPariDispari(Arrays.asList(4,2.8,9,5,3)));

        System.out.println(checkArray(Stream.of(1,4,7,6).toArray(), Stream.of(1,4,6,7).toArray()));
    }

    private static <T> boolean checkArray(T[] array1, T[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static <T extends Number> Result sommaPariDispari(List<T> numbers) {
        double even = numbers.stream().filter(v -> v.doubleValue() % 2 == 0)
                .mapToDouble(v -> v.doubleValue())
                .sum();

        double odd = numbers.stream().filter(v -> v.doubleValue() % 2 != 0)
                .mapToDouble(v -> v.doubleValue())
                .sum();

        return new Result(odd, even);
    }

    private static <T extends Number> double somma(T n1, T n2) {
        return n1.doubleValue() + n2.doubleValue();
    }

}

record Result(double oddSum, double evenSum) {

}

record Person(String fname, String lname) {

}

class Box<T> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

}