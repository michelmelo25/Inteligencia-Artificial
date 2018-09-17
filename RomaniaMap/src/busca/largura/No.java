package busca.largura;

import java.util.ArrayList;
import java.util.List;

import map.*;

public class No {

	private State state;
	private int custo;
	private List<No> adj;
	
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

	public List<No> getAdj() {
		return adj;
	}

	public void setAdj(List<No> adj) {
		this.adj = adj;
	}
	
	public void addAdj(No no) {
		adj.add(no);
	}
	
}
