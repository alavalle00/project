import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static String bookFile = "books.txt";
	public static String ratingFile = "ratings.txt";
	public static ArrayList<Book> books;
	public static ArrayList<Person> people;
	public static ArrayList<Account> accounts;
	static Scanner reader;

	public static boolean isLoggedIn = false;

	public static void main(String[] args) throws IOException {
		accounts = new ArrayList<Account>();
		reader = new Scanner(System.in);
		generateBookList();
		generateUserList();
		welcome();

		if (isLoggedIn) {
			System.out.println("Hello!");
		}
	}

	public static void welcome() {
		System.out.println("Welcome!");
		System.out.println("Please select an option:");
		System.out.println("1. Login");
		System.out.println("2. Sign up");
		int answer = reader.nextInt();
		if (answer == 1) {
			login();
		} else if (answer == 2) {
			signup();
		} else {
			System.out.println("Please input a valid option.");
			welcome();
		}
		System.out.println();
	}

	public static void login() {
		reader.nextLine(); // because nextInt() above breaks it
		System.out.print("Username: ");
		String username = reader.nextLine();
		System.out.println();
		System.out.print("Password:");
		String password = reader.nextLine();
		System.out.println();

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(username)) {
				if (accounts.get(i).getPassword().equals(password)) {
					isLoggedIn = true;
				}
			}
		}
		
	}

	public static void signup() {
		reader.nextLine(); // because nextInt() above breaks it
		System.out.print("Username: ");
		String username = reader.nextLine();
		System.out.println();
		System.out.print("Password:");
		String password = reader.nextLine();
		System.out.println();
		System.out.print("Confirm password:");
		String confirmation = reader.nextLine();
		System.out.println();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(username)) {
				System.out.println("Username is already taken.");
				signup();
			}
		}

		if (!password.equals(confirmation)) {
			System.out.println("Passwords did not match");
			signup();
		} else {
			accounts.add(new Account(username, password));
			welcome();
		}
	}

	public static void generateUserList() throws IOException {
		people = new ArrayList<Person>();
		Scanner ratingsReader = new Scanner(new FileReader(ratingFile));
		String line;
		while (ratingsReader.hasNextLine()) {
			line = ratingsReader.nextLine();
			String name = line;
			line = ratingsReader.nextLine();
			String[] ratingsStrings = line.split(" ");
			int[] ratings = new int[ratingsStrings.length];
			for (int i = 0; i < ratings.length; i++) {
				ratings[i] = Integer.parseInt(ratingsStrings[i]);
			}
			Person temp = new Person(name, ratings);
			people.add(temp);
		}

	}

	public static void generateBookList() throws IOException {
		books = new ArrayList<Book>();

		Scanner bookReader = new Scanner(new FileReader(bookFile));

		String line;
		while (bookReader.hasNextLine()) {
			line = bookReader.nextLine();

			String author = line.substring(0, line.indexOf(","));
			String title = line.substring(line.indexOf(",") + 1, line.length());

			Book temp = new Book(author, title);
			books.add(temp); // Populate the list
		}
	}

}
