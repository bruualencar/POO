package quest04_Bruna;

import java.io.BufferedReader;
import java.io.FileReader;


public class Multiplicar {
	 public static void main(String[] args) {
	        try {
	            
	            BufferedReader MatrizOne = new BufferedReader(new FileReader("C:\\Users\\bruna\\eclipse-workspace\\AV2_BRUNA\\src\\quest04_Bruna\\matrizOne.txt"));
	            BufferedReader MatrizTwo = new BufferedReader(new FileReader("C:\\Users\\bruna\\eclipse-workspace\\AV2_BRUNA\\src\\quest04_Bruna\\matrizTwo.txt"));

	            String linhaOne = MatrizOne.readLine();
	            String linhaTwo = MatrizTwo.readLine();

	            String[] tamanhoOne = linhaOne.split(" ");
	            int linhasOne = Integer.parseInt(tamanhoOne[0]);
	            int colunasOne = Integer.parseInt(tamanhoOne[1]);

	            String[] tamanhoTwo = linhaTwo.split(" ");
	            int linhasTwo = Integer.parseInt(tamanhoTwo[0]);
	            int colunasTwo = Integer.parseInt(tamanhoTwo[1]);

	           
	            if (colunasOne != linhasTwo) {
	                System.out.println("Não é possível multiplicar as matrizes.");
	                MatrizOne.close();
	                MatrizTwo.close();
	                return;
	            }

	            
	            int[][] matrizOne = new int[linhasOne][colunasOne];
	            int[][] matrizTwo = new int[linhasTwo][colunasTwo];

	            for (int i = 0; i < linhasOne; i++) {
	                linhaOne = MatrizOne.readLine();
	                String[] elementos = linhaOne.split(" ");
	                for (int j = 0; j < colunasOne; j++) {
	                    matrizOne[i][j] = Integer.parseInt(elementos[j]);
	                }
	            }

	            for (int i = 0; i < linhasTwo; i++) {
	                linhaTwo = MatrizTwo.readLine();
	                String[] elementos = linhaTwo.split(" ");
	                for (int j = 0; j < colunasTwo; j++) {
	                    matrizTwo[i][j] = Integer.parseInt(elementos[j]);
	                }
	            }

	            MatrizOne.close();
	            MatrizTwo.close();

	            
	            int[][] matrizResultado = new int[linhasOne][colunasTwo];
	            for (int i = 0; i < linhasOne; i++) {
	                for (int j = 0; j < colunasTwo; j++) {
	                    for (int k = 0; k < colunasOne; k++) {
	                        matrizResultado[i][j] += matrizOne[i][k] * matrizTwo[k][j];
	                    }
	                }
	            }

	            
	            System.out.println("Resultado:");
	            for (int i = 0; i < linhasOne; i++) {
	                for (int j = 0; j < colunasTwo; j++) {
	                    System.out.print(matrizResultado[i][j] + " ");
	                }
	                System.out.println();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
