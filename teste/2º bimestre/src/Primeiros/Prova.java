package Primeiros;
import javax.swing.*;
class Fila1
{
	int tamanho, inicio, fim, total;
	double vetor[];
	Fila1(int tam)
	{
		inicio = 0;
		fim=0;
		total = 0;
		tamanho = tam;
		vetor = new double[tam];
	}

	public boolean Fila1Vazia( )
	{
		if (total == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean Fila1Cheia( )
	{
		if (total >= tamanho)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void Enfileirar (double elemento)
	{
		if (! Fila1Cheia( ))
		{
			vetor[fim] = elemento;
			fim=fim+1 ;
			total = total + 1;
			if (fim >= tamanho)
			{
				fim=0;
			}
		}
		else
		{
			System.out.println ("Fila1 Cheia");
		}
	}

	public double Desenfileirar ()
	{
		double desenfileirado = 0.0;
		if (Fila1Vazia())
		{
			System.out.println("Fila1 Vazia");
		}
		else
		{
			desenfileirado = vetor[inicio];
			inicio = inicio + 1;
			total = total - 1;
			if (inicio >= tamanho)
			{
				inicio = 0;
			}
		}
		return desenfileirado;
	}

	public void ElementoInicio( )
	{
		if (!Fila1Vazia())
		{
			System.out.println("O primeiro elemento � "+ vetor[inicio]);
		}
		else
		{
			System.out.println("Fila1 Vazia");
		}
	}

	public void MostrarFila1( )
	{
		int i, aux;
		aux = inicio;
		for ( i=1;i<= total ; i++)
		{
			JOptionPane.showMessageDialog(null, "Elemento " + vetor[aux] + " posi��o "+i );
			aux=aux+1 ;
		if (aux >= tamanho)
		{
			aux=0 ;
		}
		}
	}
}
