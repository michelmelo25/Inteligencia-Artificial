package busca.largura;

import java.util.*;

import map.Action;
import map.No;
import map.State;
import util.Fila;

public class BuscaEmLargura {

	 private ArrayList<State> states;
	 private ArrayList<Action> actions;
	 private Map<State,No> ant;
	    
	public BuscaEmLargura(ArrayList<State> states, ArrayList<Action> actions) {
		super();
		this.states = states;
		this.actions = actions;
		this.ant = new HashMap<>();
	}

	public List<No> Busca(Problem problem) {
        No no = CriarNo(problem.getStateIni(), 0);
        if(no.getState().equals(problem.getStateFim())) {
            return Solucao(no, no);
        }

        ant.put(no.getState(),no);
        Fila<No> borda = new Fila<>();
        ArrayList<State> explorados = new ArrayList<>();

        borda.insere(no);
        while (!borda.vazia()){
            No node = borda.remove();
            explorados.add(node.getState());
            for (State state: node.getAdj()) {
            	No filho = CriarNo(state,node.getCusto()+Custo(node.getState(),state));
            	if (!explorados.contains(filho.getState())) {
            		ant.put(filho.getState(),node);
                    if(filho.getState().getNome().equals(problem.getStateFim().getNome())) {
                        return Solucao(no,filho);
                    }
                    borda.insere(filho);
                }
        	}
        }
        return null;
	}

	private List<No> Solucao(No ini, No fim){
	    List<No> solucao = new ArrayList<No>();
	    No node = ant.get(fim.getState());
	    solucao.add(fim);
	    solucao.add(node);
	    int i = 1;
	    while (node.getState().getNome() != ini.getState().getNome()) {
//            System.out.println(i);
            i++;
	        node = ant.get(node.getState());
	        solucao.add(node);
        }
	    Collections.reverse(solucao);
	    return solucao;
    }

	private No CriarNo(State state, int custo){
	    No no = new No(state,custo);
        for (Action a: actions) {
            if (a.getV().getNome().equals(state.getNome())){
                no.addAdj(a.getU());
            }
            else if(a.getU().getNome().equals(state.getNome())){
                no.addAdj(a.getV());
            }
        }
	    return  no;
    }

    private int Custo(State s, State b){
        for (Action a: actions) {
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
