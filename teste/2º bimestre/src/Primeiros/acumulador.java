package Primeiros;
import javax.swing.JOptionPane;


public class acumulador {
	public static void main (String args[]){
		int A[] = new int [5];
		int B[] = new int [5];
		int C[] = new int [12];
		for(int p = 0; p < 5 ; p++)
		{
			A[p] = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero para A "));
			
		}
		for(int p = 0; p < 5 ; p++)
		{
			B[p] = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero para B"));
			
		}
		for(int p = 0; p < 11 ; p++)
		{
			if(p < 5)
			{
				C[p] = A[p];
			}
			if(p >= 5)
			{
				C[p] = B[p];
			}
			
		}
		for(int p = 0; p < 5 ; p++)
		{
			System.out.println(A[p]);	
		}
		for(int p = 0; p < 5 ; p++)
		{
			System.out.println(B[p]);	
		}
		for(int p = 0; p < 10 ; p++)
		{
			System.out.println(C[p]);	
		}
	
		
	}

}
