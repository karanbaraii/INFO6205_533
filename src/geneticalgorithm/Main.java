package geneticalgorithm;

import domain.Class;

public class Main {
	public static int populationSize = 100;
	public static double mutationRate = 0.01;
	public static double crossoverRate = 0.9;
	public static int elitecount = 2;
	public static int tournamentSize = 5;
	
    public static void main(String[] args) {
    	
        Schedule schedule = Data.initialize();
        
    	
        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize, mutationRate, crossoverRate, elitecount, tournamentSize);
        
        Population population = ga.initPopulation(schedule);
        
        ga.evalPopulation(population, schedule);
        
        int generation = 1;
        
        while (ga.isTerminationConditionMet(generation, 100) == false
            && ga.isTerminationConditionMet(population) == false) {
          
            population = ga.crossoverPopulation(population);

            population = ga.mutatePopulation(population, schedule);

            ga.evalPopulation(population, schedule);

            generation++;
        }

        schedule.createClasses(population.getFittest(0));
      

        Class classes[] = schedule.getClasses();
        int classIndex = 1;
        System.out.println("Number | Class[Group,Room,Time,Professor,Module]");
        
        for (Class bestClass : classes) {
        	
        	System.out.println(classIndex+"	| "+

        	 schedule.getGroup(bestClass.getGroupId()).getGroupId()+" |"+

        	 schedule.getRoom(bestClass.getRoomId()).getNumber()+" |"+

        	 schedule.getTimeslot(bestClass.getTimeslotId()).getTimeslot()+" |"+
        	 schedule.getProfessor(bestClass.getProfessorId()).getProfessorName()+" |"+

			schedule.getModule(bestClass.getModuleId()).getModuleName()+" |"+"");
           
            classIndex++;
        }
    
        System.out.println("---------------------------------------------------------");
        System.out.println(generation + " Generation");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Clashes: " + schedule.calcClashes());
    }

	
}
