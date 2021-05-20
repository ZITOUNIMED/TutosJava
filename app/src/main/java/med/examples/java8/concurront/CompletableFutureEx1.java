package med.examples.java8.concurront;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureEx1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future1 = new CompletableFuture<>();
        future1.complete(10);
        System.out.println("Future1 response: " + future1.get());

        /*CompletableFuture<Integer> future2 = new CompletableFuture<>();
        future2.join();
        System.out.println("Future2 response: " + future1.get());*/

        CompletableFuture<Integer> future3 = new CompletableFuture<>();
        future3.completeAsync(() -> {
            try {
                Thread.sleep(1000); // one second.
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
            return 15;
        });
        System.out.println("Future3 response: " + future3.get());
    }
}
