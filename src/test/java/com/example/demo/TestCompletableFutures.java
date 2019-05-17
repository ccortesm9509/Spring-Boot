package com.example.demo;


import static io.vavr.API.Success;
import static org.junit.Assert.*;

import io.vavr.control.Try;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.*;

public class TestCompletableFutures {

    private void sleep(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){
            System.out.println("Problemas durmiendo hilo");
        }
    }

    @Test
    public void tChristian(){
        // Se puede construir un CompletableFuture a partir de una lambda Supplier (que no recibe parámetros pero sí tiene retorno)
        // con supplyAsync
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5 / 1);
        Try<Integer> integers = Try.of(() -> future.get(301, TimeUnit.MILLISECONDS));
            assertEquals(integers,  Success(5));
    }


    @Test
    public void useThenApplyInAFeature() {

        CompletableFuture<Integer> completableFuture
                = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> future = completableFuture
                .thenApply(s ->  s + 7)
                .thenApply(s -> s+ 1);
        Try<Integer> result = Try.of(() -> future.get());
        assertEquals(
                Success(13),
                result);
    }

    @Test
    public void useThenComposeInAFeature() {

        CompletableFuture<Integer> completableFuture
                = CompletableFuture.supplyAsync(() -> 5);

        CompletableFuture<Integer> completableFuture2
                = CompletableFuture.supplyAsync(() -> 5);

        CompletableFuture<Integer> future = completableFuture
                .thenCompose(s -> completableFuture2.thenApply(m-> m+s));

        Try<Integer> result = Try.of(() -> future.get());
        assertEquals(
                Success(10),
                result);
    }
}
