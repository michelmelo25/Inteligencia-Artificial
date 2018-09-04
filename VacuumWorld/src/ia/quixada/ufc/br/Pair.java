package ia.quixada.ufc.br;

public class Pair<T, G> {
	private T x;
	private G y;
	
	public Pair(T x, G y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public G getY() {
		return y;
	}
	public void setY(G y) {
		this.y = y;
	}
	
}
