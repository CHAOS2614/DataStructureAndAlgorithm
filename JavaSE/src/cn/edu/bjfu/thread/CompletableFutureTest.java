package cn.edu.bjfu.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chaos
 * @date 2022-09-05 17:17
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        //文件夹位置
        List<String> filePaths = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        // 异步处理所有文件
        // 将他们合并起来
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                filePaths.stream()
                        .map(CompletableFutureTest::doSomeThing).toArray(CompletableFuture[]::new)
        );
        allFutures.join();
        try {
            System.out.println(allFutures.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        filePaths.forEach(System.out::println);
        System.out.println("all done");
    }

    public static CompletableFuture<String> doSomeThing(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name + "-do something";
        });
    }
}
