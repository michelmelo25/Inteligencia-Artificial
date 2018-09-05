package map;

public class Action {

	private State u;
	private State v;
	private int weight;
	
	public Action(State u, State v, int weight) {
		super();
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public State getU() {
		return u;
	}

	public void setU(State u) {
		this.u = u;
	}

	public State getV() {
		return v;
	}

	public void setV(State v) {
		this.v = v;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
