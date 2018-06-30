package br.com.terkina.base.converter;

public interface Converter<SOURCE,TARGET> {

	public abstract TARGET convert(SOURCE source);
}