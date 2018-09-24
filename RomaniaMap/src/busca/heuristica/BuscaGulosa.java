package busca.heuristica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import busca.largura.Problem;
import map.Action;
import map.No;
import map.State;
import util.FilaPrioridade;

public class BuscaGulosa {
	
//	private ArrayList<State> states;
	private ArrayList<Action> actions;
	private HashMap<String, Integer> h;
	private ArrayList<No> solucao;
	
	
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
		No no = criarNo(problem.getStateIni());
		borda.inserir(no);
		this.solucao.add(no);
		if(no.getState().getNome().equals(problem.getStateFim().getNome())) {
			return this.solucao;
		}
		
		while(!borda.vazia()) {
			No node = borda.remover();
			explorados.add(node.getState().getNome());
			if(node.getState().getNome().equals(problem.getStateFim().getNome())) {
				return this.solucao;
			}
			No filho = null;
			for(State s : node.getAdj()) {
				No other = criarNo(s);
				if(filho == null) {
					filho = other;
				}
				else if (filho.getH() > other.getH()) {
					filho = other;
				}
			}
			this.solucao.add(filho);
			borda.inserir(filho);
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
}
