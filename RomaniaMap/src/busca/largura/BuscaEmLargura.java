package busca.largura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		
		 List<No> borda = new LinkedList<No>();
		 List<State> explorados = new ArrayList<>();
		 
		 borda.add(no);
		 while (!borda.isEmpty()) {
			No node = borda.remove(0); 
			explorados.add(node.getState());
			
			No filho = Filho(node, explorados);
			while (filho != null) {
				if(!explorados.contains(filho)) {
					if(filho.getState().equals(problem.getStateFim())) {
						//retorna solução
					}
					borda.add(filho);
				}
			}
			
		 }
		 return false;
	}
	
	private No Filho(No no, List<State> explorados){
		for (Action act : this.actions) {
			//Se vertice U for igual ao nó e o vertice V não foi explorado
			if(act.getU().equals(no.getState()) && !explorados.contains(act.getV())) {
				//retorna vertice V
				return new No(act.getV(), no.getCusto() + act.getWeight());
				//Se vertice V for igual ao nó e o vertice U não foi explorado
			}else if(act.getV().equals(no) && !explorados.contains(act.getU())) {
				//retorna vertice U
				return new No(act.getU(), no.getCusto() + act.getWeight());
			}
		}
		return null;
	}
}
