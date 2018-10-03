package busca.heuristica;

import java.util.ArrayList;

import busca.largura.Problem;
import map.Action;
import map.No;
import map.State;
import util.FilaPrioridade;

public class BuscaAEstrela  extends BuscaGulosa {

	public BuscaAEstrela(ArrayList<State> states, ArrayList<Action> actions) {
		super(states, actions);
	}
	
	@Override
	public ArrayList<No> busca(Problem problem) {
		FilaPrioridade borda = new FilaPrioridade();
		ArrayList<String> explorados = new ArrayList<>();
		No no = criarNo(problem.getStateIni());
		borda.inserir(no);
		this.solucao.add(no);
		if(no.getState().getNome().equals(problem.getStateFim().getNome())) {
			return this.solucao;
		}
		
		while(!borda.vazia()) {
			No node = borda.remover();
			explorados.add(node.getState().getNome());
			if(node.getState().getNome().equals(problem.getStateFim().getNome())) {
				return this.solucao;
			}
			No filho = null;
			for(State s : node.getAdj()) {
				No other = criarNo(s);
				other.setCusto(custo(s, node.getState()) + node.getCusto());
				if(filho == null) {
					filho = other;
				}
				else if (filho.getH() + custo(filho.getState(), node.getState()) > other.getH() + custo(other.getState(), node.getState())) {
					filho = other;
				}
			}
			this.solucao.add(filho);
			borda.inserir(filho);
		}
		return null;
	}
}
