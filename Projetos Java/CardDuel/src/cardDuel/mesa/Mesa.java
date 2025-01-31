package cardDuel.mesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cardDuel.baralho.Baralho;
import cardDuel.baralho.Carta;
import cardDuel.jogador.Jogador;
import cardDuel.telas.CampoBatalha;
import cardDuel.telas.mesa.SelecionarStatus;

public class Mesa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Jogador[] listaJogadores;
	private JLabel lblJogador_2;
	private JLabel lblJogador_3;
	private JLabel Jog3;
	private JLabel jog4;
	private JLabel label;
	private JLabel lblCartas_2;
	private JLabel lblCartas_3;
	private JLabel lblCartas_1;
	private int turno =0;
	private JLabel lblCartas;
	private JButton btoJog3;
	private JButton btoJog2;
	private JButton btoJog1;
	private JButton btoJog4;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */

	public Mesa(int qtJogadores, int bots, String nomeJogador) {
		setResizable(false);
		
		
		listaJogadores = new Jogador[qtJogadores];
		IniciarBaralho(listaJogadores, bots);
		CriarJogadores(nomeJogador,bots);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblJogador = new JLabel(listaJogadores[0].getNome());
		lblJogador.setBounds(377, 45, 73, 14);
		contentPane.add(lblJogador);

		JLabel lblJogador_1 = new JLabel(listaJogadores[1].getNome());
		lblJogador_1.setBounds(377, 219, 59, 14);
		contentPane.add(lblJogador_1);

		String nomeJog3;
		String nomeJog4;
		if(qtJogadores >= 4)
		{
			nomeJog4 = listaJogadores[3].getNome();
		}
		else
		{
			nomeJog4 = "";
		}
		
		if(qtJogadores >= 3)
		{
			nomeJog3 = listaJogadores[2].getNome();
		}
		else
		{
			nomeJog3 = "";
		}
		
		
		lblJogador_2 = new JLabel(nomeJog4);
		lblJogador_2.setBounds(381, 555, 65, 14);
		contentPane.add(lblJogador_2);

		lblJogador_3 = new JLabel(nomeJog3);
		lblJogador_3.setBounds(374, 383, 65, 14);
		contentPane.add(lblJogador_3);

		
		jog4 = new JLabel("");
		jog4.setVerticalAlignment(SwingConstants.TOP);
		jog4.setIcon(new ImageIcon(Mesa.class
				.getResource("/cardDuel/imagens/jogadores/MARIO.JPG")));
		jog4.setBounds(66, 364, 107, 127);
		contentPane.add(jog4);

		Jog3 = new JLabel("");
		Jog3.setVerticalAlignment(SwingConstants.TOP);
		Jog3.setIcon(new ImageIcon(Mesa.class
				.getResource("/cardDuel/imagens/jogadores/LINK.JPG")));
		Jog3.setBounds(65, 536, 107, 132);
		contentPane.add(Jog3);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/Kirby.JPG")));
		lblNewLabel_2.setBounds(64, 196, 101, 127);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setIcon(new ImageIcon(Mesa.class
				.getResource("/cardDuel/imagens/jogadores/Samus.JPG")));
		lblNewLabel_3.setBounds(79, 26, 91, 120);
		contentPane.add(lblNewLabel_3);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mesa.this.dispose();
			}
		});

		btnSair.setBounds(185, 683, 96, 23);
		contentPane.add(btnSair);
		
		lblCartas = new JLabel("Cartas:");
		lblCartas.setBounds(377, 82, 59, 14);
		contentPane.add(lblCartas);
		
		lblCartas_1 = new JLabel("Cartas:");
		lblCartas_1.setBounds(374, 421, 73, 14);
		contentPane.add(lblCartas_1);
		
		lblCartas_2 = new JLabel("Cartas:");
		lblCartas_2.setBounds(377, 253, 66, 14);
		contentPane.add(lblCartas_2);
		
		lblCartas_3 = new JLabel("Cartas:");
		lblCartas_3.setBounds(381, 593, 65, 14);
		contentPane.add(lblCartas_3);
		
		btoJog1 = new JButton("");
		btoJog1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar (0);
				ConferirBotoes();
				
			}
		});
		btoJog1.setBounds(364, 112, 91, 23);
		contentPane.add(btoJog1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(255, 45, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCartas_4 = new JLabel("Cartas");
		lblCartas_4.setBounds(255, 82, 46, 14);
		contentPane.add(lblCartas_4);
		
		JLabel lblNewLabel = new JLabel("Minha Vez?");
		lblNewLabel.setBounds(255, 117, 79, 14);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/Untitled-1.png")));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 494, 161);
		contentPane.add(label);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(255, 219, 46, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblCartas_5 = new JLabel("Cartas");
		lblCartas_5.setBounds(255, 253, 46, 14);
		contentPane.add(lblCartas_5);
		
		JLabel lblMinhaVez = new JLabel("Minha vez?");
		lblMinhaVez.setBounds(255, 289, 79, 14);
		contentPane.add(lblMinhaVez);
		
		JLabel label_4 = new JLabel("Minha vez?");
		label_4.setBounds(255, 458, 79, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Cartas");
		label_5.setBounds(266, 421, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Nome");
		label_6.setBounds(266, 383, 46, 14);
		contentPane.add(label_6);
		
		btoJog2 = new JButton("");
		btoJog2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar (1);
				ConferirBotoes();
			}
		});
		btoJog2.setBounds(364, 285, 91, 23);
		contentPane.add(btoJog2);
		
		btoJog3 = new JButton("");
		btoJog3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar (2);
				ConferirBotoes();
			}
		});
		btoJog3.setBounds(360, 454, 101, 23);
		contentPane.add(btoJog3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/Untitled-1.png")));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 350, 494, 161);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/Untitled-1.png")));
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 183, 494, 161);
		contentPane.add(label_3);
		
		JLabel label_7 = new JLabel("Nome");
		label_7.setBounds(261, 555, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Cartas");
		label_8.setBounds(261, 593, 46, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Minha vez?");
		label_9.setBounds(261, 629, 73, 14);
		contentPane.add(label_9);
		
		btoJog4 = new JButton("");
		btoJog4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 comparar (3);
					ConferirBotoes();
			}
		});
		btoJog4.setBounds(366, 625, 91, 23);
		contentPane.add(btoJog4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/Untitled-1.png")));
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 522, 494, 161);
		contentPane.add(label_2);
		
		
		lblJogador_2.setVisible(false);
		Jog3.setVisible(false);
		lblJogador_3.setVisible(false);
		jog4.setVisible(false);
		lblCartas_1.setVisible(false);
		lblCartas_3.setVisible(false);
		AtualizarCartasJogador(listaJogadores.length);
	
		

		if (qtJogadores == 3) {
			lblJogador_2.setVisible(true);
			Jog3.setVisible(true);
			lblCartas_2.setVisible(true);
		}
		if (qtJogadores == 4) {
			lblJogador_2.setVisible(true);
			Jog3.setVisible(true);
			lblJogador_3.setVisible(true);
			jog4.setVisible(true);
			lblCartas_1.setVisible(true);
			lblCartas_3.setVisible(true);
		}
		
		ConferirBotoes();
				
		
	}



	private void CriarJogadores( String nomeJogador, int bots) {
		listaJogadores[0].setMinhaVez(true);
		listaJogadores[0].setNome(nomeJogador);
		int numBots = bots;
		 for(int i = 1 ;i < listaJogadores.length;i++)
		 {
			 if(numBots > 0)
			 {
				 listaJogadores[i].setComputador(true);
				 listaJogadores[i].setNome("BOT " + i);
				 numBots--;
			 }
			 else
			 {
				 listaJogadores[i].setComputador(false);
				 listaJogadores[i].modificarNomeJogador(JOptionPane.showInputDialog("Digite o nome do "+ i + "� Jogador"));
				 
			 }
		 }
		
	}



	public void ConferirBotoes() {
		int vez = VezDeQuem();
		if(vez == 0)
		{
			btoJog1.setEnabled(true);
			btoJog2.setEnabled(false);
			btoJog3.setEnabled(false);
			btoJog4.setEnabled(false);
			btoJog1.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/sim.png")));
			btoJog2.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog3.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog4.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
		}
		else if(vez == 1)
		{
			btoJog1.setEnabled(false);
			btoJog2.setEnabled(true);
			btoJog3.setEnabled(false);
			btoJog4.setEnabled(false);
			btoJog1.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog2.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/sim.png")));
			btoJog3.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog4.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
		}
		else if(vez == 2)
		{
			btoJog1.setEnabled(false);
			btoJog2.setEnabled(false);
			btoJog3.setEnabled(true);
			btoJog4.setEnabled(false);
			btoJog1.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog2.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog3.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/sim.png")));
			btoJog4.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
		}
		else if(vez == 3)
		{
			btoJog1.setEnabled(false);
			btoJog2.setEnabled(false);
			btoJog3.setEnabled(false);
			btoJog4.setEnabled(true);
			btoJog1.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog2.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog3.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/nao.png")));
			btoJog4.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/jogadores/sim.png")));
		}
		
	}



	public void AtualizarCartasJogador(int numJogadores) {
		lblCartas.setText("" + listaJogadores[0].getQuantidadeCartas());
		lblCartas_2.setText("" + listaJogadores[1].getQuantidadeCartas());
		if(numJogadores == 3)
		{
			lblCartas_1.setText("" + listaJogadores[2].getQuantidadeCartas());
		}
		if(numJogadores == 4)
		{
			lblCartas_1.setText("" + listaJogadores[2].getQuantidadeCartas());
			lblCartas_3.setText("" + listaJogadores[3].getQuantidadeCartas());
		}
	}



	public void compararBOT (int idJogador)
	{
		SelecionarStatus frame = new SelecionarStatus();
		if(conferirAlguemGanhou() == false)
		{
			frame.EnviarCarta(listaJogadores[idJogador].getBaralho().getCarta(turno),turno,idJogador,this);
			frame.comparar(buscarMelhorStatus(idJogador));
		}
		turno++;
		AtualizarCartasJogador(listaJogadores.length);		
		ConferirBotoes();
	}


	
	public void comparar (int idJogador)
	{
		SelecionarStatus frame = new SelecionarStatus();
		if(conferirAlguemGanhou() == false)
		{
			frame.EnviarCarta(listaJogadores[idJogador].getBaralho().getCarta(turno),turno,idJogador,this);
			frame.setVisible(true);
		}
		turno++;
		AtualizarCartasJogador(listaJogadores.length);		
		ConferirBotoes();
	}

	
	

	public void VezDoBot() {
		
		for(int i = 0 ; i < listaJogadores.length;i++)
		{
			if(listaJogadores[i].isMinhaVez())
			{
				if(listaJogadores[i].isComputador())
				{
					RodadaDoBot(i);
				}
			}
		}
	}



	private void RodadaDoBot(int numBot) {
		
		if(listaJogadores[numBot].isComputador())
		{
		JOptionPane.showMessageDialog(null,"BOT " + numBot + " seleciona " +StatusIntParaNome(buscarMelhorStatus(numBot)));
		compararBOT(VezDeQuem());
		}
		
	}



	private String StatusIntParaNome(int numMelhorStatus) {
		String nomeStatus = "";
		if(numMelhorStatus == 0)
		{
			nomeStatus = "Ataque";
		}
		else 		if(numMelhorStatus == 1)
		{
			nomeStatus = "Defesa";
		}
		else 		if(numMelhorStatus == 2)
		{
			nomeStatus = "Magia";
		}
		else 		if(numMelhorStatus == 3)
		{
			nomeStatus = "Defesa MAgia";
		}
		else 		if(numMelhorStatus == 4)
		{
			nomeStatus = "Velocidade";
		}
		return nomeStatus;
	}



	private int buscarMelhorStatus(int numBot) {
		int maior = 0;
		int status = 0;
		
		if(listaJogadores[numBot].getBaralho().getCarta(turno).getAtaque() > maior)
		{
			maior = listaJogadores[numBot].getBaralho().getCarta(turno).getAtaque();
			status = 0;
		}
		if(listaJogadores[numBot].getBaralho().getCarta(turno).getDefesa() > maior)
		{
			maior = listaJogadores[numBot].getBaralho().getCarta(turno).getDefesa();
			status = 1;
		}
		if(listaJogadores[numBot].getBaralho().getCarta(turno).getMagia() > maior)
		{
			maior = listaJogadores[numBot].getBaralho().getCarta(turno).getMagia();
			status = 2;
		}
		if(listaJogadores[numBot].getBaralho().getCarta(turno).getDefesaMagia() > maior)
		{
			maior = listaJogadores[numBot].getBaralho().getCarta(turno).getDefesaMagia();
			status = 3;
		}
		if(listaJogadores[numBot].getBaralho().getCarta(turno).getVelocidade() > maior)
		{
			maior = listaJogadores[numBot].getBaralho().getCarta(turno).getVelocidade();
			status = 4;
		}
		
		
		return status;
	}


	
	private void FimDeJogo() {
			for(int i = 0 ; i < listaJogadores.length;i++)
			{

					listaJogadores[i].setMinhaVez(false);

			}
		
	}
	
	private int VezDeQuem() {
		
		for(int i = 0 ; i < listaJogadores.length;i++)
		{
			if(listaJogadores[i].isMinhaVez())
			{
				return i;
			}
		}
		return 0 ;

		
	}



	private boolean conferirAlguemGanhou() {
		String cartas = "";
		boolean vitoria = false;
		for(int i = 0 ; i < listaJogadores.length;i++)
		{
			cartas = cartas + "Jogador " + (i + 1) + " Tinha " + listaJogadores[i].getQuantidadeCartas() + "\n";
			if(listaJogadores[i].getQuantidadeCartas() == 10 * listaJogadores.length)
			{
				vitoria = true;
				JOptionPane.showMessageDialog(null,"Jogador " + (i + 1) + " VENCEU");
				FimDeJogo();
			}
		}
		if(vitoria)
		{
		JOptionPane.showMessageDialog(null,"Score final \n " + cartas);
		Mesa.this.dispose();
		}
		return vitoria;
	}

	private void IniciarBaralho(Jogador[] jogador, int bots) {
		jogador[0] = new Jogador();
		Baralho baralho = new Baralho();
		baralho.montarBaralho();
		jogador[0].setBaralho(baralho);

		for (int i = 1; jogador.length > i; i++) {
			Baralho baralho2 = new Baralho();
			baralho2.montarBaralho();
			jogador[i] = new Jogador();
			jogador[i].setBaralho(baralho2);
			if (bots > 0) {
				jogador[i].setComputador(true);
				bots--;
			}

		}

		baralho = new Baralho();
		baralho.montarBaralho();

	}
	public Jogador[] getListaJogadores() {
		return listaJogadores;
	}

	public void setListaJogadores(Jogador[] listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
}
