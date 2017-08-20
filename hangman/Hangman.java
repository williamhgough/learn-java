public class Hangman {
	public static void main(String[] args) {
		Game game = new Game("treehouse");
		Prompter prompt = new Prompter(game);
		prompt.displayProgress();

		while (game.getCurrentProgress().indexOf("_") != -1 && game.remainingGuesses() > 0) {
			boolean isHit = prompt.promptForGuess();
			if (isHit) {
				System.out.printf("You got a hit!%n");
			} else {
				System.out.printf("Ooops, missed!%n");
			}
			prompt.displayProgress();
		}
	}
}