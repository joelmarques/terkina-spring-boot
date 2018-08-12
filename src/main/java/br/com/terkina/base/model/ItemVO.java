package br.com.terkina.base.model;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ItemVO implements Item {

	private Long id;
	private String descricao;
	
	public static Collection<Long> convert(final Collection<Item> registros) {
		return registros.stream().map(Item::getId).collect(Collectors.toList());
	}
}