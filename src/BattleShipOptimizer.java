
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.ElitisticListPopulation;
import org.apache.commons.math3.genetics.FixedGenerationCount;
import org.apache.commons.math3.genetics.GeneticAlgorithm;
import org.apache.commons.math3.genetics.Population;
import org.apache.commons.math3.genetics.StoppingCondition;
import org.apache.commons.math3.genetics.TournamentSelection;

public class BattleShipOptimizer {
    private static final double CROSSOVER_RATE = 1;
    private static final double MUTATION_RATE = 0.2;
    private static final double ELITISM_RATE = 0.2;

    private static final int POPULATION_SIZE = 10;
    private static final int NUM_GENERATIONS = 1000;
    private static final int TOURNAMENT_ARITY = 5;
    
    public static void main(String[] args) {
        new BattleShipOptimizer().run();
    }
    private void run() {
        // initialize a new genetic algorithm
        GeneticAlgorithm ga = new GeneticAlgorithm(
            new ShooterCrossoverPolicy(),
            CROSSOVER_RATE,
            new ShooterMutator(),
            MUTATION_RATE,
            new TournamentSelection(TOURNAMENT_ARITY)
        );
                
        // initial population
        Population initial = getInitialPopulation();
                
        // stopping condition
        StoppingCondition stopCond = new FixedGenerationCount(NUM_GENERATIONS);
                
        // run the algorithm
        Population finalPopulation = ga.evolve(initial, stopCond);
                
        // best chromosome from the final population
        Chromosome bestFinal = finalPopulation.getFittestChromosome();
        System.out.println(bestFinal);
    }

    /**
     * Initializes a random population.
     */
    private ElitisticListPopulation getInitialPopulation() {
        List<Chromosome> popList = new LinkedList<Chromosome>();

        for (int i=0; i<POPULATION_SIZE; i++) {
            popList.add(new Shooter());
        }
        return new ElitisticListPopulation(popList, popList.size(), ELITISM_RATE);
    }
}