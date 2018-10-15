package br.com.terkina.base.mail;

public interface Message {
	
	String getSubject();
	String getTo();
	String getBody();
}