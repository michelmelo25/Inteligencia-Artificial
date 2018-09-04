package ia.quixada.ufc.br;

import java.util.ArrayList;
import java.util.List;

public class SimpleReflexAgent extends Agent{
	
	public SimpleReflexAgent(List<Perception> perceptions, List<Action> actions) {
		super();
	}
	
	public SimpleReflexAgent() {
		super();
	}

	public String acti(Perception perception) {
		if(perception.isDirty()) {
			return "Aspire";
		}
		else {
			if(perception.isLocation()) {
				return "Right";
			}
			else {
				return "Left";
			}
		}
	}
}
