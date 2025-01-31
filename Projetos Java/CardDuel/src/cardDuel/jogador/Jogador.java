package cardDuel.jogador;

import cardDuel.baralho.Baralho;
import cardDuel.baralho.Carta;

public class Jogador {

	private String nome;
	private Baralho baralho = new Baralho();
	private boolean computador;
	private int quantidadeCartas;
	private boolean morreu = false;
	private boolean minhaVez;
	
	public boolean isMinhaVez() {
		return minhaVez;
	}

	public void setMinhaVez(boolean minhaVez) {
		this.minhaVez = minhaVez;
	}
	

	public String modificarNomeJogador(String nomeJogador) {
		
		if (nomeJogador != null && !nomeJogador.equals("")) {
			nome = nomeJogador;
		}
		else{
			nome =" Player";
		}
		return nome;
	}

	public Jogador() {
		quantidadeCartas = 10;
		
	}
	
	public boolean getMorreu() {
		return morreu;
	}

	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	public int getQuantidadeCartas() {
		return quantidadeCartas;
	}

	public void setQuantidadeCartas(int quantidadeCartas) {
		this.quantidadeCartas = quantidadeCartas;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public void adicionarCarta(Carta c)
	{
		this.baralho.adicionarCarta(c);
		this.quantidadeCartas = this.quantidadeCartas +1;
	}
	
	public void removerCarta(Carta c)
	{

		this.baralho.removerCarta(c);
		this.quantidadeCartas = this.quantidadeCartas -1;
		ConfereMorreu();
	}
	private void ConfereMorreu() {
		if(this.quantidadeCartas <= 0)
		{
			morreu = true;
		}
		
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public boolean isComputador() {
		return computador;
	}

	public void setComputador(boolean computador) {
		this.computador = computador;
	}

	public int SelecionarMaior(int atributo,int numcarta) {
		int maior = 0;

			if (atributo == 0 && baralho.getCarta(numcarta).getAtaque() > maior) {
				maior = baralho.getCarta(numcarta).getAtaque();
			}
			if (atributo == 1 && baralho.getCarta(numcarta).getDefesa() > maior) {
				maior = baralho.getCarta(numcarta).getDefesa();
			}
			if (atributo == 2 && baralho.getCarta(numcarta).getMagia() > maior) {
				maior = baralho.getCarta(numcarta).getMagia();
			}
			if (atributo == 3 && baralho.getCarta(numcarta).getDefesaMagia() > maior) {
				maior = baralho.getCarta(numcarta).getDefesaMagia();
			}
			if (atributo == 4 && baralho.getCarta(numcarta).getVelocidade() > maior) {
				maior = baralho.getCarta(numcarta).getVelocidade();
			}

		return maior;
	}
	
	public Carta SelecionarMaiorCarta(int atributo,int numcarta) {
		int maior = 0;
		Carta c = null;

			if (atributo == 0 && baralho.getCarta(numcarta).getAtaque() > maior) {
				maior = baralho.getCarta(numcarta).getAtaque();
				c = baralho.getCarta(numcarta);
			}
			if (atributo == 1 && baralho.getCarta(numcarta).getDefesa() > maior) {
				maior = baralho.getCarta(numcarta).getDefesa();
				c= baralho.getCarta(numcarta);
			}
			if (atributo == 2 && baralho.getCarta(numcarta).getMagia() > maior) {
				maior = baralho.getCarta(numcarta).getMagia();
				c = baralho.getCarta(numcarta);
			}
			if (atributo == 3 && baralho.getCarta(numcarta).getDefesaMagia() > maior) {
				maior = baralho.getCarta(numcarta).getDefesaMagia();
				c = baralho.getCarta(numcarta);
			}
			if (atributo == 4 && baralho.getCarta(numcarta).getVelocidade() > maior) {
				maior = baralho.getCarta(numcarta).getVelocidade();
				c = baralho.getCarta(numcarta);
			}
		return c;
	}

}
