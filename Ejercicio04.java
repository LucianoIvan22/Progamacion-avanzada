// Ejercicio04 - obtencion de las diagonales de una matriz
//Escribir un método en Java que de una matriz cuadrada dada, devuelva una matriz con
//n filas, donde cada una tendrá los datos de una de las diagonales 
//(de abajo a la izquierda hacia arriba a la derecha)

//Ejemplo:
//Para la matriz
// 1  2  3  4 
// 5  6  7  8 
// 9 10 11 12 
//13 14 15 16 
//
//La salida debe ser:
//13
// 9 14
// 5 10 15
// 1  6 11 16
// 2  7 12
// 3  8
// 4

public class Ejercicio04 {
	public int[][] obtencionDeDiagonales(int[][] matriz) {
		int tam = 0, cols = 0, fils = matriz.length - 1, nuevaFila = 0, cantDiagonales = matriz.length * 2 - 1;
		int[][] nuevaMatriz = new int[cantDiagonales][];
		while (nuevaFila < cantDiagonales) {
			nuevaMatriz[nuevaFila] = new int[tam + 1];
			for (int j = cols, i = fils; j < matriz.length && i < matriz.length; j++, i++) {
				nuevaMatriz[nuevaFila][j - cols] = matriz[i][j];
			}
			nuevaFila++;
			if (nuevaFila < matriz.length) {
				fils--;
				tam ++;
			}
			else {
				cols++;
				tam--;
			}
		}
		return nuevaMatriz;
	}

	public static void main(String[] args) {
		int[][] matriz = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Ejercicio04 ejercicio04 = new Ejercicio04();
		int[][] resultado = ejercicio04.obtencionDeDiagonales(matriz);
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++)
				System.out.print(resultado[i][j] + "  ");
			System.out.println();
		}
	}
}
