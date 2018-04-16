package geneticalgorithm;

public class Data {

	public static Schedule initialize() {
		Schedule schedule = new Schedule();

		// Set up rooms
		schedule.addRoom(1, "101", 15);
		schedule.addRoom(2, "102", 30);
		schedule.addRoom(4, "103", 20);
		schedule.addRoom(5, "104", 25);

		// Set up timeslots
		schedule.addTimeslot(1, "Mon 9:00 - 11:00");
		schedule.addTimeslot(2, "Mon 11:00 - 13:00");
		schedule.addTimeslot(3, "Mon 13:00 - 15:00");
		schedule.addTimeslot(4, "Tue 9:00 - 11:00");
		schedule.addTimeslot(5, "Tue 11:00 - 13:00");
		schedule.addTimeslot(6, "Tue 13:00 - 15:00");
		schedule.addTimeslot(7, "Wed 9:00 - 11:00");
		schedule.addTimeslot(8, "Wed 11:00 - 13:00");
		schedule.addTimeslot(9, "Wed 13:00 - 15:00");
		schedule.addTimeslot(10, "Thu 9:00 - 11:00");
		schedule.addTimeslot(11, "Thu 11:00 - 13:00");
		schedule.addTimeslot(12, "Thu 13:00 - 15:00");
		schedule.addTimeslot(13, "Fri 9:00 - 11:00");
		schedule.addTimeslot(14, "Fri 11:00 - 13:00");
		schedule.addTimeslot(15, "Fri 13:00 - 15:00");

		// Set up professors
		schedule.addProfessor(1, "Mr Maruti Zalte");
		schedule.addProfessor(2, "Mrs Korane");
		schedule.addProfessor(3, "Dr Grant Elliot");
		schedule.addProfessor(4, "Mr JJ Thompson");

		// Set up modules and define the professors that teach them
		schedule.addModule(1, "s1", "Spectrum", new int[] { 1, 2 });
		schedule.addModule(2, "cn1", "Computer Networks", new int[] { 1, 3 });
		schedule.addModule(3, "aa1", "Applied Maths", new int[] { 1, 2 });
		schedule.addModule(4, "ap1", "Applied Physics", new int[] { 3, 4 });
		schedule.addModule(5, "ac1", "Applied Chemistry", new int[] { 4 });
		schedule.addModule(6, "em1", "Engineering Mechanics", new int[] { 1, 4 });

		// Set up student groups and the modules they take.
		schedule.addGroup(1, 10, new int[] { 1, 3, 4 });
		schedule.addGroup(2, 30, new int[] { 2, 3, 5, 6 });
		schedule.addGroup(3, 18, new int[] { 3, 4, 5 });
		schedule.addGroup(4, 25, new int[] { 1, 4 });
		schedule.addGroup(5, 20, new int[] { 2, 3, 5 });
		schedule.addGroup(6, 22, new int[] { 1, 4, 5 });
		schedule.addGroup(7, 16, new int[] { 1, 3 });
		schedule.addGroup(8, 18, new int[] { 2, 6 });
		schedule.addGroup(9, 24, new int[] { 1, 6 });
		schedule.addGroup(10, 25, new int[] { 3, 4 });
		return schedule;
	}
}
