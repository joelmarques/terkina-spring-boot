package br.com.terkina.base.mail;

import java.util.Map;

public interface TemplateMessage extends Message {
	
	String getTemplateName();
	Map<String, Object> getVariables();
}