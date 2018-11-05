package gerador;

public class GeradorCNF {

	private int m[][];
	private int l[][];
	private int c[][];

	public GeradorCNF(int n) {
		InicializarMatriz(n);
//		CNFLinha(n);
		CNFColuna(n);
	}
	
	private void InicializarMatriz(int n) {
		m = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				m[i][j] = (i+1) * 10 + (j+1);
			}
		}
	}
	
	private void CNFLinha(int n) {
		l = new int [24][2];
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = j+1; j2 < n; j2++) {
					l[k][0] = m[i][j];
					l[k][1] = m[i][j2];
					k++;
				}				
			}
		}
		
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(l[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private void CNFColuna(int n) {
		c = new int [24][2];
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = j+1; j2 < n; j2++) {
					c[k][0] = m[j][i];
					c[k][1] = m[j2][i];
					k++;
				}				
			}
		}
		
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
