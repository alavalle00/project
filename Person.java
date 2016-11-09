
public class Person {

	private String name;
	private int[] ratings;

	public Person(String name, int[] ratings) {
		this.name = name;
		this.ratings = ratings;
	}

	public String getName() {
		return name;
	}

	public int[] getRatings() {
		return ratings;
	}
	
	public String toString() {
		return this.name;
	}
}
