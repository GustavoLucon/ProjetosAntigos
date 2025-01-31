package cardDuel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import cardDuel.mesa.Mesa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CampoBatalha extends JFrame {

	private JPanel contentPane;
	private JLabel nomeJog2;
	private JLabel StatusJog2;
	private JLabel nomeJog1;
	private JLabel AtribJog2;
	private JLabel AtribJog1;
	private JLabel StatusJog1;
	private JLabel nomeJog3;
	private JLabel AtribJog3;
	private JLabel StatusJog3;
	private JLabel nomeJog4;
	private JLabel AtribJog4;
	private JLabel StatusJog4;
	private JLabel resultado;
	private JLabel lblNewLabel;
	private Mesa mesa;
	private int winner;
	private JLabel lblNewLabel_1;
	
	
	public CampoBatalha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 200, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nomeJog2 = new JLabel("");
		nomeJog2.setBounds(168, 11, 113, 14);
		contentPane.add(nomeJog2);
		
		StatusJog2 = new JLabel("");
		StatusJog2.setBounds(168, 36, 113, 14);
		contentPane.add(StatusJog2);
		
		AtribJog2 = new JLabel("");
		AtribJog2.setBounds(168, 61, 113, 14);
		contentPane.add(AtribJog2);
		
		nomeJog1 = new JLabel("");
		nomeJog1.setBounds(168, 254, 113, 14);
		contentPane.add(nomeJog1);
		
		AtribJog1 = new JLabel("");
		AtribJog1.setBounds(168, 304, 113, 14);
		contentPane.add(AtribJog1);
		
		StatusJog1 = new JLabel("");
		StatusJog1.setBounds(168, 279, 113, 14);
		contentPane.add(StatusJog1);
		
		nomeJog3 = new JLabel("");
		nomeJog3.setBounds(10, 142, 113, 14);
		contentPane.add(nomeJog3);
		
		AtribJog3 = new JLabel("");
		AtribJog3.setBounds(10, 192, 113, 14);
		contentPane.add(AtribJog3);
		
		StatusJog3 = new JLabel("");
		StatusJog3.setBounds(10, 167, 113, 14);
		contentPane.add(StatusJog3);
		
		nomeJog4 = new JLabel("");
		nomeJog4.setBounds(319, 142, 113, 14);
		contentPane.add(nomeJog4);
		
		AtribJog4 = new JLabel("");
		AtribJog4.setBounds(319, 192, 113, 14);
		contentPane.add(AtribJog4);
		
		StatusJog4 = new JLabel("");
		StatusJog4.setBounds(319, 167, 113, 14);
		contentPane.add(StatusJog4);
		
		resultado = new JLabel("");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(168, 160, 113, 21);
		contentPane.add(resultado);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CampoBatalha.class.getResource("/cardDuel/imagens/jogadores/Umbrella_Corporation_Dock_Icon_by_SilentBang.png")));
		lblNewLabel.setBounds(319, 254, 100, 75);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CampoBatalha.class.getResource("/cardDuel/imagens/jogadores/Umbrella_Corporation_Dock_Icon_by_SilentBang.png")));
		label.setBounds(10, 11, 100, 75);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CampoBatalha.class.getResource("/cardDuel/imagens/jogadores/Umbrella_Corporation_Dock_Icon_by_SilentBang.png")));
		label_1.setBounds(332, 11, 100, 75);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CampoBatalha.class.getResource("/cardDuel/imagens/jogadores/Umbrella_Corporation_Dock_Icon_by_SilentBang.png")));
		label_2.setBounds(10, 254, 100, 75);
		contentPane.add(label_2);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FimDoTurno();
				CampoBatalha.this.dispose();
			}
		});
		btnSair.setBounds(168, 333, 91, 23);
		contentPane.add(btnSair);
		
		lblNewLabel_1 = new JLabel("Venceu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(168, 192, 91, 14);
		contentPane.add(lblNewLabel_1);
	}
	protected void FimDoTurno() {
		ProximoTurno(winner);
		
		mesa.AtualizarCartasJogador(mesa.getListaJogadores().length);
		mesa.ConferirBotoes();
		mesa.VezDoBot();
		
	}
	public void setResultado(String verificar) {
		this.resultado.setText(verificar);
	}
	
	public void CriarCampo(Mesa mesa , int winner) {
		this.mesa = mesa;
		this.winner = winner;
	}
	

	public void setValoresCampos(int selecionado,String nome , String maior, String status) {
		switch(selecionado){
		case 0:
			this.nomeJog1.setText(nome);
			this.AtribJog1.setText(maior);
			this.StatusJog1.setText(status);
			break;
		case 1:
			this.nomeJog2.setText(nome);
			this.AtribJog2.setText(maior);
			this.StatusJog2.setText(status);
			break;
		case 2:
			this.nomeJog3.setText(nome);
			this.AtribJog3.setText(maior);
			this.StatusJog3.setText(status);
			break;
		case 3:
			this.nomeJog4.setText(nome);
			this.AtribJog4.setText(maior);
			this.StatusJog4.setText(status);
			break;
		}
	}

	private void ProximoTurno(int winner) {


		if(mesa.getListaJogadores()[winner].isMinhaVez() == false)
		{
			for(int i = 0 ; i < mesa.getListaJogadores().length;i++)
			{
				if(winner != i)
				{
					mesa.getListaJogadores()[i].setMinhaVez(false);
				}
			}
			mesa.getListaJogadores()[winner].setMinhaVez(true);
		}

	}
}
