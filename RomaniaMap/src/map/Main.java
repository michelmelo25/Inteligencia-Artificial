package map;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		Controller c = new Controller();
        String city;
        State state;
        int op;
        int ct;
        int ini;
        int fim;

        System.out.println("0 - Sair");
        System.out.println("1 - Mostra Cidades");
        System.out.println("2 - Mostrasrotas de uma Cidade");
        System.out.println("3 - Mostra rota");
        op = sc.nextInt();

        while (op != 0){
            switch (op){
                case 1:
                    c.showStates();
                    break;
                case 2:
                    System.out.println("Qual cidade deseja visualizar?");
                    ct = sc.nextInt();
                    c.route(ct);
                    break;
                case 3:
                    System.out.println("Qual cidade deseja sair?");
                    ini = sc.nextInt();
                    System.out.println("Qual cidade deseja chegar?");
                    fim = sc.nextInt();
                    c.buscar(ini,fim, "heuristica");
                    break;
            }
            System.out.println("0 - Sair");
            System.out.println("1 - Mostras Cidades");
            System.out.println("2 - Mostras rodas de uma Cidade");
            System.out.println("3 - Mostra rota");
            op = sc.nextInt();
        }
//        System.out.println("");
	}
}
