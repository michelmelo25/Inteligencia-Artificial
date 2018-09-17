package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import busca.largura.No;

public class Controller {

    private ArrayList<State> states;
    private ArrayList<Action> actions;
    private Map<String, Integer> h;
    private  Model model;

    public Controller() {
        super();
        this.states = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.h = new HashMap<>();
        initializeStates();
        initializeActions();
        initializeHeuristic();
        this.model = new Model(states, actions);
    }

    private void initializeStates() {
        State[] states1 = {
                new State("Oradea"),
                new State("Zerid"),
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
                new Action(new State("Bucharest"), new State("Fagaras"), 21),
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

    public void showStates(){ model.showStates();}

    public void transicao(){ model.model();}

    public  void route(int c){ model.sucessor(states.get(c));}
    
    private void initializeHeuristic() {
    	this.h.put("Arad", 366);
    	this.h.put("Bucharest", 0);
    	this.h.put("Craiova", 160);
    	this.h.put("Drobeta", 242);
    	this.h.put("Efoire", 161);
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
}
