package Primeiros;
import javax.swing.JOptionPane;


public class Tabuada {
	public static void main (String args[]){
	int tabuada[] = new int [11];
	int numero = 0 ;
	numero = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero"));
	for(int p = 0; p < 11 ; p++)
	{
		tabuada[p] = numero * p ;
	}
	for(int i = 0; i < 11 ; i++)
	{
		System.out.println(numero + " X " + i + " = " + tabuada[i]);
	}
	}
}
