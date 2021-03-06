package busca.heuristica;

import java.util.ArrayList;
import java.util.HashMap;

import busca.largura.Problem;
import map.Action;
import map.No;
import map.State;
import util.FilaPrioridade;

public class BuscaGulosa {
	
//	private ArrayList<State> states;
	protected ArrayList<Action> actions;
	protected HashMap<String, Integer> h;
	protected ArrayList<No> solucao;
	
	
	public BuscaGulosa(ArrayList<State> states, ArrayList<Action> actions) {
//		this.states = states;
		this.actions = actions;
		this.solucao = new ArrayList<>();
		this.h = new HashMap<>();
		this.initializeHeuristic();
	}
	public ArrayList<No> busca(Problem problem) {
		FilaPrioridade borda = new FilaPrioridade();
		ArrayList<String> explorados = new ArrayList<>();
		No init = criarNo(problem.getStateIni());
		borda.inserir(init);
		while(!borda.vazia()) {
			No node = borda.remover();
			this.solucao.add(node);
			explorados.add(node.getState().getNome());
			if(node.getState().getNome().equals(problem.getStateFim().getNome())) {
				return this.solucao;
			}
			for(State s : node.getAdj()) {
				No filho = criarNo(s);
				filho.setCusto(custo(s, node.getState()) + node.getCusto());
				if(!explorados.contains(filho.getState().getNome())) {		
					borda.inserir(filho);
				}
			}
		}
		return null;
	}
	
	private void initializeHeuristic() {
    	this.h.put("Arad", 366);
    	this.h.put("Bucharest", 0);
    	this.h.put("Craiova", 160);
    	this.h.put("Drobeta", 242);
    	this.h.put("Eforie", 161);
    	this.h.put("Fagaras", 176);
    	this.h.put("Giurgiu", 77);
    	this.h.put("Hirsova", 151);
    	this.h.put("Iasi", 226);
    	this.h.put("Lugoj", 244);
    	this.h.put("Mehadia", 241);
    	this.h.put("Neamt", 234);
    	this.h.put("Oradea", 380);
    	this.h.put("Pitesti", 100);
    	this.h.put("Rimnicu Vilcea", 193);
    	this.h.put("Sibiu", 253);
    	this.h.put("Timisoara", 329);
    	this.h.put("Urziceni", 80);
    	this.h.put("Vaslui", 199);
    	this.h.put("Zerind", 374);
    }
	
	public No criarNo(State state) {
		No no = new No(state, 0, this.h.get(state.getNome()));
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
