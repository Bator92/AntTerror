package gameLogic;

public interface ItemManagableByItem { // ready
	public void antInteract(Ant ant);
	public void antEaterInteract(AntEater antEater);
	public void killerSprayInteract();
	public void stoneInteract(Stone stone); // TODO v�ltoz�s: +1 argumentum
}
