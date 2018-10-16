package busca.uniforme;

import java.util.*;

import busca.largura.Problem;
import map.Action;
import map.No;
import map.State;
import util.FilaPrioridade;

public class BuscaCustoUniforme {
	private ArrayList<Action> actions;
	private ArrayList<State> states;
    private Map<State,No> ant;
	
	public BuscaCustoUniforme(ArrayList<State> states, ArrayList<Action> actions) {
		this.states = states;
		this.actions = actions;
        this.ant = new HashMap<>();
	}
	
	public ArrayList<No> busca(Problem problem) {
		FilaPrioridade borda = new FilaPrioridade();
		ArrayList<String> explorados = new ArrayList<>();
		No init = criarNo(problem.getStateIni());
		borda.inserir(init);
		ant.put(init.getState(),init);
		while(!borda.vazia()) {
			No node = borda.remover();
			if(node.getState().getNome().equals(problem.getStateFim().getNome())) {
				return Solucao(init,node);
			}
			explorados.add(node.getState().getNome());
			for(State s : node.getAdj()) {
				No filho = criarNo(s);
				filho.setCusto(node.getCusto() + custo(s, node.getState()));
				filho.setH(filho.getCusto());
				if(!borda.contains(filho) && !explorados.contains(filho.getState().getNome())) {
					borda.inserir(filho);
					ant.put(filho.getState(),node);
				}else if(borda.contains(filho)){
					for (No n : borda) {
						if(n.getState().getNome().equals(filho.getState().getNome())){
							if (n.getCusto() > filho.getCusto()){
								borda.melhorarNo(filho);
								ant.remove(filho.getState());
								ant.put(filho.getState(),node);
							}
						}
					}
				}
			}
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

    private ArrayList<No> Solucao(No ini, No fim){
        ArrayList<No> solucao = new ArrayList<>();
        No node = ant.get(fim.getState());
        solucao.add(fim);
        solucao.add(node);
        while (node.getState().getNome() != ini.getState().getNome()) {
            node = ant.get(node.getState());
            solucao.add(node);
        }
        Collections.reverse(solucao);
        return solucao;
    }
}
