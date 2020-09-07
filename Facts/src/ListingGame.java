import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListingGame {
	
	public ListingGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter as many animals that are blue as you can, then an empty line");
		Set<String> items = new HashSet<String>();
		String item = scan.nextLine();
		while (!"".equals(item)) {
			items.add(item);
			item = scan.nextLine();
		}
		System.out.println("You had " + items.size() + " unique items.");
	}
	
	public static void main(String[] args) {
		new ListingGame();
	}
}
