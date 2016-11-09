
public class Book {
	private String author = "";
	private String title = "";
	private int rating = 0;

	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public Book(String author, String title, int rating) {
		this.author = author;
		this.title = title;
		this.rating = rating;
	}


	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
		return this.getTitle() + " by " + this.getAuthor();
	}

}
