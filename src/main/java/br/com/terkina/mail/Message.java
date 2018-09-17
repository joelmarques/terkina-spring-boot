package br.com.terkina.mail;

public interface Message {
	
	String getSubject();
	String getTo();
	String getBody();
}