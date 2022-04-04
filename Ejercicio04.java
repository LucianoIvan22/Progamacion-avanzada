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
	public int[][] obtenerDiagonalesMatriz(int[][] matriz) {

		// La cantidad de diagonales de una matriz cuadrada es el doble del orden de la
		// matriz - 1
		int ordenMatriz = matriz.length;
		int cantidadDiagonales = ordenMatriz * 2 - 1;

		int[][] matrizResultado = new int[cantidadDiagonales][];

		// Voy a recorrer la matriz resultado por fila, de abajo hacia arriba
		int indiceX = ordenMatriz - 1;
		int indiceY = 0;
		int tam = 1;

		for (int diagonal = 0; diagonal < cantidadDiagonales; diagonal++) {
			// Arranco con un extremo
			int auxIndiceX = indiceX;
			int auxIndiceY = indiceY;
			matrizResultado[diagonal] = new int[tam];
			// Incremento indiceX e indiceY +1 para poder recorrer la diagonal hasta que
			// algun indice supere el rango (ordenMatriz)
			while (auxIndiceX < ordenMatriz && auxIndiceY < ordenMatriz) {

				matrizResultado[diagonal][auxIndiceY - indiceY] = matriz[auxIndiceX][auxIndiceY];
				auxIndiceX++;
				auxIndiceY++;
			}

			// Si el indice X llego a 0, no lo puedo decrementar mas. Recorro la matriz por
			// columnas
			if (indiceX == 0) {
				indiceY++;
				tam--;
			} else {
				indiceX--;
				tam++;
			}
		}

		return matrizResultado;
	}

	public static void main(String[] args) {

		//int[][] matriz = { { 1, 2, -3 }, { 5, -6, -6 }, { 1, 1, 10 } };
		int[][] matriz = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		Ejercicio04 ejercicioTest = new Ejercicio04();

		System.out.println("Matriz de ejemplo: ");
		ejercicioTest.mostrarMatriz(matriz);

		int[][] matrizDeDiagonales = ejercicioTest.obtenerDiagonalesMatriz(matriz);

		System.out.println("Matriz de diagonales: ");
		ejercicioTest.mostrarMatriz(matrizDeDiagonales);
	}

	public void mostrarMatriz(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}

	}
}
