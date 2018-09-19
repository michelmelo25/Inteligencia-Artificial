package busca.heuristica;

import java.util.*;
import busca.largura.*;
import map.*;

public class BuscaGulosa {
	
	private ArrayList<State> states;
	private ArrayList<Action> actions;
	private HashMap<String, Integer> h;
	
	
	public BuscaGulosa() {
		this.h = new HashMap<>();
		this.initializeHeuristic();
	}
	public List<No> busca(Problem problem) {
		
		return null;
	}
	
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
