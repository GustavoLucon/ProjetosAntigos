package Email;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.TimeZone;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.swing.JOptionPane;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

	public class SendMailUsingGmail {
		//Feito Por Gustavo Pestana Lucon
	    private static Date d = new Date();
	    private static GregorianCalendar datahora;
	    private static TimeZone timezone;
		public static void main(String args[])  throws Exception {
			datahora = new GregorianCalendar();
	    	timezone = TimeZone.getTimeZone("GMT-03:00");
	    	TimeZone.setDefault(timezone);
	        datahora.setTimeZone(timezone);
	        d = datahora.getTime();
	        d.setYear(1900 + d.getYear());
	        System.out.print(d.getYear());
	        if(d.getYear() == 2011 || d.getYear() == 2012)
	        {
			String [] ReceberArquivo = ImportarEmail("C:\\RML-MAIL.TXT");
			String LOG;
			Escrever("",Caminho);
			if(ReceberArquivo[1].equals("")||ReceberArquivo[2].equals("")||ReceberArquivo[3].equals("")||ReceberArquivo[4].equals(""))
			{
	        	 Escrever("Erro De Variavel Faltando",CaminhoErro); 
	        	 System.exit(0);
			}
			SMTP_HOST_NAME = ReceberArquivo[1];
			emailFromAddress = ReceberArquivo[4];
			emailSubjectTxt = ReceberArquivo[6];
			emailMsgTxt = ReceberArquivo[9];
			LOG = "De:" + ReceberArquivo[4] + "   Para:" + ReceberArquivo[7] + "   Texto:" + ReceberArquivo[9] +"\n Hora e Data " + d.getDate();
			String [] Limpo = PreencherSoComStrings(ReceberArquivo);
			sendTo = Limpo;

			Escrever(LOG,CaminhoLog);
			Security.addProvider(
		new com.sun.net.ssl.internal.ssl.Provider());
		new SendMailUsingGmail().sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt, emailFromAddress,ReceberArquivo[2],ReceberArquivo[3],ReceberArquivo[5],ReceberArquivo[9],ReceberArquivo[8]);
		}
	        else
	        {
	        	Escrever("Erro de Tempo",CaminhoLog);
	        	JOptionPane.showMessageDialog(null, "Erro de Tempo");
	        	System.exit(0);
	        }
		}
		private static String Caminho = "RML-MAIL.TXT";
		private static String CaminhoLog = "LOG.TXT";
		private static String CaminhoErro = "ERRO.TXT";
		private static String SMTP_HOST_NAME ="";
		private static final String SMTP_PORT = "25";
		private static String emailMsgTxt ="";
		private static String emailSubjectTxt ="";
		private static String emailFromAddress ="";
		private static final String SSL_FACTORY ="javax.net.ssl.SSLSocketFactory";
		private static String[] sendTo = {""};
		private static String[] PreencherSoComStrings(String[] teste) {
			int cont = 0;
			int altura=0;
			String palavra  = "";
			String b[] = teste[7].split("");
			for(int a = 0 ;a < b.length;a++)
			{
				if(b[a].equals(","))
				{
					cont++;
				}
			}
			
			String limpo[] = new String[cont];
			for(int a = 0 ;a < b.length;a++)
			{
				if(b[a].equals(","))
				{
					limpo[altura] = palavra;
					palavra = "";
					altura++;		
				}
				else
				{
					palavra = palavra + b[a];
				}
			}
			return limpo;
		}
		public void sendSSLMessage(String recipients[], String subject,
		String message, String from,final String Login , final String Senha  ,final String Apelido,String Texto, String Anexo) throws MessagingException{

		Properties props = new Properties();
		if(SMTP_HOST_NAME.equals("Gustav@Lucon"))
		{
			Escrever("Este Programa Foi Feito Por Gustavo Pestana Lucon \nNa Data 18/12/2010 \nVers�o 1.0 \n Atualizada Versao 1.1 em 12/01/2011\nTenha Um Bom Dia",CaminhoLog); 
			System.exit(0);			
		}
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.fallback", "false");  
		if(SMTP_HOST_NAME.equals("smtp.oi.com.br") == false)
		{
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		}
		props.put("mail.smtp.socketFactory.fallback", "true");
		Session session = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication
				(Login,Senha);
				
				}
		}
		);

	
		Message msg = new MimeMessage(session);
		try {
			if(Anexo.equals("") == false)
			{
	         try{
			  MimeMultipart mpRoot = new MimeMultipart("mixed");  
			         MimeMultipart mpContent = new MimeMultipart("alternative");  
			         MimeBodyPart contentPartRoot = new MimeBodyPart();  
			         contentPartRoot.setContent(mpContent);  
			         mpRoot.addBodyPart(contentPartRoot);  
			           
			         //enviando texto  
			         MimeBodyPart mbp1 = new MimeBodyPart();  
			         mbp1.setText(Texto);  
			         mpContent.addBodyPart(mbp1);  
			           
			         //enviando html  
			         MimeBodyPart mbp2 = new MimeBodyPart();  
			         mbp2.setContent(Texto.replace("\n","<BR>"), "text/html");  
			         mpContent.addBodyPart(mbp2);  
			           
			         //enviando anexo  
			         MimeBodyPart mbp3 = new MimeBodyPart();  
			         DataSource fds = new FileDataSource(Anexo);  
			         mbp3.setDisposition(Part.ATTACHMENT);  
			         mbp3.setDataHandler(new DataHandler(fds));  
			         mbp3.setFileName(fds.getName()); 
			         
			         mpRoot.addBodyPart(mbp3); 
			         
			         msg.setContent(mpRoot);  
			         msg.saveChanges();  
	         }
	         catch (Exception e) {  
	        	 Escrever("Erro De Arquivo Invalido \n \n" + e,CaminhoErro);
	        	 JOptionPane.showMessageDialog(null, "Erro de Envio");
	        	 System.exit(0);
	         }
			}
		InternetAddress addressFrom = new InternetAddress(from);
		try {
			if(Apelido.equals("") == false)
			{
			addressFrom.setPersonal(Apelido);
			}
			else
			{
			addressFrom.setPersonal(from);
			}
		} catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
			 Escrever("Erro De Envio",CaminhoErro);
			 JOptionPane.showMessageDialog(null, "Erro de Envio");
			 System.exit(0);
		}	
		msg.setFrom(addressFrom);
		InternetAddress[] addressTo =	new InternetAddress[recipients.length];
		
		for (int i = 0; i < recipients.length; i++) {
		addressTo[i] = new InternetAddress(recipients[i]);
		
		}
		msg.setRecipients(Message.RecipientType.BCC, addressTo);
		
		msg.setSubject(subject);
		if(Anexo.equals(""))
		{
		msg.setContent(message, "text/plain");
		}
		msg.saveChanges();
		Transport.send(msg);
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		}
		}	
		private static String[] ImportarEmail(String Caminho) { 
			String[] Vetor = new String[10];
			
		       Vetor = PreencherVetor(Vetor);
		       try {  
		          BufferedReader leitor = new BufferedReader(new FileReader(Caminho));
		          String linhas;
		          linhas = leitor.readLine();
		          String palavra = "";
		          int cont = 0 ;
		          int i = 0 ;
		          int a = 0 ;
		          String[] b= linhas.split("");
		   
		          while (linhas != null) 
		          {  
		        	  b= linhas.split("");
		        			if(b.length > a)
		        			{
		        			if(b[1].equals("#")&& b[2].equals("1")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				Vetor[1] = Vetor[1] + b[a];
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("2")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				Vetor[2] = Vetor[2] + b[a];
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("3")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				Vetor[3] = Vetor[3] + b[a];
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("4")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				Vetor[4] = Vetor[4] + b[a];
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("5")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				Vetor[5] = Vetor[5] + b[a];
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("6")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				Vetor[6] = Vetor[6] + b[a];
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("7")&& b[3].equals("#"))
		        			{
		        				while(b[2].equals("8") == false)
		        				{
		        					if(b.length > a)
				        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				if(b[a].equals(",") == false)
			        			{
			        				palavra = palavra + b[a];
			        				a++;
			        			}
			        			else
			        			{
			        				Vetor[7]= palavra + ","+ Vetor[7];
			        				palavra = "";
			        				cont++;
			        				a++;
			        			}
		        				}
			        			else
			        			{
								i=0;
								a=0;
								linhas = leitor.readLine();
								b= linhas.split("");
			        			}
		        				}
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("8")&& b[3].equals("#"))
		        			{
		        				if(linhas.equals("#8#")== false)
		        				{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				linhas.replace("\\\\", "\\");
		        				Vetor[8] = Vetor[8] + b[a];
		        				}
		        			}
		        			else if(b[1].equals("#")&& b[2].equals("9")&& b[3].equals("#"))
		        			{
		        				if(a == 1)
		        				{
		        				a=4;
		        				}
		        				if(b[a].equals(";"))
		        						{
		        				Vetor[9] = Vetor[9] + "\n";
		        						}
		        				else
		        				{
		        					Vetor[9] = Vetor[9] + b[a];
		        				}
		        			}
		        			
		        			i++;
		        			
		        			}
		        			else
		        			{
							i=0;
							a=0;
							linhas = leitor.readLine();

		        			}
		        			a++;
		    			}  
		        		
		        	    
		        	            leitor.close();  
		        	             
		        	     
		        	         } catch (Exception e) {  
		        	        	 Escrever("Erro De Variavel Incorreta\n \n" + e,CaminhoErro);
		        	        	 JOptionPane.showMessageDialog(null, "Erro de Envio");
		        	        	 System.exit(0);
		        	        }
		        	        
		      return Vetor;                                
		
	}
		private static String[] PreencherVetor(String[] vetor) {
			for (int i = 0 ;i< vetor.length;i++)
			{
					vetor[i]="";
			}
			return vetor;
		}
        private static void Escrever(String Texto, String caminho) {
       	 try {  
       	
       		          File arquivo;  
       		   
       		          arquivo = new File(caminho);  
       		          FileOutputStream fos = new FileOutputStream(arquivo);        		        
       		          fos.write(Texto.getBytes());  
       		          fos.close();  
       }
		       catch (Exception ee) {  
    		          ee.printStackTrace(); 
    		          Escrever("Erro De Escrita\n \n" + ee,CaminhoErro); 
    		          JOptionPane.showMessageDialog(null, "Erro de Envio");
     	        	 System.exit(0);
    		       }  
       }
	}
