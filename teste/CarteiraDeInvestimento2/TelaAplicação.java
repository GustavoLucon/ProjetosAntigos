package CarteiraDeInvestimento2;

import javax.swing.JOptionPane;

public class TelaAplica��o extends javax.swing.JFrame {

	  private Instrumento aplicacao[] = new Instrumento[99999];   
	    private int altura = 0;

		
    public TelaAplica��o() {
        initComponents();
    }  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        caixa3 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        caixa3.setColumns(20);
        caixa3.setRows(5);
        caixa3.setEnabled(false);

        jScrollPane1.setViewportView(caixa3);

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 48)); // NOI18N
        jLabel1.setText("Aplica��o");

        jLabel2.setText("Lista De Aplica��es");

        jButton1.setText("Inserir Aplica��o");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar Aplica��o");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exibir Aplica��es");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Excluir Aplica��o");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Voltar a Pagina Principal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    	String nome = JOptionPane.showInputDialog("Digite o nome da a��o");
    	double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da a��o"));
    	int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de cria��o da a��o"));
    	int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de cria��o da a��o"));
    	int rendimentototal = Integer.parseInt(JOptionPane.showInputDialog("Digite o rendimento final do mesmo (Por cento)"));
    	int duracao = Integer.parseInt(JOptionPane.showInputDialog("Digite a dura��o do mesmo(em meses)"));
    	aplicacao[altura]= new AplicacaoPre(valor,mes,ano,duracao,rendimentototal);
    	aplicacao[altura].setDescricao(nome);
    	altura++;    
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	   String busca = JOptionPane.showInputDialog("Digite o nome do fundo");
    	    for(int b=0; b < altura;b++){
	    	if(aplicacao[b].getDescricao().equals(busca)){
    	    		ImprimirVar(b);
	    	}
    	    }
    
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	for(int b=0; b < altura;b++){
    		caixa3.setText(caixa3.getText() + "\n"  + aplicacao[b].getDescricao()); 
    	}
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    	String deletar = JOptionPane.showInputDialog("Digite o nome da acao que voce quer Deletar"); 
    	for(int a = 0 ;a < altura;a++)
	        {
  		 if(aplicacao[a].getDescricao().equals(deletar))
    			 ImprimirVar(a);
    		 int digite = Integer.parseInt(JOptionPane.showInputDialog("Digite 1829"));
    		 if(digite == 1829)
    		 {
    		 int b;
    		 	for(b = a ;b < altura;b++)
    		 	{
    		 		if(aplicacao[b+1]!= null)
    		 		{
    		 		aplicacao[b] = aplicacao[b+1];
    		 		}
    		 		else
    		 		{
    		 			aplicacao[b] = null;
    		 		}
 	        	}
    		 	altura--;
    		 	caixa3.setText("");
	        }
	        }
    	System.out.print("Fun�ao desativada");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    }
     public double CalcularSaldo() {
     	double Soma = 0;
     	for(int b=0; b < altura;b++){
         	Soma = Soma + aplicacao[b].valor() ;
     	}
     	return Soma;
     	
     }
	    public String Relatorio() {
	    	String juntos = "";
	    	for(int b=0; b < altura;b++){
	    		juntos = juntos + "\nNome : " + aplicacao[b].getDescricao() + " Saldo: " + aplicacao[b].valor();	
	    	}
	    	return juntos;
	   	    }
    private void ImprimirVar(int local) {
    	caixa3.setText("Nome : " + aplicacao[local].getDescricao() + " Saldo: " + aplicacao[local].valor());
    }
    public double CalcularTotal()
    {
    	double total=0;
    	for(int i = 0 ; i < altura;i++)
    	{
    	total = total + aplicacao[i].valor(); 	
    	}
    	return total;
    }

    // Variables declaration - do not modify
    private javax.swing.JTextArea caixa3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
   
}
