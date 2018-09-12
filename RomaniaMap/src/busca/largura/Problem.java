package busca.largura;

import map.State;

public class Problem {

	private State stateIni;
	private State stateFim;
	
	public Problem(State stateIni, State stateFim) {
		super();
		this.stateIni = stateIni;
		this.stateFim = stateFim;
	}
	public State getStateIni() {
		return stateIni;
	}
	public void setStateIni(State stateIni) {
		this.stateIni = stateIni;
	}
	public State getStateFim() {
		return stateFim;
	}
	public void setStateFim(State stateFim) {
		this.stateFim = stateFim;
	}
	
	
}
