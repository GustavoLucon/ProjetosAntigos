package Primeiros;
import javax.swing.JOptionPane;

public class recursividade {
	public static int exibir(int num)
	{
		int f;
		if(num == 0)
		{
		return 0;	
		}
		else
		{
		f = exibir(num-1) +1 ;
		System.out.println(f);
		return f ;
		}
	}
	public static void main (String args[])
	{
		int recebido ;
		recebido = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero desejado"));	
		exibir(recebido);	
	}
}
