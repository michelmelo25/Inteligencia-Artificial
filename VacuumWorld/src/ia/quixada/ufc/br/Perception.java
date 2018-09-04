package ia.quixada.ufc.br;

public class Perception {
	
	private boolean location;
	private boolean isDirty;
	
	public Perception() {

	}

	public boolean isLocation() {
		return location;
	}

	public void setLocation(boolean location) {
		this.location = location;
	}

	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

	//Pair<Boolean, Boolean>
	public void getPerception(Environment env) {
		this.location = env.isAgentLocation();
		if(env.isAgentLocation()) {
			this.isDirty = env.isDirtyA();
		}
		else {
			this.isDirty = env.isDirtyB();
		}
		System.out.println("retornando perception");
        //System.out.println("---------------------------");
		return;
		// new Pair<>(this.location, this.isDirty)
	}
	
	@Override
	public boolean equals(Object other) {
		return this.isDirty == ((Perception) other).isDirty() &&
				this.location == ((Perception) other).isLocation();
	}

	@Override
	public String toString(){
        return location +" "+ isDirty;
    }
}
