package geneticalgorithm;


public class GeneticAlgorithm {

	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int eliteCount;
	protected int tournamentSize;

	public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
			int tournamentSize) {

		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.eliteCount = elitismCount;
		this.tournamentSize = tournamentSize;
	}

	public Population initPopulation(Schedule timetable) {
		Population population = new Population(this.populationSize, timetable);
		return population;
	}


	public Population crossoverPopulation(Population population) {
		Population newPopulation = new Population(population.size());

		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			Individual parent1 = population.getFittest(populationIndex);

			Individual parent2 = selectParent(population);
			
			if (this.crossoverRate > Math.random() && populationIndex >= this.eliteCount) {
				
				Individual offspring = crossoverIndividual(parent1,parent2);

				newPopulation.setIndividual(populationIndex, offspring);
			} else {
				newPopulation.setIndividual(populationIndex, parent1);
			}
		}

		return newPopulation;
	}

	public Individual crossoverIndividual(Individual parent1,Individual parent2) {
		Individual offspring = new Individual(parent1.getChromosomeLength());
		

		for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
			if (0.5 > Math.random()) {
				offspring.setGene(geneIndex, parent1.getGene(geneIndex));
			} else {
				offspring.setGene(geneIndex, parent2.getGene(geneIndex));
			}
		}
		
		return offspring;
	}

	
	public void evalPopulation(Population population, Schedule timetable) {
		double populationFitness = 0;

		for (Individual individual : population.getIndividuals()) {
			populationFitness += this.calcFitness(individual, timetable);
		}

		population.setPopulationFitness(populationFitness);
	}

	public Individual selectParent(Population population) {
		Population tournament = new Population(this.tournamentSize);

		population.shuffle();
		for (int i = 0; i < this.tournamentSize; i++) {
			Individual tournamentIndividual = population.getIndividual(i);
			tournament.setIndividual(i, tournamentIndividual);
		}

		return tournament.getFittest(0);
	}


	public Population mutatePopulation(Population population, Schedule schedule) {
		Population newPopulation = new Population(this.populationSize);

		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			
			Individual individual = mutateIndividual(populationIndex, population, schedule);
			newPopulation.setIndividual(populationIndex, individual);
		}

		return newPopulation;
	}

	public Individual mutateIndividual(int index,Population population,Schedule schedule) {
		Individual individual = population.getFittest(index);

		Individual randomIndividual = new Individual(schedule);

		for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
			if (index > this.eliteCount) {
				if (this.mutationRate > Math.random()) {
					individual.setGene(geneIndex, randomIndividual.getGene(geneIndex));
				}
			}
		}
		return individual;
	}
	
	

	public boolean isTerminationConditionMet(int generationsCount, int maxGenerations) {
		return (generationsCount > maxGenerations);
	}

	public boolean isTerminationConditionMet(Population population) {
		return population.getFittest(0).getFitness() == 1.0;
	}

	public double calcFitness(Individual individual, Schedule timetable) {

		Schedule threadTimetable = new Schedule(timetable);
		threadTimetable.createClasses(individual);

		int clashes = threadTimetable.calcClashes();
		double fitness = 1 / (double) (clashes + 1);

		individual.setFitness(fitness);

		return fitness;
	}

}
