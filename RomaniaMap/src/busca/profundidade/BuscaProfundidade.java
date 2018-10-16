package busca.profundidade;

import busca.largura.Problem;
import map.Action;
import map.No;
import map.State;

import java.util.*;

public class BuscaProfundidade {
    private ArrayList<Action> actions;
    private ArrayList<State> states;
    private Map<State,No> ant;

    public BuscaProfundidade(ArrayList<State> states, ArrayList<Action> actions){
        this.states = states;
        this.actions = actions;
        this.ant = new HashMap<>();
    }

    public  ArrayList<No> busca (Problem problem){
        Stack<No> borda = new Stack<>();
        ArrayList<String> explorados = new ArrayList<>();
        No ini = criarNo(problem.getStateIni());
        ant.put(ini.getState(),ini);
        if(problem.getStateFim().getNome().equals(problem.getStateIni().getNome())){
            return Solucao(ini,criarNo(problem.getStateFim()));
        }
        borda.push(ini);
        while (!borda.empty()){
            No no = borda.pop();
            explorados.add(no.getState().getNome());
            for (State s : no.getAdj()) {
                No filho = criarNo(s);
                filho.setCusto(no.getCusto() + custo(s, no.getState()));
                filho.setH(filho.getCusto());
                if(!explorados.contains(filho.getState().getNome())){
                    if(filho.getState().getNome().equals(problem.getStateFim().getNome())){
                        ant.put(filho.getState(),no);
                        return Solucao(ini, filho);
                    }
                    borda.push(filho);
                    ant.put(filho.getState(),no);
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
        while (!node.getState().getNome().equals(ini.getState().getNome())) {
            node = ant.get(node.getState());
            solucao.add(node);
        }
        Collections.reverse(solucao);
        return solucao;
    }
}
