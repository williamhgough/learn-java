import java.io.Console;

class PezDispenser {
	public static final int MAX_PEZ = 12;
	final private String characterName;
	private int pezCount;

	public PezDispenser(String characterName) {
		this.characterName = characterName;
		this.pezCount = 0;
	}

	public void fill() {
		fill(MAX_PEZ);
	}

	public void fill(int amount) {
		int newAmount = this.pezCount + amount;
		if (newAmount > MAX_PEZ) {
			throw new IllegalArgumentException("Too many PEZ!!");
		}
		this.pezCount += amount;
	}

	public int getPezCount() {
		return this.pezCount;
	}

	public boolean isEmpry() {
		return this.pezCount == 0;
	}

	public String getCharacterName() {
		return this.characterName;
	}

	public boolean dispense() {
		boolean wasDispensed = false;
		if (!isEmpry()) {
			this.pezCount--;
			wasDispensed = true;
		}
		return wasDispensed;
	}
}