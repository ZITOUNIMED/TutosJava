package med.examples.java8.concurront;

import java.util.concurrent.CompletableFuture;

public class CompletableFututreEx2 {
    public static void main(String[] args) {
        // Stream<Integer> secondsStream = Stream.of(1, 2, 3, 4, 5);
        CompletableFuture<Integer> future1 = new CompletableFuture<>();
        future1.complete(10);
        System.out.println("Future1 response: " + future1.join());

        System.out.println("end.");
    }
}
