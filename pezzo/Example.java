import java.io.Console;

public class Example {
	public static void main(String[] args) {
		PezDispenser pezzo = new PezDispenser("Donatello");

		System.out.printf("Building %s Pez!%n", pezzo.getCharacterName());

		if (pezzo.isEmpry()) {
			System.out.println("Dispenser empty! Filling the PEZ...");
			pezzo.fill();
		}
		if (!pezzo.isEmpry()) {
			System.out.printf("Fully stocked with %d PEZ%n", pezzo.getPezCount());
		}

		while (pezzo.dispense()) {
			System.out.println("Nom!");
		}

		if (pezzo.isEmpry()) {
			System.out.println("Uh oh! You ate all the Pez...");
		}

		pezzo.fill(4);
		pezzo.fill(2);
		while (pezzo.dispense()) {
			System.out.println("Nom!!");
		}

		try {
			pezzo.fill(400);
			System.out.println("No can do!");
		} catch (IllegalArgumentException i) {
			System.out.printf("Ooops! can't fill up that much. %s%n", i.getMessage());
		}
	}
}