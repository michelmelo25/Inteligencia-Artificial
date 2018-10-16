package util;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

import map.No;

class ComparadorNo implements Comparator<No>{
	
	@Override
	public int compare(No a, No b) {
		return a.getH() - b.getH();
	}
	
}

class Predicado implements Predicate<No> {
	private String name;
	private int h;

	public Predicado(String name, int h) {
		super();
		this.name = name;
		this.h = h;
	}
	
	@Override
	public boolean test(No a) {
		return a.getState().getNome().equals(this.name) && a.getH() > this.h;
	}
	
}
public class FilaPrioridade extends PriorityQueue<No>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -193608073803771509L;
	
	public FilaPrioridade() {
		super(new ComparadorNo());
	}
	
	public boolean inserir(No e) {
		return this.add(e);
	}
	
	public No remover() {
		return this.poll();
	}
	
	public boolean vazia() {
		 return this.isEmpty();
	}
	
	public boolean melhorarNo(No e) {
		if(this.removeIf(new Predicado(e.getState().getNome(), e.getH()))) {
			return this.add(e);
		}
		return false;
	}
}
