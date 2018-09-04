package ia.quixada.ufc.br;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	
	protected List<Perception> perceptions;
	public Agent() {
		this.perceptions = new ArrayList<>();
	}
	public List<Perception> getPerception() {
		return perceptions;
	}
	public void setPerception(Perception perception) {
		System.out.println("-----------");
		System.out.println("add percepcao");
		System.out.println(perception.toString());
		System.out.println("-----------");
		this.perceptions.add(perception);
	}
	
}
