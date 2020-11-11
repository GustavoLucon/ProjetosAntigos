package Jogo1a8;

public class Tabuleiro {

	public static int tabuleiro[][] = new int[3][3];
	public static int ideal[][] = new int[3][3];

	public void fazerIdeal() {
		int contador = 1;
		for(int i= 0;i < ideal.length;i++)
		{
			for(int j=0;j<ideal[i].length;j++ ){
				ideal[i][j] = contador;
				contador++;
				if(contador == 9)
					contador = 0;
			}
		}
	}
	public void mostrarMatriz(int[][] tab) {
		for (int i=0; i<tab.length; i++) {
			for (int j=0; j<tab[i].length; j++) {
				System.out.printf("%d ", tab[i][j]);
				}
			System.out.println();
			}


	}
	public void Randomiza() {
		tabuleiro[0][0] = 1; 	
		tabuleiro[1][0] = 4;
		tabuleiro[2][0] = 7;
		tabuleiro[0][1] = 3;
		tabuleiro[1][1] = 2;
		tabuleiro[2][1] = 8;
		tabuleiro[0][2] = 5;
		tabuleiro[1][2] = 0;
		tabuleiro[2][2] = 6;
	}

	
	public static int[][] getTabuleiro() {
		return tabuleiro;
	}

	public static void setTabuleiro(int[][] tabuleiro) {
		Tabuleiro.tabuleiro = tabuleiro;
	}

	public static void setTabula(int[][] is) {
		tabuleiro = is;
	}
	public static void compararMatrizes(int[][] tab1, int tab2[][]){
		if(tab1.equals(tab2))
			System.out.println("fim");
		else{
			int distancia = 0;
			for(int i= 0;i < ideal.length;i++){
				for(int j= 0;j<ideal[i].length;j++ ){
					if(tab1[i][j] != tab2[i][j]){
								if(tab1[i][j] != 0)
								{
								distancia = distancia + Buscar(tab1[i][j],j,i,tab2);
								}
								}
				}
			}
			System.out.println("\n Distancia � de " + distancia);
		}
	}
	private static int Buscar(int buscado, int coluna, int linha, int[][] tab1) {
		int buscadolinha = 0, buscadoColuna = 0;
		int distancia = 0;
		for(int i= 0;i < ideal.length;i++){
			for(int j= 0;j<ideal[i].length;j++ ){
				if(tab1[i][j] == buscado)
				{
					buscadolinha = i;
					buscadoColuna = j;
				}
					
			}
		}
		while (coluna != buscadoColuna)
		{
			if(buscadoColuna > coluna)
			{
				coluna++;
				distancia++;
			}
			else
			{
				coluna--;
				distancia++;
			}
		}
		while (linha != buscadolinha)
		{
			if(buscadolinha > linha)
			{
				linha++;
				distancia++;
			}
			else
			{
				linha--;
				distancia++;
			}
		}
		
		return distancia;
	}
}
