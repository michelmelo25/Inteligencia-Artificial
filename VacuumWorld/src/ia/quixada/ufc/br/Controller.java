package ia.quixada.ufc.br;

import java.util.List;

public class Controller {
	
	private Environment environment;
	private Perception perception;
	private SimpleReflexAgent agent;
	
	public Controller() {
		this.environment = new Environment();
		this.environment.setAgentLocation(true);
		this.environment.setDirtyA(true);
		this.environment.setDirtyB(true);
		this.perception = new Perception();
		this.agent = new SimpleReflexAgent();
	}
	public void act() {
		this.perception.getPerception(this.environment);
		agent.setPerception(perception);
        System.out.println(perception.toString());
		Action action;
		String acao = this.agent.acti(this.perception);
		action = new Action(acao);

		System.out.println(action.getAction());
        System.out.println("---------------------------");

		if(action.getAction().equals("Aspire")) {
			if(this.environment.isAgentLocation()) {
				this.environment.setDirtyA(false);
			}
			else {
				this.environment.setDirtyB(false);
			}
		}
		else if(action.getAction().equals("Right")) {
			
			this.environment.setAgentLocation(false);
		}
		else if(action.getAction().equals("Left")) {
			this.environment.setAgentLocation(true);
		}
	}

	public void historico(){
        List<Perception> percep = agent.getPerception();
        System.out.println("Historico de percepcoes");
        System.out.println("---------------------------");
	    for (int i=0; i< percep.size();i++){
            System.out.println(percep.get(i).isLocation());
            System.out.println(percep.get(i).isDirty());
//            if (p.isLocation()){
//                System.out.println("Sala A");
//            }else{
//                System.out.println("Sala B");
//            }
//
//            if (p.isDirty()){
//                System.out.println("Limpa");
//            }else {
//                System.out.println("Suja");
//            }
            System.out.println("---------------------------");
        }
    }
	
}
