package br.com.api.g1.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.api.g1.entities.User;

@Configuration
@Service
public class EmailService {

	@Autowired
	UserService userService ;
	private JavaMailSender emailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private Integer port;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();
		emailSender.setHost(host);
		emailSender.setPort(port);
		emailSender.setUsername(username);
		emailSender.setPassword(password);
		prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
		emailSender.setJavaMailProperties(prop);
		return emailSender;
	}
	
	public void envioEmailCadastro() { // é esse método que vamos copiar 
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("apiserrag1@gmail.com");
			helper.setTo("lucasjosegoncalves.original@gmail.com");
			helper.setSubject("Cadastro concluido!");

			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			<h1>Cadastro realizado com sucesso!</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			Em caso de erro, favor contatar o suporte: serratecgrupo1@gmail.com");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");

			helper.setText(builder.toString(), true);
			emailSender.send(mensagemCadastro);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	public void envioEmailTeste() {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("apiserrag1@gmail.com");
			helper.setTo("lucasjosegoncalves.original@gmail.com");
			helper.setSubject("Cadastro concluido!");
			
			LocalDate localDate=LocalDate.now();
			DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataEntrega=localDate.plusDays(7).format(format);//simula uma data para entrega.
			
			Double valor=15.9;//Valor fixo so para exemplo. Se quiser usar devemos passar um "Pedido pedido" entre os parenteses do "public void envioEmailTeste"nesse caso. 
			DecimalFormat df= new DecimalFormat("R$ ,##0.00");//Formata o valor do produto
			
			StringBuilder builder= new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("<body>\r\n");
			builder.append("<div align=\"center\">\r\n");
			builder.append("<h1>Convite</h1>\r\n");
			builder.append("</div>\r\n");
			builder.append("<br/>\r\n");
			
			builder.append("<center>");
			builder.append("<table border='2' cellpadding='4'>\r\n");
			builder.append("<tr><th> Nome</th> <th> Email</th><th> Perfis</th><th> Data de Entrega</th> </tr> \r\n");
			
			List<User>listaUsuarios=userService.listarTodos();
			for(User user : listaUsuarios) {
				builder.append("		    <tr>\r\n");
				builder.append("			<td>\r\n");
				builder.append(user.getNomeUsuario());
				builder.append("			</td>\r\n");
				builder.append("			<td>\r\n");
				builder.append(user.getEmail());
				builder.append("			</td>\r\n");
				builder.append("		    <td>\r\n");
				builder.append(user.getRoles());
				builder.append("			</td>\r\n");
				builder.append("			<td>\r\n");
				builder.append(dataEntrega);
				builder.append("			</td>\r\n");
			}
			
			builder.append("		</table>\r\n");
			builder.append("		</center>\r\n");
			builder.append("		<table border='1' cellpadding='1'  >\r\n");
			builder.append("<tr><th>Valor Total</th></tr>\r\n");
			builder.append("			<td>\r\n");
			builder.append(df.format(valor));
			builder.append("			</td>\r\n");
			builder.append("		</table>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>");
			
			helper.setText(builder.toString(), true);
			emailSender.send(mensagemCadastro);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void envioEmailInativo() {  
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("apiserrag1@gmail.com");
			helper.setTo("lucasjosegoncalves.original@gmail.com");
			helper.setSubject("Cadastro Inativo!");
			
			StringBuilder builder= new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			<h1>Seu cadastro foi CANCELADO com Sucesso!</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			Caso não reconheça essa ação, favor contatar o suporte: apiserrag1@gmail.com");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");
		
			helper.setText(builder.toString(), true);
			emailSender.send(mensagemCadastro);
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void envioEmailPedidoCancel() { 
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("apiserrag1@gmail.com");
			helper.setTo("lucasjosegoncalves.original@gmail.com");
			helper.setSubject("Pedido Cancelado!");
			
			StringBuilder builder= new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			<h1>Seu Pedido foi CANCELADO com Sucesso!</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			Caso não reconheça essa ação, favor contatar o suporte: apiserrag1@gmail.com");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");
		
			helper.setText(builder.toString(), true);
			emailSender.send(mensagemCadastro);
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void envioEmailPedidoRealizado() { 
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("apiserrag1@gmail.com");
			helper.setTo("lucasjosegoncalves.original@gmail.com");
			helper.setSubject("Pedido Realizado!");
			
			StringBuilder builder= new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("	<body>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			<h1>Seu Pedido foi REALIZADO com Sucesso!</h1>\r\n");
			builder.append("		</div>\r\n");
			builder.append("		<br/>\r\n");
			builder.append("		<div align=\"center\">\r\n");
			builder.append("			Caso não reconheça essa ação, favor contatar o suporte: apiserrag1@gmail.com");
			builder.append("		</div>\r\n");
			builder.append("	</body>\r\n");
			builder.append("</html>\r\n");
		
			helper.setText(builder.toString(), true);
			emailSender.send(mensagemCadastro);
		}
		
		
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
