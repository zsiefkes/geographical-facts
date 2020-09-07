import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GeoFact {

	private Map<String, String> capitals = new HashMap<>();
	private Map<String, String> countries = new HashMap<>();
	
	public GeoFact() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(capitals.size() + " in database");
			System.out.println("[a]dd or [s]earch by country or [c]ity?");
			String cmd = scan.nextLine();
			if ("a".equals(cmd)) {
				System.out.println("Country:");
				String country = scan.nextLine();
				System.out.println("Capital city:");
				String city = scan.nextLine();
				capitals.put(country, city);
				countries.put(city, country);
			} else if ("s".equals(cmd)) {
				System.out.println("Country:");
				String country = scan.nextLine();
				if (capitals.containsKey(country)) {
					System.out.println("Capital: " + capitals.get(country));
				} else {
					System.out.println(country + " is not in the database");
				}
			} else if ("c".equals(cmd)) {
				System.out.println("Capital:");
				String city = scan.nextLine();
				if (countries.containsKey(city)) {
					System.out.println("Country: " + countries.get(city));
				} else {
					System.out.println(city + " is not in the database");
				}
			} else if ("q".equals(cmd)) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new GeoFact();
	}

}
