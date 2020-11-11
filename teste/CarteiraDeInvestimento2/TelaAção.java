package CarteiraDeInvestimento2;

import javax.swing.JOptionPane;

public class TelaA��o extends javax.swing.JFrame {
	private Instrumento acao[] = new Instrumento[99999];
	private int altura = 0;


	    /** Creates new form TelaAcao */
	    public TelaA��o() {
	        initComponents();

	    }

	    /** This method is called from within the constructor to
	     * initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is
	     * always regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">
	    private void initComponents() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        caixa = new javax.swing.JTextArea();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        caixa.setColumns(20);
	        caixa.setRows(5);
	        jScrollPane1.setViewportView(caixa);

	        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 48)); // NOI18N
	        jLabel1.setText("A��es");

	        jLabel2.setText("Lista De A��es");

	        jButton1.setText("Inserir A��o");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("Buscar A��o");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Exibir Todas as A��es");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton4.setLabel("Excluir A��o");
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
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
	                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
	                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
	                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
	                            .addComponent(jButton5))
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(58, 58, 58)
	                                .addComponent(jLabel2))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(18, 18, 18)
	                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(86, 86, 86)
	                        .addComponent(jLabel1)))
	                .addContainerGap())
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
	    	  int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade De A��es"));
	    	 acao[altura] = new Acao(quantidade);
	    	  acao[altura].setDescricao(nome);
	    	  caixa.setText("Valor :" + acao[altura].valor());	    
	    	  altura++;
	    }

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	        String buscado = JOptionPane.showInputDialog("Digite o nome a ser Buscado");
	        for(int a = 0 ;a < altura;a++)
	        {
	        	if(buscado.equals(acao[a].getDescricao()))
	        	{
	        		ImprimirVar(a);
	        	}
	        }
	    }

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	        for(int a = 0 ;a < altura;a++)
	        {

	        	caixa.setText(caixa.getText() + "\n"  + acao[a].getDescricao());
	        }
	    }

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
	    	String deletar = JOptionPane.showInputDialog("Digite o nome da acao que voce quer Deletar"); 
	    	for(int a = 0 ;a < altura;a++)
		        {
	    		 if(acao[a].getDescricao().equals(deletar))
	    			 ImprimirVar(a);
	    		 int digite = Integer.parseInt(JOptionPane.showInputDialog("Digite 1829"));
	    		 if(digite == 1829)
	    		 {
	    		 int b;
	    		 	for(b = a ;b < altura;b++)
	    		 	{
	    		 		if(acao[b+1]!= null)
	    		 		{
	    		 			acao[b] = acao[b+1];
	    		 		}
	    		 		else
	    		 		{
    		 			acao[b] = null;
	    		 		}
 	        	}
    		 	altura--;
    		 	caixa.setText("");
	 	        	}
		        }
		        }

	    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
	        this.setVisible(false);
	    }
	    private void ImprimirVar(int local) {
	    	caixa.setText("Nome: "+ acao[local].getDescricao() + " Saldo: " + acao[local].valor() );
	    }

	    public double CalcularSaldo() {
	    	double Soma = 0;
	    	for(int b=0; b < altura;b++){
	    	}
	    	return Soma;
	    	
	    }
	    public String Relatorio() {
	    	String juntos = "";
	    	for(int b=0; b < altura;b++){
	    		juntos = juntos + " \nNome : " + acao[b].getDescricao() + " Saldo: " + acao[b].valor();	
	    	}
	    	return juntos;
	   	    }
	    public double CalcularTotal()
	    {
	    	double total=0;
	    	for(int i = 0 ; i < altura;i++)
	    	{
	    	total = total + acao[i].valor(); 	
	    	}
	    	return total;
	    }
	    /**
	    * @param args the command line arguments
	    */

	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextArea caixa;
	    // End of variables declaration

	}

