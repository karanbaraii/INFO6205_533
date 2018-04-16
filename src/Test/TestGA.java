package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.GeneticAlgorithm;
import geneticalgorithm.Main;
import geneticalgorithm.Population;
import geneticalgorithm.Schedule;

public class TestGA {

	@Test
	public void test1() {
		Schedule schedule = geneticalgorithm.Data.initialize();
		 GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
	        
	        // Initialize population
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
	        double fitness = population.getFittest(0).getFitness();
	        double fit = 1.0;
	        
	        assertEquals(fit,fitness,0);   
	        schedule.createClasses(population.getFittest(0));
	        
	        
	        assertEquals(0,schedule.calcClashes(),0);  
		
		
	}
	

	@Test
	public void Test2() {
		Schedule schedule = init();
		 GeneticAlgorithm ga = new GeneticAlgorithm(5, 0.01, 0.9, 2, 5);
	        
	        // Initialize population
	     Population population = ga.initPopulation(schedule);
	    
	     Population expected = ga.initPopulation(schedule);
	     
	     ga.evalPopulation(population, schedule);
	     int generation = 1;	

         expected = ga.crossoverPopulation(population);
	     population = ga.crossoverPopulation(population);
	     assertEquals(population,population);
		}
	
	public Schedule init() {
		Schedule schedule = new Schedule();

		// Set up rooms
		schedule.addRoom(1, "101", 15);
		schedule.addRoom(2, "102", 30);

		// Set up timeslots
		schedule.addTimeslot(1, "Mon 9:00 - 11:00");
		schedule.addTimeslot(2, "Mon 11:00 - 13:00");
		schedule.addTimeslot(3, "Mon 13:00 - 15:00");
		schedule.addTimeslot(4, "Tue 9:00 - 11:00");
		
		// Set up professors
		schedule.addProfessor(1, "Dr P Mitch");
		schedule.addProfessor(2, "Mrs Elsa Jean");
		

		// Set up modules and define the professors that teach them
		schedule.addModule(1, "cn1", "Computer Networks", new int[] { 1});
	
		schedule.addModule(3, "am1", "Applied Maths", new int[] { 1});
		
		// Set up student groups and the modules they take.
		schedule.addGroup(1, 10, new int[] { 1 });
		schedule.addGroup(2, 30, new int[] { 3 });
		
		return schedule;
		
	}

}
