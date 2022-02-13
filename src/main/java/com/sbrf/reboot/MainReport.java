package com.sbrf.reboot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainReport {

    public CompletableFuture<Integer> getBalanceSum(Stream<Customer> streamCustomer, int age){
        return CompletableFuture.supplyAsync(() -> {
            Set<Customer> customers = streamCustomer.filter(customer -> customer.getAge() == age).collect(Collectors.toSet());
            List<Account> accountsList = new ArrayList<>();
//            сохраняем нужные счета отобранных клиентов
            customers.forEach(customer -> accountsList.addAll(customer.getRepository().stream()
                    .filter(account -> account.getDate().isAfter(LocalDate.of(2021,7,1))&&account.getDate().isBefore(LocalDate.of(2021, 8, 1 )))
                    .collect(Collectors.toList())));
            int sum = accountsList.stream().mapToInt(account -> account.getAmount()).sum();
            return sum;
        });
    }

    public int getTotalsWithCompletableFuture(Stream<Customer> streamCustomer) throws InterruptedException, ExecutionException {
        ArrayList<Integer> listAge = new ArrayList<>();
        for (int i = 18; i < 31; i++)
        {
            listAge.add(i);
        }
        //ассинхронно считаем суммы балансов по каждой возрастной категории
        List<CompletableFuture<Integer>> getBalanceSumFutures = listAge.stream()
                .map(age -> getBalanceSum(streamCustomer,age))
                .collect(Collectors.toList());
        // Создаём комбинированный Future, используя allOf()
                CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                        getBalanceSumFutures.toArray(new CompletableFuture[0])
                );

        // Когда все задачи завершены, вызываем future.join(), чтобы получить результаты и собрать их в список
        CompletableFuture<List<Integer>> allSumList = allFutures.thenApply(v -> {
            return getBalanceSumFutures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());
        });

        CompletableFuture<Integer> result = allSumList.thenApply(list -> {
            return list.stream().mapToInt(Integer::intValue).sum();
        });

        int balanceSum=result.get();
        System.out.println("Сумма " + balanceSum);
        return balanceSum;
    }

}