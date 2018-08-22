package br.com.terkina.base.model;

import java.util.Collection;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = DefaultItem.class)
public interface Item {
	Long getId();
	String getDescricao();
	
	static Item create(final Long id, final String description) {
		return new DefaultItem(id, description); 
	}
	
	static Collection<Long> findIds(final Collection<Item> items) {
		return items.stream().map(Item::getId).collect(Collectors.toList());
	}
}