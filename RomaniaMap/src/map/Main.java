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

        System.out.println("0 - Sair");
        System.out.println("1 - Mostras Cidades");
        System.out.println("2 - Mostras rodas de uma Cidade");
        op = sc.nextInt();

        while (op != 0){
            switch (op){
                case 1:
                    c.showStates();
                case 2:
                    System.out.println("Qual cidade deseja visualizar?");
                    ct = sc.nextInt();
                    c.route(ct);
            }
            System.out.println("0 - Sair");
            System.out.println("1 - Mostras Cidades");
            System.out.println("2 - Mostras rodas de uma Cidade");
            op = sc.nextInt();
        }
//        System.out.println("");
	}
}
