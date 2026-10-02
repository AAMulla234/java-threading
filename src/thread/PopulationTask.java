package thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class PopulationTask implements Callable<Integer>{
        private String state;

        public PopulationTask(String state) {
            this.state = state;
        }

        @Override
        public Integer call() {
             Random random = new Random();
            int population = random.nextInt(1_000_000) + 1_000_000; // Random population between 1,000,000 and 2,000,000
            System.out.println("Population of " + state + ": " + population);
            return population;
        }
}
