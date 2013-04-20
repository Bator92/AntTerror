package gameLogic;

public class Stone extends Item { // ready
	
	private Field nbField = null;
	private int fromWhere; // TODO �j attibr�tum!
	
	Stone(Field field) {
		super(field);
	}

	@Override
	public void act() {
		// nothing happens here
	}

	@Override
	public void antInteract(Ant ant) {
		// nothing happens here
	}
	
	/*******
	 0 1   
	5 I 2
	 4 3
	
	if comesFrom=5 --> futherTo=2 ...
	 *******/
	
	@Override
	public void antEaterInteract(AntEater antEater) {
		int comesFrom = antEater.getFromWhere();
		this.fromWhere = (comesFrom + 3) % 6;
		this.nbField = this.field.getNeighbour(this.fromWhere);
		ItemManagableByItem item = this.nbField.getItem();
		
		if (item != null)
			item.stoneInteract(this);
		else {
			this.field.deregister();
			this.nbField.register(this);
		}
	}

	@Override
	public void killerSprayInteract() {
		// nothing happens here
	}

	@Override
	public void stoneInteract(Stone stone) {
		int comesFrom = stone.getFromWhere();
		int furtherTo = (comesFrom + 3) % 6;
		this.nbField = this.field.getNeighbour(furtherTo);
		
		if (this.nbField.getItem() == null) {
			this.dereg();
			this.reg();
			stone.push();
		}
	}
	
	public void push(){
		this.dereg();
		this.reg();
	}

	public int getFromWhere() { // TODO �j fv�ny!
		return this.fromWhere;
	}
	
	private void reg() { // TODO �j fv�ny!
		this.nbField.register(this);
		this.field = this.nbField;
		this.nbField = null;
	}
	
	private void dereg() { // TODO �j fv�ny
		this.field.deregister();
		this.field = null;
	}
}
