import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
		Map<String, Integer> itemCounts = this.countItems(players);
		Map<String, Integer> playerScores = new HashMap<>();
		this.computePlayerScores(playerScores, players, itemCounts);
		List<String> playerOrder = this.orderPlayers(playerScores);
		for (String p : playerOrder) {
			System.out.println(p + "\t" + playerScores.get(p));
		}
	}
	
	private List<String> orderPlayers(Map<String, Integer> scores) {
		List<String> players = new ArrayList<>(scores.keySet());
		players.sort((a,b) -> {
			return scores.get(b) - scores.get(a);
		});
		return players;
	}
	
	private void computePlayerScores(Map<String, Integer> scores, Map<String, Set<String>> players,
			Map<String, Integer> itemCounts) {
		for (String p : players.keySet()) {
			scores.put(p, computeScore(players.get(p),
					itemCounts));
		}
	}
	
	private int computeScore(Set<String> items,
			Map<String, Integer> counts) {
		int max = 0;
		for (Map.Entry<String, Integer> e : counts.entrySet()) {
			if (e.getValue() > max)
				max = e.getValue();
		}
		max = max + 1;
		int score = 0;
		for (String i : items) {
			score = score + (max - counts.get(i));
		}
		return score;
	}
	
	
	
	private Map<String, Integer> countItems(Map<String, Set<String>> data) {
		Map<String, Integer> counts = new HashMap<>();
		for (Map.Entry<String, Set<String>> e : data.entrySet()) {
			for (String s : e.getValue()) {
				if (counts.containsKey(s)) {
					counts.put(s, counts.get(s) + 1);
				} else {
					counts.put(s, 1);
				}
			}
		}
		System.out.println("Total appearances:");
		for (Map.Entry<String, Integer> e : counts.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		return counts;
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
