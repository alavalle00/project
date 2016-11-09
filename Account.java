
public class Account {

	private String name;
	private int[] ratings;
	private String password;

	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Account(String name, int[] ratings, String password) {
		this.name = name;
		this.ratings = ratings;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public int[] getRatings() {
		return ratings;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword() {
		this.password = password;
	}

	public String toString() {
		return this.name;
	}
}
