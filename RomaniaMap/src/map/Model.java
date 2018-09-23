package map;

import java.util.ArrayList;

public class Model {

	public ArrayList<State> states;
	public ArrayList<Action> actions;
	
	public Model(ArrayList<State> states, ArrayList<Action> actions) {
		super();
		this.states = states;
		this.actions = actions;
	}

    public void showStates() {
	    int i = 0;
        for (State s: states) {
            System.out.println(i++ + " - " + s.getNome());
        }
    }

	public void model(){
	    for (Action a: actions) {
            show(a,true);

        }
    }

    public void sucessor(State state) {
        for (Action a : actions){
            if(a.getU().getNome().equals(state.getNome())) {
                show(a,true);
            }
            else if(a.getV().getNome().equals(state.getNome())) {
                show(a,false);
            }
        }
    }

    private void show(Action a, boolean p) {
	    if(p) {
            System.out.println("--------------------------------");
            System.out.println("|     DE     | " + String.format("%-15s",a.getU().getNome()) + " |");
            System.out.println("|    PARA    | " + String.format("%-15s",a.getV().getNome()) + " |");
            System.out.println("|     KM     | " + String.format("%-15s",a.getWeight())   + " |");
            System.out.println("--------------------------------");
        }
	    else {
            System.out.println("--------------------------------");
            System.out.println("|     DE     | " + String.format("%-15s",a.getV().getNome()) + " |");
            System.out.println("|    PARA    | " + String.format("%-15s",a.getU().getNome()) + " |");
            System.out.println("|     KM     | " + String.format("%-15s",a.getWeight())   + " |");
            System.out.println("--------------------------------");
        }

    }
}
