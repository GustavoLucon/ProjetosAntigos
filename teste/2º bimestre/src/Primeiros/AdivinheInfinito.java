package Primeiros;
import java.util.Random;

import javax.swing.JOptionPane;


public class AdivinheInfinito {
	public static void main (String args[])
	{
		int fornecido ;
		int resposta = 0;
		Random random = new Random();
		while (resposta == 0)
			{
			int randomico = random.nextInt(50);
		if (randomico > 0 && randomico < 51)
		{
			System.out.println("Estou Pensando Em Um Numero Entre 1 e 50 . Adivinhe .");
					for(int cont = 1 ; cont < 100 ; cont++ )
			{
			fornecido = Integer.parseInt(JOptionPane.showInputDialog (null ,cont + "� tentativa"));
			if(fornecido <= 50 && fornecido > 0)
				{
				if(randomico == fornecido)
			{
				System.out.println("Voce acertou");
				cont = 100;
			}
			else if (randomico > fornecido)
			{
				System.out.println("Tente aumentar o numero");
			
			}
			else if (randomico < fornecido)
			{
				System.out.println("Tente diminuir o numero");
			
			}
			else
			{
				System.out.println("Numero invalido Tente novamente" );
				cont--;
			}
			}
			}
		}
		resposta  = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite 0 se quiser continuar e 1 se nao"));
		
		}
		
	}
}
