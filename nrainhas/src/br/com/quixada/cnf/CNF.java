package br.com.quixada.cnf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CNF {
    private int m[][];
    private int l[][];

    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    public CNF(int n){
        try{
            InicializarMatriz(n);
            file = new File("outrainha"+String.valueOf(n)+".txt");
            file.createNewFile();
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("c essa eh uma codificacao para nrainhas");
            bufferedWriter.newLine();
            bufferedWriter.write("p cnf ");
            bufferedWriter.write(String.valueOf(n*n));
            bufferedWriter.write(" ");
            bufferedWriter.write(String.valueOf((n*7)*2)); //acresentar formula das colunas
            bufferedWriter.newLine();
            CNFLinha(n);
            CNFColuna(n);
            CNFDiagonalPrincipal(n);
            CNFDiagonalSegundaria(n);
            bufferedWriter.close();
            fileWriter.close();


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void InicializarMatriz(int n){
        m = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                m[i][j] = (i+1) * 10 + (j+1);
            }
        }
    }

    private void CNFLinha(int n) {
        try{
            bufferedWriter.write("c Restrição das Linha");
            bufferedWriter.newLine();
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++){
                    bufferedWriter.write(String.valueOf(m[0][k]));
                    bufferedWriter.write(" ");
                }
                bufferedWriter.write("0");
                bufferedWriter.newLine();

                for (int j = 0; j < n; j++) {
                    for (int j2 = j+1; j2 < n; j2++) {
                        Escrever(m[i][j], m[i][j2]);
//                        bufferedWriter.write(String.valueOf(-m[i][j]));
//                        bufferedWriter.write(" ");
//                        bufferedWriter.write(String.valueOf(-m[i][j2]));
//                        bufferedWriter.write(" ");
//                        bufferedWriter.write("0");
//                        bufferedWriter.newLine();
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void CNFColuna(int n) {
        try{
            bufferedWriter.write("c Restrição das Coluna");
            bufferedWriter.newLine();
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++){
                    bufferedWriter.write(String.valueOf(m[k][0]));
                    bufferedWriter.write(" ");
                }
                bufferedWriter.write("0");
                bufferedWriter.newLine();

                for (int j = 0; j < n; j++) {
                    for (int j2 = j+1; j2 < n; j2++) {
                        Escrever(m[j][i],m[j2][i]);
//                        bufferedWriter.write(String.valueOf(-m[j][i]));
//                        bufferedWriter.write(" ");
//                        bufferedWriter.write(String.valueOf(-m[j2][i]));
//                        bufferedWriter.write(" ");
//                        bufferedWriter.write("0");
//                        bufferedWriter.newLine();
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void CNFDiagonalPrincipal(int n){
        try {
            bufferedWriter.write("c Restrição das Diagonais Principais");
            bufferedWriter.newLine();
            l = new int [n][2];
            for (int i = 0; i < n - 1; i++) {
                //Print diagonal
                for (int x = i; x < n; x++){

                }
                for (int j = 0; j < n - (i + 1); j++) {
                    for (int k = j + 1; k < n - i ; k++) {
//                        l[t][0] = m[j][j + i] * (-1);
//                        l[t][1] = m[k][k + i] * (-1);
                        Escrever(m[j][j + i],m[k][k + i]);
                    }
                }
            }

            for (int i = 1; i < n - 1; i++) {
//                System.out.println("I="+ i);
                //Print diagonal
                for (int j = 1; j < n ; j++) {
//                    System.out.println("J= " + j);
                    for (int k = j + 1; k < n ; k++) {
//                        l[t][0] = m[j][j - i] * (-1);
//                        l[t][1] = m[k][k - i] * (-1);
//                        System.out.println("K="+k);
                        if((j-i) >= 0 && (k-i) >= 0){
                            Escrever(m[j][j - i],m[k][k - i]);
//                            System.out.println(m[j][j - i] +" "+ m[k][k - i]);
                        }
//                        System.out.println("---------");
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void CNFDiagonalSegundaria(int n){
        try {
            bufferedWriter.write("c Restrição das Diagonais Segundarias");
            bufferedWriter.newLine();
            for (int i = 0; i < n - 1; i++) {
//                System.out.println("I="+i);
                for (int j = 0; j < n - (i + 1) ; j++) {
//                    System.out.println("J="+j);
                    for (int k = j +1; k < n - i ; k++) {
//                        System.out.println("K="+k);
//                        l[t][0] = m[j][j - i] * (-1);
//                        l[t][1] = m[k][k - i] * (-1);
                        Escrever(m[j][n-1-j-i],m[k][n-k-1-i]);
//                        System.out.println(m[j][n-1-j-i]+" "+m[k][n-k-1-i]);
//                        System.out.println("-----------------------");
                    }
                }
            }

            int c;
//            System.out.println("N="+n);
            for (int i = 1; i < n ; i++) {
//                System.out.println("I="+i);
                c = 1;
                for (int j = i; j < n; j++) {
//                    System.out.println("J="+j);
                    for (int k = j + 1; k < n; k++) {
//                        System.out.println("K="+k);
//                        l[t][0] = m[j][c] * (-1);
//                        l[t][1] = m[k][c - (k - 1)] * (-1);
                        Escrever(m[j][n-c],m[k][n-(c+1)]);
//                        System.out.println(m[j][n-c]+" "+m[k][n-(c+1)]);
//                        System.out.println("-----------");
                    }
                    c++;
                }
            }
        }catch (IOException e){

        }
    }

    private void print(int n){
        for (int i = 0; i < n; i++){
            for(int k = 0; k < 2; k++){
                System.out.print(l[i][k] + " ");
            }
            System.out.println();
        }
    }


    private void Escrever(int x, int y){
        try{
            bufferedWriter.write(String.valueOf(-x));
            bufferedWriter.write(" ");
            bufferedWriter.write(String.valueOf(-y));
            bufferedWriter.write(" ");
            bufferedWriter.write("0");
            bufferedWriter.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
