package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import busca.heuristica.BuscaGulosa;
import busca.largura.*;

public class Controller {

    private ArrayList<State> states;
    private ArrayList<Action> actions;
    private Model model;
    private BuscaEmLargura buscaEmLargura;
    private BuscaGulosa buscaGulosa;

    public Controller() {
        super();
        this.states = new ArrayList<>();
        this.actions = new ArrayList<>();
        initializeStates();
        initializeActions();
        this.model = new Model(states, actions);
        this.buscaEmLargura = new BuscaEmLargura(states,actions);
        this.buscaGulosa = new BuscaGulosa(states, actions);
    }

    private void initializeStates() {
        State[] states1 = {
                new State("Oradea"),
                new State("Zerind"),
                new State("Arad"),
                new State("Timisoara"),
                new State("Lugoj"),
                new State("Mehadia"),
                new State("Drobeta"),
                new State("Sibiu"),
                new State("Rimnicu Vilcea"),
                new State("Craiova"),
                new State("Fagaras"),
                new State("Pitesti"),
                new State("Giurgiu"),
                new State("Bucharest"),
                new State("Eforie"),
                new State("Hirsova"),
                new State("Urziceni"),
                new State("Vaslui"),
                new State("Iasi"),
                new State("Neamt"),
        };

        for (State s : states1) {
            this.states.add(s);
        }
    }

    private void initializeActions() {
        Action[] actions = {
                new Action(new State("Oradea"), new State("Zerind"), 71),
                new Action(new State("Oradea"), new State("Sibiu"), 151),
                new Action(new State("Arad"), new State("Zerind"), 75),
                new Action(new State("Arad"), new State("Sibiu"), 140),
                new Action(new State("Arad"), new State("Timisoara"), 118),
                new Action(new State("Timisoara"), new State("Lugoj"), 111),
                new Action(new State("Lugoj"), new State("Mehadia"), 70),
                new Action(new State("Mehadia"), new State("Drobeta"), 75),
                new Action(new State("Drobeta"), new State("Craiova"), 120),
                new Action(new State("Craiova"), new State("Rimnicu Vilcea"), 146),
                new Action(new State("Craiova"), new State("Pitesti"), 138),
                new Action(new State("Rimnicu Vilcea"), new State("Sibiu"), 80),
                new Action(new State("Rimnicu Vilcea"), new State("Pitesti"), 97),
                new Action(new State("Sibiu"), new State("Fagaras"), 99),
                new Action(new State("Bucharest"), new State("Fagaras"), 211),
                new Action(new State("Bucharest"), new State("Pitesti"), 101),
                new Action(new State("Bucharest"), new State("Giurgiu"), 90),
                new Action(new State("Bucharest"), new State("Urziceni"), 85),
                new Action(new State("Urziceni"), new State("Hirsova"), 98),
                new Action(new State("Urziceni"), new State("Vaslui"), 142),
                new Action(new State("Hirsova"), new State("Eforie"), 86),
                new Action(new State("Vaslui"), new State("Iasi"), 92),
                new Action(new State("Iasi"), new State("Neamt"), 87)

        };
        for (Action a : actions) {
            this.actions.add(a);
        }
    }

    public void buscar(int ini, int fim, String busca) {
        if(busca.equals("largura")) {
	    	List<No> solucao = new ArrayList<>();
	        solucao = buscaEmLargura.Busca(new Problem(states.get(ini), states.get(fim)));
	        for (No node: solucao) {
	            System.out.println(node.getState().getNome());
	            System.out.println(node.getCusto());
	        }
        }
        else if(busca.equals("heuristica")) {
        	HashMap<String, No> solucao = new HashMap<>();
        	solucao = this.buscaGulosa.busca(new Problem(states.get(ini), states.get(fim)));
        	for(No node : solucao.values()) {
        		System.out.print("-> " + node.getState().getNome());
        	}
        	System.out.println("");
        }
    }

    public void showStates() {
    	model.showStates();
    }

    public void transicao() {
    	model.model();
    }

    public  void route(int c) {
    	model.sucessor(states.get(c));
    }
    
}
