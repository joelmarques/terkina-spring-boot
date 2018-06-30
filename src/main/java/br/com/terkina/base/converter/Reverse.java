package br.com.terkina.base.converter;

public interface Reverse<SOURCE,TARGET> {
	
	public abstract TARGET revert(SOURCE source);
}