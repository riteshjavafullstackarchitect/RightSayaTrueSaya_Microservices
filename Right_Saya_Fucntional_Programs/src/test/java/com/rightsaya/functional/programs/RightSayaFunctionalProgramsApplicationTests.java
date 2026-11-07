package com.rightsaya.functional.programs;

import lombok.Data;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.*;
import java.util.stream.Collectors;

@SpringBootTest
public class RightSayaFunctionalProgramsApplicationTests {

    @Test
    public void contextLoads() throws ExecutionException, InterruptedException, IOException {
        //GreenHeavenHappyLearningJavaCodes.runJavaCodes();
        Calculator sum = Calculator.add();
        System.out.println(sum.calculate(3, 4)); // 7 Calculator doubledSum = sum.andThenDouble();
        Calculator doubledSum = sum.andThenDouble();
        System.out.println(doubledSum.calculate(3, 4)); // 14 }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        };

        // Lambda Conversion
        Comparator<String> comparatorLambda = (str1, str2) -> str1.compareToIgnoreCase(str2);

        List<String> stringListA = List.of("Madam", "racecar", "level", "radar",
                "civic", "RIghtShipOneOOne", "Ritesh", "RighTShip", "Anjalina",
                        "Nasib", "Yash", "Office", "home", "ship");
        List<String> stringList = new ArrayList<>(stringListA);
        stringList.sort(comparatorLambda);
        System.out.println(stringList);
        System.out.println(stringList.reversed());
        stringList.stream().sorted(comparatorLambda);
        stringList.sort(String::compareToIgnoreCase);

        Function<Integer, Integer> sqrFunctionStatic = num -> num * num;
        RightSayaFunctionalProgramsApplication appn = new RightSayaFunctionalProgramsApplication();
        Function<Integer, Integer> sqrFunctionInstance = this::square;
        System.out.println("Square of 200 is " + sqrFunctionInstance.apply(200));

        // Constructor reference
        Supplier<String> getStrNewObject = () -> String.valueOf("RIghtShipOneOOne");
        Supplier<String> getStrNewObjectNext = String::new;
        getStrNewObjectNext.get();
        GreenHeavenHappyLearningJavaCodes greenHeaven = new GreenHeavenHappyLearningJavaCodes();

        // GreenHeavenHappyLearningJavaCodes.runJavaCodes();
        try {
            executeCodes(stringListA);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);

        default Calculator andThenDouble() {
            return (a, b) -> calculate(a, b) * 2;
        }

        static Calculator add() {
            return (a, b) -> a + b;
        }
    }

    private void executeCodes(List<String> stringListA) throws Exception {


        @Data
        class Employee {

            Long id;
            String name;
            String email;
            String phone;
            String designation;
            Double salary;

            public Employee(Long id, String name, String email, String phone,
                            String designation, Double salary) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.phone = phone;
                this.designation = designation;
                this.salary = salary;
            }
        }

        List<Employee> employees = List.of(

                new Employee(
                        101L,
                        "Amit Sharma",
                        "amit.sharma@gmail.com",
                        "9876543210",
                        "Software Engineer",
                        85000d
                ),

                new Employee(
                        102L,
                        "Neha Verma",
                        "neha.verma@gmail.com",
                        "9876543211",
                        "Senior Software Engineer",
                        120000d
                ),

                new Employee(
                        103L,
                        "Rahul Mehta",
                        "rahul.mehta@gmail.com",
                        "9876543212",
                        "Technical Lead",
                        150000d
                ),

                new Employee(
                        104L,
                        "Priya Singh",
                        "priya.singh@gmail.com",
                        "9876543213",
                        "Java Developer",
                        95000d
                ),

                new Employee(
                        105L,
                        "Vikram Gupta",
                        "vikram.gupta@gmail.com",
                        "9876543214",
                        "Solution Architect",
                        185000d
                )
        );
/*


        System.out.println("Before Sorting \n");
        employees.forEach(System.out::println);
        System.out.println("After           Sorting \n");
        employees.stream().sorted((o1, o2) ->
                o1.getDesignation().compareToIgnoreCase(
                        o2.getDesignation()
                )).sorted((o1, o2) -> o2.getSalary().compareTo(
                o1.getSalary()
        )).toList().reversed().forEach(System.out::println);
        System.out.println("After  NEXT Sorting \n");
        employees.stream().sorted( Comparator.comparing((Employee e) -> e.getDesignation())
                .thenComparing(Comparator.
                        comparingDouble((Employee e) -> e.getSalary()).reversed()) ).forEach(System.out::println);
*/

        // Palindrome Check

        Predicate<String> isPalindrome = str -> {
            String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
            return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        };

        List<String> palindromesA = stringListA.stream()
                .filter(str ->
                        str.equalsIgnoreCase(
                                new StringBuilder(str)
                                        .reverse()
                                        .toString()
                        )
                )
                .toList();

        System.out.println("Easy style");
        System.out.println(palindromesA);
        List<String> palindromes = stringListA.stream()
                .filter(str -> isPalindrome.test(str)).toList();
        System.out.println("Complex style");
        System.out.println(palindromes);

        Function<Integer, Integer> addFive = x -> x + 5;
        Function<Integer, Integer> multiplyTwo = x -> x * 2;
        Function<Integer, Integer> addTenMultiply = addFive.andThen(multiplyTwo);
        System.out.println(addTenMultiply.apply(2999));
        Function<Integer, Integer> multiplyThenAdd = addFive.compose(multiplyTwo);

        System.out.println(multiplyThenAdd.apply(22));

        BiFunction<Integer, Integer, String> biFunc = (a,b) -> String.valueOf(a+b);

        System.out.println(biFunc.apply(4, 8));

        BiPredicate<String, Integer> strEquelsIntegerTest = (str, num) -> Integer.valueOf(str).equals(num);

        System.out.println(strEquelsIntegerTest.test("20", 8));
        System.out.println(strEquelsIntegerTest.test("20", 20));

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLength = s -> System.out.println("Length: " + s.length());

        Consumer<String> combined = printUpperCase.andThen(printLength);
        combined.accept("hello");

        Map<String, String> mapWords = new HashMap<>();
        stringListA.stream().map(str -> {
            mapWords.put(str.concat("_Key"), str.concat("_Value"));

                    return str.concat(" A ");
                }
        ).forEach(System.out::println);

        BiConsumer<String, String> biConsumer = (str1, str2) ->
                System.out.println(" KEY: ".concat(str1).concat(" , Value: ").concat(str2));

        mapWords.forEach(biConsumer);

        List<Integer> numbers = List.of(4, 9, 2, 7, 5);

        System.out.println("numbers.stream().max(Integer::compareTo).orElse(0):   " + numbers.stream().max(Integer::compareTo).orElse(0));
        BinaryOperator<Integer> binOpr = BinaryOperator.maxBy(Integer::compareTo);
        System.out.println("numbers.stream().reduce(binOpr).orElse(0):   " + numbers.stream().reduce(binOpr).orElse(0));

        @FunctionalInterface interface Ranker<T extends Comparable<T>> { int rank(T a, T b);};

            Ranker<Integer> intRanker = Integer::compareTo;
            System.out.println(intRanker.rank(5, 10));// negative, 5 < 10
        Ranker<String> stringRanker = String::compareTo;
        System.out.println(stringRanker.rank("banana", "apple")); // positive
        final Set<String> uniqueStringsSet = new HashSet<>();
        // How do you find the frequency of each character in a string using Java 8 Streams?
        final Map<String, Map<Character, Long>> strToCharOccuranceMap = new HashMap<>();
        stringListA.stream().forEach(str -> {
            Map<Character, Long> frequency = str.chars() .mapToObj(c -> (char) c) .
                    collect(Collectors.groupingBy(c -> c, Collectors.counting()));
            strToCharOccuranceMap.put(str, frequency);
        });
        strToCharOccuranceMap.entrySet().stream().forEach(entry ->
                System.out.println("\n ".concat(entry.getKey()).concat(": ")
                .concat(entry.getValue().entrySet().stream()
                        .map(entryFrequency -> "".
                                concat(entryFrequency.getKey().toString()).concat(": ")
                                .concat(entryFrequency.getValue().toString())).toList().toString())));

        System.out.println(stringListA.stream().distinct().toList());

        // Find the second highest number in a list using Streams.
        Optional<Integer> secondHighest = numbers.stream() .distinct() .sorted(Comparator.reverseOrder()) .skip(1) .findFirst();

        // Convert a list of employee names to uppercase and filter out anyone whose name is shorter than 4 characters.
        System.out.println(stringListA.stream().map(String::toUpperCase).filter(str -> str.length() > 6).toList());

        // Given a list of employees, find the first employee earning more than $80,000, or a default if none qualifies.
        System.out.println(employees.stream().sorted((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()))
                .filter(emp -> emp.getSalary() > 80000).findFirst().get());

        //boolean allAdults = employees.stream().allMatch(p -> p. >= 18); boolean anyMinor = people.stream().anyMatch(p -> p.age() < 18); boolean noneMinor = people.stream().noneMatch(p -> p.age() < 18);

        List<String> namesBySalaryDesc = employees.stream() .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::getName) .collect(Collectors.toList());

        // Find the longest string in a list of strings using Streams.
        Optional<String> longest = stringListA.stream().max(Comparator.comparingInt(String::length));

        // Given a list of tags, produce a single comma-separated string for display in a UI.
        List<String> tags = List.of("java", "streams", "interview", "prep");
        String joined = tags.stream() .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joined); // [java, streams, interview, prep]

        // Given a list of orders (customer name + amount), calculate total revenue per customer.

        @Data
        class Order {
            String name;
            double revenue;

            public Order() {

            }

            public Order(String name, Double revenue) {
                this.name = name;
                this.revenue = revenue;
            }
        }

        List<Order> orders = List.of( new Order("Alice", 120.0), new Order("Bob", 75.0), new Order("Alice", 60.0), new Order("Bob", 45.0) );

        Map<String, Double> totalRevenuePerCustomer = orders.stream().collect(Collectors.groupingBy(Order::getName,
                Collectors.summingDouble(Order::getRevenue)));

        totalRevenuePerCustomer.entrySet().forEach(System.out::println);

        
    }

    public Integer square(Integer num) {
        return num * num;
    }

    public void printUniversalMap(Map<Object, Object> universalMapObject) {
        universalMapObject.entrySet().forEach(System.out::println);
    }
}
