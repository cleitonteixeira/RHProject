package br.com.nutribemrefeicoescoletivas.mail;

import br.com.nutribemrefeicoescoletivas.bean.UsuarioBean;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class ConfigMail {
    
    public void enviaEmailFormatoHtml(UsuarioBean ub) throws EmailException, MalformedURLException {
	
	HtmlEmail email = new HtmlEmail();
	
	// adiciona uma imagem ao corpo da mensagem e retorna seu id
	//URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
	//String cid = email.embed(url, "Apache logo");	
	
	// configura a mensagem para o formato HTML
	email.setHtmlMsg("<html>Logo do Apache - <img ></html>");

	// configure uma mensagem alternativa caso o servidor não suporte HTML
	email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
	
	email.setHostName("smtp.nutribemrefeicoescoletivas.com.br"); // o servidor SMTP para envio do e-mail
	email.addTo( ub.getEmail(), ub.getNome() ); //destinatário
	email.setFrom("contato@nutribemrefeicoescoletivas.com.br", "Não responda"); // remetente
	email.setSubject("Teste -> Html Email"); // assunto do e-mail
	email.setMsg("Seu usuário no sistema do RH-Nutribem é "+ub.getLogin()+" ./n E sua senha é "+ub.getSenha()+" ./n Troque sua senha no primeiro login."); //conteudo do e-mail
	email.setAuthentication("ti@nutribemrefeicoescoletivas.com.br", "Nutri@1748");
	email.setSmtpPort(587);
	//email.setSSLCheckServerIdentity(true);
	// envia email
	email.send();
    }
    
}
