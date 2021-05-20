package med.examples.java8.concurront;

import java.util.concurrent.CompletableFuture;

public class CompletableFututreEx3{
    public static void main(String[] args) {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        // future.complete(7);
        /*future
            .thenApply(value -> value * 2)
            .thenAccept(System.out::println);*/

        future
            .thenApplyAsync(value -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return value * 3;
            })
            .thenAcceptAsync(System.out::println);

        future.completeAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        new Thread(() -> {
            System.out.println("Thread 1: " + future.join());
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2: " + future.join());
        }).start();

        System.out.println("end.");
    }
}
