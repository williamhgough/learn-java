public class Hangman {
	public static void main(String[] args) {
		Game game = new Game(args[0]);
		Prompter prompt = new Prompter(game);
		prompt.displayProgress();

		while (!game.isWon() && game.remainingGuesses() > 0) {
			prompt.promptForGuess();
			prompt.displayProgress();
		}
		prompt.displayOutcome();
	}
}