package busca.largura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import map.Action;
import map.Model;
import map.State;

public class BuscaEmLargura {

	 private ArrayList<State> states;
	 private ArrayList<Action> actions;
	    
	public BuscaEmLargura(ArrayList<State> states, ArrayList<Action> actions) {
		super();
		this.states = states;
		this.actions = actions;
	}

	public boolean Busca(Problem problem){
		No no = new No(problem.getStateIni(), 0);
		if(no.getState().equals(problem.getStateFim())) return true;
		
		 Queue<No> borda = new LinkedList<>();
		 List<State> explorados = new ArrayList<>();
		 
		 borda.add(no);
		 while (!borda.isEmpty()) {
			
			
		 }
		 return false;
	}
}
