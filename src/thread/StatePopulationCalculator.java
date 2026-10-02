package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class StatePopulationCalculator {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(4);

        List<String> states = Arrays.asList("State1", "State2", "State3", "State4", "State5", "State6");

        List<Future<Integer>> futures = new ArrayList<>();

        for (String state : states){
            futures.add(executor.submit(new PopulationTask(state)));
        }
        int totalPopulation = 0;
        for(Future<Integer> future: futures) {
            try {
                totalPopulation += future.get();    
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.toString());
            }
        }
        executor.shutdown();
        System.out.println("TotalPopulation::" + totalPopulation);
    }
}
