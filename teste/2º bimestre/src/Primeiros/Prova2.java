package Primeiros;
import javax.swing.JOptionPane;


public class Prova2 {
	public static void main (String args[])
	{
		int lista1[] = {25 , 57 ,48 , 37 , 100 , 12 , 92 , 86 ,33 ,25 ,57 , 25 , 12 , 86, 12};
		int lista2[] = {92 ,86,100,33,25};
		int lista3[] = new int[7];
		int cont = 0;
		for(int i = 0 ; i < 5 ; i++ )
		{
			for (int p = 0 ; p < 15 ; p++)
			{
			if(lista2[i] == lista1[p])
			{
			lista1[p] = 110;	                
			}
			}
		}
		for(int i = 0 ; i < 15 ; i++ )
		{
			if (lista1[i] != 110)
			{
			lista3[cont] = lista1[i];
			cont++;
			}
		}
		for(int o = 0 ; o < 7 ; o++ )
		{
			System.out.println(lista3[o]);
		}
		
	}
}
