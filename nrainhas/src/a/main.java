package a;

import java.util.Scanner;

import gerador.GeradorCNF;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GeradorCNF gerador;
		int n;
		
		n = sc.nextInt();
		gerador = new GeradorCNF(n);
	}	
}
