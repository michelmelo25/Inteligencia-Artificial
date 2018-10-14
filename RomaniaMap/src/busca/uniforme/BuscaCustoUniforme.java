package busca.uniforme;

import java.util.ArrayList;

import busca.largura.Problem;
import map.Action;
import map.No;
import map.State;
import util.FilaPrioridade;

public class BuscaCustoUniforme {
	private ArrayList<Action> actions;
	private ArrayList<State> states;
	private ArrayList<No> solucao;
	
	public BuscaCustoUniforme(ArrayList<State> states, ArrayList<Action> actions) {
		this.states = states;
		this.actions = actions;
		this.solucao = new ArrayList<>();
	}
	
	public ArrayList<No> busca(Problem problem) {
		FilaPrioridade borda = new FilaPrioridade();
		ArrayList<String> explorados = new ArrayList<>();
		No init = criarNo(problem.getStateIni());
		borda.inserir(init);
		while(!borda.vazia()) {
			No node = borda.remover();
			if(node.getState().getNome().equals(problem.getStateFim().getNome())) {
				return this.solucao;
			}
			explorados.add(node.getState().getNome());
			for(State s : node.getAdj()) {
				No filho = criarNo(s);
				filho.setCusto(node.getCusto() + custo(s, node.getState()));
				filho.setH(filho.getCusto());
				if(filho.getState().getNome().equals(problem.getStateFim().getNome())) {
					borda.inserir(filho);
				}
				borda.melhorarNo(filho);
			}
			this.solucao.add(node);
		}
		return null;
	}
	
	public No criarNo(State state) {
		No no = new No(state, 0);
		for(Action a : this.actions) {
			if(a.getU().getNome().equals(state.getNome())) {
				no.addAdj(a.getV());
			}
			else if(a.getV().getNome().equals(state.getNome())) {
				no.addAdj(a.getU());
			}
		}
		return no;
	}
	
	public int custo(State s, State b) {
        for (Action a: this.actions) {
            if (a.getU().getNome().equals(s.getNome()) && a.getV().getNome().equals(b.getNome())) {
                return  a.getWeight();
            }
            else if(a.getV().getNome().equals(s.getNome()) && a.getU().getNome().equals(b.getNome())) {
                return a.getWeight();
            }
        }
        return 0;
	}
}
