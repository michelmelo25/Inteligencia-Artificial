package busca.largura;

import map.*;

public class No {

	private State state;
	private int custo;
	
	public No(State state, int custo) {
		this.state = state;
		this.custo = custo;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	
}
