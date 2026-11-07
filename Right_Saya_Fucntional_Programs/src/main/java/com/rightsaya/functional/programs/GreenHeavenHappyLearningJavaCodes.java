package com.rightsaya.functional.programs;

import com.rightsaya.functional.programs.dtos.Customer;
import com.rightsaya.functional.programs.function.interfaces.CalculateAverage;
import com.rightsaya.functional.programs.function.interfaces.HappyLearning;
import com.rightsaya.functional.programs.service.CustomerService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GreenHeavenHappyLearningJavaCodes implements HappyLearning {

    public static void executeCodes() throws Exception {

    }

    public static void runJavaCodes() throws ExecutionException, InterruptedException, IOException {
        /*

        Predicate, Function, Consumer, Supplier, UnaryOperator, BinaryOperator, BiFunction

        */

        Predicate<Integer> testPrimeNumber = n -> {
            if (n <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };

        Stream<Integer> intStream = IntStream.of(20, 30, 40, 222, 443, 27, 29).boxed();

        Stream<String> stringStream = Arrays.stream(new String[]{"Ritesh", "Nasib", "Right", "John", "Ritesh"});

        List<String> stringList = stringStream.toList();

        List<Integer> intList = intStream.toList();

        Predicate<Integer> isPrime = n ->
                n > 1 &&
                        IntStream.rangeClosed(2, (int) Math.sqrt(n))
                                .noneMatch(i -> n % i == 0);


        System.out.println("Inetgers List\n" + intList);
        System.out.println("Prime Numbers\n");

        intList.stream().filter(isPrime).forEach(System.out::println);

        System.out.println("\nString List\n" + stringList);

        System.out.println("Duplicate Strings\n");

        final Set<String> stringSet = new HashSet<>();

        stringList.stream().filter(str -> !stringSet.add(str)).forEach(System.out::println);

        System.out.println("Unique Elements Integer and String\n");

        intList.stream().distinct().forEach(System.out::println);
        stringSet.clear();
        stringList.stream().map(str -> stringSet.add(str)).distinct().toList();

        stringSet.forEach(System.out::println);

        CalculateAverage calculateAverage = intArray ->
                Arrays.asList(intArray).stream().mapToInt(Integer::intValue).average().orElse(0.0);
        Integer[] intArray = new Integer[intList.size()];
        Double average = calculateAverage.calculateAverage(intList.toArray(intArray));

        System.out.println("Average : " + average);

        Consumer<String> outPrint = System.out::println;

        // Sort List first by length and then alphabatical
        // Function comparator
        final List<String> words = new ArrayList<>(List.of("banana", "kiwi", "fig", "apple", "pear"));
        Comparator<String> comparatorA = (str1, str2) -> str1.compareTo(str2);
        Comparator<String> comparatorB = Comparator.comparingInt(String::length);
        stringList.stream().sorted(comparatorB).sorted().toList().forEach(outPrint);

        //Implement the same task using both Runnable and Callable as lambdas, and explain the difference.

        Runnable runnable = () -> words.forEach(outPrint);
        Callable<String> callable = () -> "RiteshRaiChawla";

        Callable<Integer> callableInteger = () -> 20;
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        Future<String> futureStrCallable = executorService.schedule(callable, 1000l, TimeUnit.NANOSECONDS);
        executorService.execute(runnable);
        if (futureStrCallable.isDone() && !futureStrCallable.isCancelled()) {
            System.out.println(futureStrCallable.get());
        }
        while (true) {
            if (futureStrCallable.isDone() && !futureStrCallable.isCancelled()) {
                System.out.println(futureStrCallable.get());
                break;
            }
        }
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureInt = executor.submit(callableInteger);
        Future<String> futureStr = executor.submit(callable);

        Predicate<Integer> isEven = num -> num % 2 == 0;

        Consumer<String> printStr = str -> System.out.println(str);

        Supplier<Integer> supplier = () -> Optional.of(Integer.MAX_VALUE).get();

        Function<String, Integer> strToIntFunction = str -> Integer.valueOf(str);

        // CompletableFuture

        final ExecutorService IO_EXECUTOR =
                Executors.newFixedThreadPool(10);
        CustomerService customerService = new CustomerService();
        Supplier<Customer> custEmailID = () -> customerService.getCustomer("ritesh@email.com");
        CompletableFuture<Customer> customerCompletableFuture =
                CompletableFuture.supplyAsync(custEmailID, IO_EXECUTOR);
        Consumer<Customer> custConsumer = cust -> System.out.println(cust);
        CompletableFuture<Customer> customerCompletableFutureNext = CompletableFuture.supplyAsync(()
                -> {

            System.out.println(
                    "Thread: " + Thread.currentThread().getName()
            );

            // Simulating DB / REST API call
            return new Customer(
                    200l,
                    "Ritesh",
                    "ritesh@example.com",
                    "9876543210",
                    "Paonta Sahib",
                    "ACTIVE"
            );
        });

        customerCompletableFuture.thenAccept(custConsumer);
        customerCompletableFuture.thenAcceptAsync(custConsumer);
        customerCompletableFuture.thenAcceptAsync(custConsumer, IO_EXECUTOR);
        customerCompletableFutureNext.join();
        customerCompletableFutureNext.get();

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(
                        () -> callRemoteService(),
                        executor
                );

        CompletableFuture<String> futureZ =
                CompletableFuture
                        .supplyAsync(() -> "java")
                        .thenApply(String::toUpperCase);

        CompletableFuture<Void> futurea =
                CompletableFuture
                        .supplyAsync(() -> "Ritesh")
                        .thenAccept(System.out::println);


        CompletableFuture
                .supplyAsync(() -> "Order created")
                .thenRun(() ->
                        System.out.println("Workflow completed")
                );

        CompletableFuture<CompletableFuture<List<Customer>>> futuren =
                customerService.getCustomer(101L)
                        .thenApply(customer ->
                                customerService.getCustomers()
                        );

        CompletableFuture<List<Customer>> futureV =
                customerService.getCustomer(101L)
                        .thenCompose(customer ->
                                customerService.getCustomers()
                        );

        CompletableFuture<Customer> f1 = customerService.getCustomer(1L);
        CompletableFuture<Customer> f2 = customerService.getCustomer(2L);
        CompletableFuture<Customer> f3 = customerService.getCustomer(3L);

        CompletableFuture<Void> all =
                CompletableFuture.allOf(f1, f2, f3);

        CompletableFuture<List<Customer>> customers =
                all.thenApply(v ->
                        Stream.of(f1, f2, f3)
                                .map(CompletableFuture::join)
                                .toList()
                );

        CompletableFuture<Object> futurek =
                CompletableFuture
                        .supplyAsync(() -> {
                            throw new RuntimeException("Service failed");
                        })
                        .exceptionally(error -> {
                            System.out.println(error.getMessage());
                            return "Fallback";
                        });

        CompletableFuture<String> result =
                future.handle((value, error) -> {

                    if (error != null) {
                        return "Fallback";
                    }

                    return value.toUpperCase();
                });

        HttpClient client =
                HttpClient.newHttpClient();

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(
                                "https://example.com/api/customers/101"
                        ))
                        .GET()
                        .build();

        HttpClient clienA =
                HttpClient.newHttpClient();

        HttpRequest requestA =
                HttpRequest.newBuilder()
                        .uri(URI.create(
                                "https://example.com/api/customers/101"
                        ))
                        .GET()
                        .build();

        HttpResponse<String> response =
                clienA.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        System.out.println(
                "Status: " + response.statusCode()
        );

        System.out.println(
                "Body: " + response.body()
        );
        CompletableFuture<HttpResponse<String>> futureQQ =
                client.sendAsync(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        LinkedHashMap<Integer, String> customersList =
                new LinkedHashMap<>();

        customersList.put(101, "Ritesh");
        customersList.put(102, "John");
        customersList.put(103, "David");

        System.out.println(
                customersList.firstEntry()
        );

        System.out.println(
                customersList.lastEntry()
        );

        var first =
                customersList.pollFirstEntry();

        var last =
                customersList.pollLastEntry();

        System.out.println(first);
        System.out.println(last);

        SequencedMap<Integer, String> sequencedMap =
                new LinkedHashMap<>();

        sequencedMap.put(101, "Ritesh");
        sequencedMap.put(102, "John");
        sequencedMap.put(103, "David");

        System.out.println(
                sequencedMap.firstEntry()
        );

        System.out.println(
                sequencedMap.lastEntry()
        );

        var firstA =
                sequencedMap.pollFirstEntry();

        var lastA =
                sequencedMap.pollLastEntry();

        System.out.println(firstA);
        System.out.println(lastA);
    }

    private static String callRemoteService() {
        return "";
    }

    @Override
    public boolean test(String s) {
        return Objects.nonNull(s);
    }

    public record CustomerResponse(
            Long customerId,
            String name,
            String email,
            String status) {
    }


    public class SemaphoreExample {

        private static final Semaphore semaphore =
                new Semaphore(2);

        public SemaphoreExample() throws InterruptedException {
        }

        public static void main(String[] args) {

            for (int i = 1; i <= 5; i++) {

                int taskId = i;

                new Thread(() ->
                {
                    try {
                        executeTask(taskId);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                ).start();
            }
        }
        // so only two permit acquisitions can be outstanding before subsequent acquire() calls must wait.
        private static void executeTask(int taskId) throws InterruptedException {

            boolean acquired = false;

            try {

                semaphore.acquire();
                acquired = true;

                System.out.println(
                        "Task-" + taskId
                                + " entered."
                );

                Thread.sleep(2000);

                System.out.println(
                        "Task-" + taskId
                                + " completed."
                );

                if (semaphore.tryAcquire()) {

                    try {

                        callRemoteService();

                    } finally {

                        semaphore.release();
                    }

                } else {

                    System.out.println(
                            "Service capacity exhausted"
                    );
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            } finally {

                if (acquired) {
                    semaphore.release();
                }
            }
            boolean acquiredA =
                    semaphore.tryAcquire(
                            500,
                            TimeUnit.MILLISECONDS
                    );
            int permits =
                    semaphore.availablePermits();


            System.out.println(
                    permits
            );

            Semaphore semaphore =
                    new Semaphore(3);

            System.out.println(
                    semaphore.availablePermits()
            );

            semaphore.acquire();

            System.out.println(
                    semaphore.availablePermits()
            );

            semaphore.release();

            System.out.println(
                    semaphore.availablePermits()
            );

            Semaphore semaphoreB =
                    new Semaphore(10);

            semaphore.acquire(3);

            try {

                callRemoteService();

            } finally {

                semaphore.release(3);
            }
        }



    }


    //CustomerService customerService = new CustomerService();

    /*@GetMapping("/{id}")
    public CustomerResponse getCustomer(
            @PathVariable Long id) {

        return customerService
                .getCustomer(id);
    }

    public class CustomerService {

        CustomerResponse getCustomer(Long id) {
            return new CustomerResponse(200L, null, null, null);
        }

    }*/
}

