package domain;

/**
 * Simple Room abstraction -- used to store the room capacity and compare against the student Group's size.
 */
public class Room {
	private final int id;
	private final String number;
	private final int capacity;

	/**
	 * Initialize new Room
	 * 
	 * @param id
	 *            The ID for this classroom
	 * @param number
	 *            The room number
	 * @param capacity
	 *            The room capacity
	 */
	public Room(int id, String number, int capacity) {
		this.id = id;
		this.number = number;
		this.capacity = capacity;
	}

	/**
	 * Return roomId
	 * 
	 * @return roomId
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Return room number
	 * 
	 * @return roomNumber
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Return room capacity
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
}