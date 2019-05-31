package lab07;

public abstract class Herbivore extends Animal{
	private String foliage;
	private int aggressionLevel;
	
	abstract void graze();
	
	public Herbivore(String aFoliage, int agLevel) {
		this.foliage = aFoliage;
		this.aggressionLevel = agLevel;
	}

	public String getFoliage() {
		return foliage;
	}

	public int getAggressionLevel() {
		return aggressionLevel;
	}
	
	
}
