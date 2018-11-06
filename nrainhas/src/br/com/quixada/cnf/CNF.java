package br.com.quixada.cnf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CNF {
    private int m[][];

    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public CNF(int n){
        InicializarMatriz(n);
        try{
            file = new File("outrainha"+String.valueOf(n)+".txt");
            file.createNewFile();
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("p cnf ");
            bufferedWriter.write(String.valueOf(n*n));
            bufferedWriter.write(" ");
            bufferedWriter.write(String.valueOf((n*7)*2)); //acresentar formula das colunas
            bufferedWriter.newLine();
            CNFLinha(n);
            CNFColuna(n);
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){

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
            bufferedWriter.write("c Linha");
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
            bufferedWriter.write("c Coluna");
            bufferedWriter.newLine();
        }catch (IOException e){

        }
    }

    private void CNFColuna(int n) {
        try{
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

        }
    }
}
