package map;

import java.util.ArrayList;
import java.util.List;

public class No {

	private State state;
	private int custo;
	private int h;
	private List<State> adj;
	
	public No(State state, int custo, int h) {
		this.state = state;
		this.custo = custo;
		this.h = h;
		adj = new ArrayList<>();
	}
	
	public No(State state, int custo) {
		this.state = state;
		this.custo = custo;
		this.adj = new ArrayList<>();
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
	
	public int getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
}
