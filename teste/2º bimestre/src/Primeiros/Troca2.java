package Primeiros;
import javax.swing.JOptionPane;

public class Troca2 {
		public static void main (String args[])
		{
			int x , y ;
			x = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o 1� numero"));
			y = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o 2� numero"));
			System.out.println("A ordem � " + x + " � o primeiro e " + y + " � o segundo " );
			x = x + y ;
			y = y - x ;
			y = y * -1 ;
			x = x - y ;
			System.out.println("Trocando a ordem � " + x + " � o primeiro e " + y + " � o segundo " );
		}
	}


