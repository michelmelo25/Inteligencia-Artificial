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
		No init = criarNo(problem.getStateIni());
		borda.inserir(init);
		if(init.getState().getNome().equals(problem.getStateFim().getNome())) {
			return this.solucao;
		}
		
		while(!borda.vazia()) {
			No node = borda.remover();
			explorados.add(node.getState().getNome());
			this.solucao.add(node);
			if(node.getState().getNome().equals(problem.getStateFim().getNome())) {
				return this.solucao;
			}
			for(State s : node.getAdj()) {
				No filho = criarNo(s);
				filho.setCusto(custo(s, node.getState()) + node.getCusto());
				filho.setH(filho.getH() + custo(s, node.getState()));
				if(!explorados.contains(filho.getState().getNome())) {
					borda.inserir(filho);
				}
			}
		}
		return null;
	}
}
