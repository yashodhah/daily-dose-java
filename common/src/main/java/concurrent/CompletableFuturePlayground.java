//package concurrent;
//
//import utils.LambdaUtils;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class CompletableFuturePlayground {
//    public void calculateAsync() throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//
//        Executors.newCachedThreadPool().submit(LambdaUtils.throwingRunnableWrapper(() -> {
//            Thread.sleep(500);
//            completableFuture.complete("Hello");
//        }));
//
//        // ----
//
//        System.out.println(completableFuture.isDone());
//        System.out.println(completableFuture.get());
//    }
//
//    @Test
//    void processingResults() throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello");
//
//        CompletableFuture<String> future = completableFuture
//                .thenApply(s -> s + " World");
//
//        assertEquals("Hello World", future.get());
//    }
//
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuturePlayground cp = new CompletableFuturePlayground();
//        cp.calculateAsync();
//    }
//}
//
//
//
