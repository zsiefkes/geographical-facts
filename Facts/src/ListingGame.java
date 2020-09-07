import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ListingGame {
	
	public ListingGame() {
		Map<String, Set<String>> players = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("How many players?");
		int numPlayers = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Player " + i + "'s name:");
			String name = scan.nextLine();
			Set<String> items = oneGame(scan, "animals that are blue");
			players.put(name,  items);
		}
		for (String p : players.keySet()) {
			System.out.println("Items from " + p + ":");
			for (String i : players.get(p)) {
				System.out.println("  " + i);
			}
		}
	}
	
	private Set<String> oneGame(Scanner scan, String prompt) {
		System.out.println("Enter as many " + prompt + " as you can, then an empty line");
		Set<String> items = new HashSet<String>();
		String item = scan.nextLine();
		while (!"".equals(item)) {
			if (!items.add(item)) {
				System.out.println("You already gave " + item);
			}
			item = scan.nextLine();
		}
		System.out.println("You had " + items.size() + " unique items.");
		return items;
	}
	
	public static void main(String[] args) {
		new ListingGame();
	}
}
