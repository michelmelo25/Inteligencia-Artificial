package ia.quixada.ufc.br;

public class Environment {
	
	private boolean isDirtyA;
	private boolean isDirtyB;
	private boolean agentLocation;
	
	public Environment() {
		super();
	}
	
	public boolean isDirtyA() {
		return isDirtyA;
	}
	public void setDirtyA(boolean isDirtyA) {
		this.isDirtyA = isDirtyA;
	}
	public boolean isDirtyB() {
		return isDirtyB;
	}
	public void setDirtyB(boolean isDirtyB) {
		this.isDirtyB = isDirtyB;
	}
	public boolean isAgentLocation() {
		return agentLocation;
	}
	public void setAgentLocation(boolean agentLocation) {
		this.agentLocation = agentLocation;
	}
	
}
