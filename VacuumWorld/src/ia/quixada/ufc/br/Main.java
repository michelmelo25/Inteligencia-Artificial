package ia.quixada.ufc.br;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		
		int steps = 0;
		
		System.out.println("Loop:");
		steps = sc.nextInt();
		
		for (int i = 0; i < steps; i++) {
			controller.act();
		}
		controller.historico();
	}
}
