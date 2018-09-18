package busca.largura;

import java.util.ArrayList;
import java.util.List;

import map.*;

public class No {

	private State state;
	private int custo;
	private List<State> adj;
	
	public No(State state, int custo) {
		this.state = state;
		this.custo = custo;
		adj = new ArrayList<>();
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

	public List<State> getAdj() {
		return adj;
	}

	public void setAdj(List<State> adj) {
		this.adj = adj;
	}
	
	public void addAdj(State state) {
		adj.add(state);
	}
	
}
