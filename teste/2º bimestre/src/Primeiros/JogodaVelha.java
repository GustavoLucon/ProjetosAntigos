package Primeiros;
import javax.swing.JOptionPane;

public class JogodaVelha {
	public static void enchermatriz(String matriz[][])
	{
		for (int i = 0 ; i < 3 ; i++)
		{
			for (int j = 0 ; j < 3 ; j++)
			{
			matriz[i][j] = "-" ;	
			}
		}
	}
	public static void printamatriz(String matriz[][])
	{
		System.out.print(" ");
		for (int i = 0 ; i < 3 ; i++)
		{
			System.out.print(i);
		}
		for (int k = 0 ; k < 3 ; k++)
		{
			System.out.print("\n" + k);
			for (int l = 0 ; l < 3 ; l++)
			{
			System.out.print(matriz[k][l]);
			}
		}
		System.out.println("");
		System.out.println("O = Jogador1 e X = Jogador2");
	}
	public static void ler(String matriz[][] , String jog , String jog2)
	{
		int teste= 0;
		if (matriz[0][1]== "X" || matriz[0][1]== "O")
		{
			if(matriz[0][0] == "X" && matriz[0][2] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[0][0] == "O" && matriz[0][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
		}
		if (matriz[1][1]== "X" || matriz[1][1]== "O")
		{
			if(matriz[1][0] == "X" && matriz[1][2] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[0][0] == "X" && matriz[2][2] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[0][2] == "X" && matriz[2][0] == "X")
			{
			System.out.println(jog + " Venceu");
			teste++;
			}
			if(matriz[1][0] == "O" && matriz[1][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
			if(matriz[0][0] == "O" && matriz[2][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
			if(matriz[0][2] == "O" && matriz[2][0] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
		}
		if (matriz[2][1]== "X" || matriz[2][1]== "O")
		{
			if(matriz[2][0] == "X" && matriz[2][2] == "X")
			{
			System.out.println(jog + " Venceu");	
			teste++;
			}
			if(matriz[2][0] == "O" && matriz[2][2] == "O")
			{
			System.out.println(jog2 + " Venceu");
			teste++;
			}
		}
		if (matriz[1][0]== "X" || matriz[1][0]== "O")
		{
			if(matriz[0][0] == "X" && matriz[0][2] == "X")
			{
			System.out.println(jog + " Venceu");	
			teste++;
			}
			if(matriz[0][0] == "O" && matriz[0][2] == "O")
			{
			System.out.println(jog2 + " Venceu");	
			teste++;
			}
		}
		if (matriz[1][2]== "X" || matriz[1][2]== "O")
		{
			if(matriz[2][0] == "X" && matriz[2][2] == "X")
			{
			System.out.println(jog + " Venceu");	
			teste++;
			}
			if(matriz[2][0] == "O" && matriz[2][2] == "O")
			{
			System.out.println(jog2 + " Venceu");	
			teste++;
			}
		}
		if(teste == 1)
		{
			printamatriz(matriz);
			System.exit(0);
		}
	}
	public static void main (String args[]){
	{
		String tabuleiro[][] = new String [3][3];
		String jogador , jogador2;
		int linha , coluna;
		enchermatriz(tabuleiro);
		jogador = JOptionPane.showInputDialog (null ,"Digite o nome do primeiro jogador ");
		jogador2 = JOptionPane.showInputDialog (null ,"Digite o nome do segundo jogador ");
		for(int p = 0 ; p < 9 ; p++)
		{
			printamatriz(tabuleiro);
			linha = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero da linha"));
			coluna = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero da coluna"));
			if (linha < 4 && coluna < 4)
			{
				if ((p % 2 ) == 0 )
				{
					tabuleiro[linha][coluna] = "O";
				}
				else
				{
					tabuleiro[linha][coluna] = "X";
				}
				ler(tabuleiro,jogador,jogador2);
			}			
			else
			{
				System.out.println("Numero invalido");
				p--;
			}
			if(p == 9)
			{
				System.out.println("Deu velha");
			}
		}
		
		
	
	}
	}
}