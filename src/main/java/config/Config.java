package config;

import crossover.CrossoverOperator;
import crossover.PMXCrossover;
import crossover.PMXCrossover2;
import mutation.MutationOperator;
import mutation.SwapMutation;
import mutation.SwapMutation2;
import selection.RouletteSelectionStrategy;
import selection.SelectionStrategy;
import selection.TournamentSelectionStrategy;
import utils.RandomGenerator;

/**
 * Created by Cinek on 18.03.2019.
 */
public class Config
{
    public static final double CROSSOVER_PROB = 0.7;
    public static final double MUTATION_PROB = 0.01;
    public static final int POPULATION_SIZE =100;
    public static final int GENERATIONS = 1000;
    public static final int TOUR = 6;
    public static String FILE_NAME = "medium_0";
    public static final SelectionStrategy SELECTION_STRATEGY = new TournamentSelectionStrategy();
    public static final MutationOperator MUTATION_OPERATOR = new SwapMutation();
    public static final CrossoverOperator CROSSOVER_OPERATOR = new PMXCrossover2(new RandomGenerator());





}
