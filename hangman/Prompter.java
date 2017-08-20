import java.util.Scanner;

class Prompter {
	private Game game;
	
	public Prompter(Game game) {
		this.game = game;
	}
	
	public boolean promptForGuess() {
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean acceptable = false;
		
		do {
			System.out.print("Enter a letter:  ");
			String guessInput = scanner.nextLine();

			try {
				isHit = game.applyGuess(guessInput);
				acceptable = true;
			} catch (IllegalArgumentException e) {
				System.out.printf("%s Please try again!%n", e.getMessage());
			}
		} while (! acceptable);

		return isHit;
	}
	
	public void displayProgress() {
		System.out.printf("You have %d guesses. Try to solve: %s%n", game.remainingGuesses(), game.getCurrentProgress());
	}
	
	public void displayOutcome() {
		if (game.isWon()) {
			System.out.printf("Congratulations, you won with %d tries remaining.%n", game.remainingGuesses());
		} else {
			System.out.printf("Bummer, you lost! The word was %s :( %n", game.getAnswer());
		}
	}
}