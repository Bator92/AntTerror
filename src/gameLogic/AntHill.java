package gameLogic;

public class AntHill extends Item { // ready

	private Field spawnField;
	private int timeBetweenRelease;
	private int countdownToRelease;
	
	AntHill(Field field) {
		super(field);
		int i = 0;
		while (this.field.getNeighbour(i) == null) ++i;
		
		this.spawnField = this.field.getNeighbour(i);
		this.timeBetweenRelease = 10;
		this.countdownToRelease = 1;
	}
	
	AntHill(Field field, int timeBetweenRelease, Field spawnField) {
		super(field);
		this.spawnField = spawnField;
		this.timeBetweenRelease = timeBetweenRelease;
		this.countdownToRelease = 0;
	}
	
	@Override
	public void act() {
		
		if (this.countdownToRelease <= 0) {
			this.spawnField.register(new Ant(this.spawnField));
			this.countdownToRelease = timeBetweenRelease;
		}
		
		this.countdownToRelease--;
	}
	
	@Override
	public void antInteract(Ant ant) {
		ant.arrivedHome();
	}
	
	@Override
	public void antEaterInteract(AntEater antEater) {
		// nothing happens here
	}
	
	@Override
	public void killerSprayInteract() {
		// nothing happens here
	}

	@Override
	public void stoneInteract(Stone stone) {
		// nothing happens here
	}

}
