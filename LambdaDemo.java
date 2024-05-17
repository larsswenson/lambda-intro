import java.util.*;
import java.util.function.*;

public class LambdaDemo {

    // Math
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;

        System.out.println("Add: " + add.operate(10, 5));
        System.out.println("Subtract: " + subtract.operate(10, 5));
        System.out.println("Multiply: " + multiply.operate(10, 5));
        System.out.println("Divide: " + divide.operate(10, 5));

        // Sort list by string length
        List<String> stringList = Arrays.asList("guitar", "bass", "drums", "vocals");
        stringList.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted list: " + stringList);

        // Filter out even numbers
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredList = new ArrayList<>();
        integerList.forEach(n -> {
            if (n % 2 != 0) filteredList.add(n);
        });
        System.out.println("Odd numbers: " + filteredList);

        // Predicate
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("Is string empty: " + isEmpty.test(""));

        // Uppercase
        Function<String, String> toUpperCase = s -> s.toUpperCase();
        System.out.println("Uppercase: " + toUpperCase.apply("hello"));

        // More math
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTen = x -> x * 10;
        Function<Integer, Integer> addThenMultiply = addOne.andThen(multiplyByTen);
        System.out.println("Add & multiply: " + addThenMultiply.apply(5));

        // Custom interface
        @FunctionalInterface
        interface StringOperation {
            String apply(String s1, String s2);
        }

        StringOperation concatenate = (s1, s2) -> s1 + s2;
        StringOperation findLonger = (s1, s2) -> s1.length() >= s2.length() ? s1 : s2;

        System.out.println("Concatenate: " + concatenate.apply("hello", " world!"));
        System.out.println("Longer string: " + findLonger.apply("hello", "world!"));
    }
}
